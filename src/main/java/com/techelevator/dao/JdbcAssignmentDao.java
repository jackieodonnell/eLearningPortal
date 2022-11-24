package com.techelevator.dao;

import com.techelevator.model.Assignment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcAssignmentDao implements AssignmentDao{
    private JdbcTemplate dao;

    public JdbcAssignmentDao(JdbcTemplate dao){
        this.dao = dao;
    }

    @Override
    public int createAssignment(Assignment assignment) {
        String sql = "INSERT INTO assignment (assignment_id, daily_instructions_id, assigned_date, due_date, assignment_title, assignment_description, assignment_type) " +
                "VALUES (DEFAULT, ?, ?, ?, ?, ?, ?) RETURNING assignment_id;";
        return dao.queryForObject(sql, Integer.class, assignment.getDailyInstructionsId(), assignment.getAssignedDate(), assignment.getDueDate(), assignment.getAssignmentTitle(),
                assignment.getAssignmentDescription(), assignment.getAssignmentType());
        //get the count of student in course to loop through
        //for loop through those students.length
        //for each student create a grade
    }

    @Override
    public List<Assignment> getAllAssignments() {
        List<Assignment> assignments = new ArrayList<>();
        String sql = "SELECT assignment_id, daily_instructions_id, assigned_date, due_date, assignment_title, assignment_description, assignment_type " +
                "FROM assignment;";
        SqlRowSet results = dao.queryForRowSet(sql);
        while (results.next()){
            Assignment assignment = mapRowToAssignment(results);
            assignments.add(assignment);
        }
        return assignments;
    }

    @Override
    public int getCourseIdByAssignmentId(int assignmentId) {
//        int courseId = 0;
        String sql = "SELECT course.course_id FROM course " +
        "JOIN curriculum ON curriculum.course_id = course.course_id " +
        "JOIN daily_instructions ON curriculum.curriculum_id = daily_instructions.curriculum_id " +
        "JOIN assignment ON assignment.daily_instructions_id = daily_instructions.daily_instructions_id " +
        "WHERE assignment.assignment_id = ?;";
        return dao.queryForObject(sql, Integer.class, assignmentId);

    }

    @Override
    public List<Assignment> getAllAssignmentsByInstructionId(int instructionId) {
        List<Assignment> assignments = new ArrayList<>();
        String sql = "SELECT assignment_id, daily_instructions_id, assigned_date, due_date, assignment_title, assignment_description, assignment_type " +
                "FROM assignment WHERE daily_instructions_id = ?;";
        SqlRowSet results = dao.queryForRowSet(sql, instructionId);
        while (results.next()){
            Assignment assignment = mapRowToAssignment(results);
            assignments.add(assignment);
        }
        return assignments;
    }

    @Override
    public List<Assignment> getAllAssignmentsByCurriculumId(int curriculumId) {
        List<Assignment> assignments = new ArrayList<>();
        String sql = "SELECT assignment_id, assignment.daily_instructions_id, assigned_date, due_date, assignment_title, assignment_description, assignment_types " +
                "FROM assignment JOIN daily_instructions ON assignment.daily_instructions_id = daily_instructions.daily_instructions_id " +
                "WHERE daily_instructions.curriculum_id = ?;";
        SqlRowSet results = dao.queryForRowSet(sql, curriculumId);
        while (results.next()){
            Assignment assignment = mapRowToAssignment(results);
            assignments.add(assignment);
        }
        return assignments;
    }

    @Override
    public List<Assignment> getAllAssignmentsByCourseId(int courseId) {
        List<Assignment> assignments = new ArrayList<>();
        String sql = "SELECT assignment_id, assignment.daily_instructions_id, assigned_date, due_date, assignment_title, assignment_description, assignment_type " +
                "FROM assignment JOIN daily_instructions ON assignment.daily_instructions_id = daily_instructions.daily_instructions_id " +
                "JOIN curriculum ON daily_instructions.curriculum_id = curriculum.curriculum_id " +
                "WHERE curriculum.course_id = ?;";
        SqlRowSet results = dao.queryForRowSet(sql, courseId);
        while (results.next()){
            Assignment assignment = mapRowToAssignment(results);
            assignments.add(assignment);
        }
        return assignments;
    }

    @Override
    public List<Assignment> getAllAssignmentsByStudentId(int studentId) {
        List<Assignment> assignments = new ArrayList<>();
        String sql = "SELECT assignment_id, assignment.daily_instructions_id, assigned_date, due_date, assignment_title, assignment_description, assignment_type " +
                "FROM assignment JOIN daily_instructions ON assignment.daily_instructions_id = daily_instructions.daily_instructions_id " +
                "JOIN curriculum ON daily_instructions.curriculum_id = curriculum.curriculum_id " +
                "JOIN course_student ON curriculum.course_id = course_student.course_id " +
                "WHERE course_student.student_id = ?;";
        SqlRowSet results = dao.queryForRowSet(sql, studentId);
        while (results.next()){
            Assignment assignment = mapRowToAssignment(results);
            assignments.add(assignment);
        }
        return assignments;
    }

    @Override
    public Assignment getAssignmentById(int assignmentId) {
        Assignment assignment = null;
        String sql = "SELECT assignment_id, daily_instructions_id, assigned_date, due_date, assignment_title, " +
                "assignment_description, assignment_type " +
                "FROM assignment WHERE assignment_id = ?;";
        SqlRowSet results = dao.queryForRowSet(sql, assignmentId);
        while (results.next()){
            assignment = mapRowToAssignment(results);
        }
        return assignment;
    }

    @Override
    public void updateAssignment(Assignment assignment) {
        String sql = "UPDATE assignment SET daily_instructions_id = ?, assigned_date = ?, due_date = ?, " +
                "assignment_title = ?, assignment_description = ?, assignment_type = ? " +
                "WHERE assignment_id = ?;";
        dao.update(sql, assignment.getDailyInstructionsId(), assignment.getAssignedDate(), assignment.getDueDate(),
                assignment.getAssignmentTitle(), assignment.getAssignmentDescription(), assignment.getAssignmentType(),
                assignment.getAssignmentId());
    }

    @Override
    public void deleteAssignment(Assignment assignment) {
        String sql = "DELETE FROM assignment WHERE assignment_id = ?;";
        dao.update(sql, assignment.getAssignmentId());
    }

    private Assignment mapRowToAssignment(SqlRowSet results){
        Assignment assignment = new Assignment();
        assignment.setAssignmentId(results.getInt("assignment_id"));
        assignment.setDailyInstructionsId(results.getInt("daily_instructions_id"));
        assignment.setAssignedDate(results.getDate("assigned_date").toLocalDate());
        assignment.setDueDate(results.getDate("due_date").toLocalDate());
        assignment.setAssignmentTitle(results.getString("assignment_title"));
        assignment.setAssignmentDescription(results.getString("assignment_description"));
        assignment.setAssignmentType(results.getString("assignment_type"));
        return assignment;
    }
}
