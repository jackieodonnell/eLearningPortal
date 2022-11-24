package com.techelevator.dao;

import com.techelevator.model.JoinedGrades;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcJoinedGradesDao implements JoinedGradesDao{

    private JdbcTemplate dao;

    public JdbcJoinedGradesDao(JdbcTemplate dao) {
        this.dao = dao;
    }


    @Override
    public int addJoinedGrade(JoinedGrades joinedGrades) {
        String sql = "INSERT INTO grades (grade_id, student_id, assignment_id, course_id, total_points, earned_points, status, submission_content, feedback) " +
                "VALUES (DEFAULT, ?, ?, ?, ?, ?, DEFAULT, ?, ?) RETURNING grade_id ;";
        return dao.queryForObject(sql, Integer.class, joinedGrades.getStudentId(), joinedGrades.getAssignmentId(), joinedGrades.getCourseId(), joinedGrades.getTotalPoints(), joinedGrades.getEarnedPoints(), joinedGrades.getSubmissionContent(), joinedGrades.getFeedback());
    }

    @Override
    public List<JoinedGrades> getAllJoinedGrades() {
        List<JoinedGrades> joinedGradesList = new ArrayList<>();
        String sql = "SELECT grade_id, course_id, student_id, grades.assignment_id, users.first_name, users.last_name, assignment.assignment_title, total_points, earned_points, status, submission_content, feedback FROM grades " +
                "JOIN users ON users.user_id = grades.student_id " +
                "JOIN assignment ON assignment.assignment_id = grades.assignment_id;";
        SqlRowSet result = dao.queryForRowSet(sql);
        while (result.next()) {
            JoinedGrades joinedGrades = mapRowToJoinedGrades(result);
            joinedGradesList.add(joinedGrades);
        }
        return joinedGradesList;
    }

    @Override
    public List<JoinedGrades> allJoinedGradesForAssignment(int assignmentId) {
        List<JoinedGrades> joinedGradesList = new ArrayList<>();
        String sql = "SELECT grade_id, course_id, student_id, grades.assignment_id, users.first_name, users.last_name, assignment.assignment_title, total_points, earned_points, status, submission_content, feedback FROM grades " +
                "JOIN users ON users.user_id = grades.student_id " +
                "JOIN assignment ON assignment.assignment_id = grades.assignment_id " +
                "WHERE grades.assignment_id = ?;";
        SqlRowSet result = dao.queryForRowSet(sql, assignmentId);
        while (result.next()) {
            JoinedGrades joinedGrades = mapRowToJoinedGrades(result);
            joinedGradesList.add(joinedGrades);
        }
        return joinedGradesList;
    }

    @Override
    public List<JoinedGrades> allJoinedGradesForStudentInCourse(int courseId, int studentId) {
        List<JoinedGrades> joinedGradesList = new ArrayList<>();
        String sql = "SELECT grade_id, course_id, student_id, grades.assignment_id, users.first_name, users.last_name, assignment.assignment_title, total_points, earned_points, status, submission_content, feedback FROM grades " +
                "JOIN users ON users.user_id = grades.student_id " +
                "JOIN assignment ON assignment.assignment_id = grades.assignment_id " +
                "WHERE course_id = ? AND student_id = ?;";
        SqlRowSet result = dao.queryForRowSet(sql, courseId, studentId);
        while (result.next()) {
            JoinedGrades joinedGrades = mapRowToJoinedGrades(result);
            joinedGradesList.add(joinedGrades);
        }
        return joinedGradesList;
    }

    @Override
    public List<JoinedGrades> allJoinedGradesForCourse(int courseId) {
        List<JoinedGrades> joinedGradesList = new ArrayList<>();
        String sql = "SELECT grade_id, course_id, student_id, grades.assignment_id, users.first_name, users.last_name, assignment.assignment_title, total_points, earned_points, status, submission_content, feedback FROM grades " +
                "JOIN users ON users.user_id = grades.student_id " +
                "JOIN assignment ON assignment.assignment_id = grades.assignment_id" +
                "WHERE course_id = ?;";
        SqlRowSet result = dao.queryForRowSet(sql, courseId);
        while (result.next()) {
            JoinedGrades joinedGrades = mapRowToJoinedGrades(result);
            joinedGradesList.add(joinedGrades);
        }
        return joinedGradesList;
    }

    @Override
    public JoinedGrades getJoinedGrade(int assignmentId, int studentId) {
        JoinedGrades joinedGrades = null;
        String sql = "SELECT grade_id, course_id, student_id, grades.assignment_id, users.first_name, users.last_name, assignment.assignment_title, total_points, earned_points, status, submission_content, feedback FROM grades " +
                "JOIN users ON users.user_id = grades.student_id " +
                "JOIN assignment ON assignment.assignment_id = grades.assignment_id " +
                "WHERE grades.assignment_id = ? and student_id = ?;";
        SqlRowSet result = dao.queryForRowSet(sql, assignmentId, studentId);
        while (result.next()) {
            joinedGrades = mapRowToJoinedGrades(result);
        }
        return joinedGrades;
    }

    @Override
    public double getJoinedCourseAverageForStudent(int courseId, int studentId) {
        double joinedAverage = 0;
        String sql = "SELECT ROUND((AVG(earned_points) / AVG(total_points)) * 100, 2) AS class_grade FROM grades WHERE course_id = ? AND student_id = ?";
        joinedAverage = dao.queryForObject(sql, Double.class, courseId, studentId);
        return joinedAverage;
    }

    @Override
    public void updateJoinedGrade(JoinedGrades joinedGrades) {
        String sql = "UPDATE grades SET student_id = ?, assignment_id = ?, course_id = ?, total_points = ?, earned_points = ?, status = ?, submission_content = ?, feedback = ? " +
                "WHERE grade_id = ?;";
        dao.update(sql, joinedGrades.getStudentId(), joinedGrades.getAssignmentId(), joinedGrades.getCourseId(), joinedGrades.getTotalPoints(), joinedGrades.getEarnedPoints(), joinedGrades.getStatus(), joinedGrades.getSubmissionContent(), joinedGrades.getFeedback(), joinedGrades.getGradeId());
    }

    @Override
    public void deleteJoinedGrade(JoinedGrades joinedGrades) {
        String sql = "DELETE FROM grades WHERE grade_id = ?;";
        dao.update(sql, joinedGrades.getGradeId());
    }

    private JoinedGrades mapRowToJoinedGrades(SqlRowSet result) {
        JoinedGrades joinedGrades = new JoinedGrades();
        joinedGrades.setGradeId(result.getInt("grade_id"));
        joinedGrades.setCourseId(result.getInt("course_id"));
        joinedGrades.setStudentId(result.getInt("student_id"));
        joinedGrades.setAssignmentId(result.getInt("assignment_id"));
        joinedGrades.setFirstName(result.getString("first_name"));
        joinedGrades.setLastName(result.getString("last_name"));
        joinedGrades.setAssignmentTitle(result.getString("assignment_title"));
        joinedGrades.setTotalPoints(result.getInt("total_points"));
        joinedGrades.setEarnedPoints(result.getInt("earned_points"));
        joinedGrades.setStatus(result.getString("status"));
        joinedGrades.setSubmissionContent(result.getString("submission_content"));
        joinedGrades.setFeedback(result.getString("feedback"));
        return joinedGrades;
    }
}
