package com.techelevator.dao;

import com.techelevator.model.Grades;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcGradesDao implements GradesDao{

    private JdbcTemplate dao;

    public JdbcGradesDao(JdbcTemplate dao) {
        this.dao = dao;
    }


    @Override
    public int addGrade(Grades grades) {
        String sql = "INSERT INTO grades (grade_id, student_id, assignment_id, course_id, total_points, earned_points, status, submission_content, feedback) " +
                "VALUES (DEFAULT, ?, ?, ?, ?, ?, ?, ?, ?) RETURNING grade_id ;";
        return dao.queryForObject(sql, Integer.class, grades.getStudentId(), grades.getAssignmentId(), grades.getCourseId(), grades.getTotalPoints(), grades.getEarnedPoints(), grades.getStatus(), grades.getSubmissionContent(), grades.getFeedback());
    }

    @Override
    public List<Grades> getAllGrades() {
        List<Grades> gradesList = new ArrayList<>();
        String sql = "SELECT grade_id, student_id, assignment_id, course_id, total_points, earned_points, status, submission_content, feedback " +
                "FROM grades;";
        SqlRowSet result = dao.queryForRowSet(sql);
        while (result.next()) {
            Grades grades = mapRowToGrades(result);
            gradesList.add(grades);
        }
        return gradesList;
    }

    @Override
    public List<Grades> allGradesForAssignment(int assignmentId) {
        List<Grades> gradesList = new ArrayList<>();
        String sql = "SELECT grade_id, student_id, assignment_id, course_id, total_points, earned_points, status, submission_content, feedback " +
                "FROM grades WHERE assignment_id = ?;";
        SqlRowSet result = dao.queryForRowSet(sql, assignmentId);
        while (result.next()) {
            Grades grades = mapRowToGrades(result);
            gradesList.add(grades);
        }
        return gradesList;
    }

    @Override
    public List<Grades> allGradesForStudentInCourse(int courseId, int studentId) {
        List<Grades> gradesList = new ArrayList<>();
        String sql = "SELECT grade_id, student_id, assignment_id, course_id, total_points, earned_points, status, submission_content, feedback " +
                "FROM grades WHERE course_id = ? AND student_id = ?;";
        SqlRowSet result = dao.queryForRowSet(sql, courseId, studentId);
        while (result.next()) {
            Grades grades = mapRowToGrades(result);
            gradesList.add(grades);
        }
        return gradesList;
    }

    @Override
    public Grades getGrade(int assignmentId, int studentId) {
        Grades grades = null;
        String sql = "SELECT grade_id, student_id, assignment_id, course_id, total_points, earned_points, status, submission_content, feedback " +
                "FROM grades WHERE assignment_id = ? and student_id = ?;";
        SqlRowSet result = dao.queryForRowSet(sql, assignmentId, studentId);
        while (result.next()) {
            grades = mapRowToGrades(result);
        }
        return grades;
    }

    @Override
    public double getCourseAverageForStudent(int courseId, int studentId) {
        double average = 0;
        String sql = "SELECT ROUND((AVG(earned_points) / AVG(total_points)) * 100, 2) AS class_grade FROM grades WHERE course_id = ? AND student_id = ?";
        average = dao.queryForObject(sql, Double.class, courseId, studentId);
        return average;
    }

    @Override
    public void updateGrade(Grades grades) {
        String sql = "UPDATE grades SET student_id = ?, assignment_id = ?, course_id = ?, total_points = ?, earned_points = ?, status = ?, submission_content = ?, feedback = ? " +
                "WHERE grade_id = ?;";
        dao.update(sql, grades.getStudentId(), grades.getAssignmentId(), grades.getCourseId(), grades.getTotalPoints(), grades.getEarnedPoints(), grades.getStatus(), grades.getSubmissionContent(), grades.getFeedback(), grades.getGradeId());
    }

    @Override
    public void deleteGrade(Grades grades) {
        String sql = "DELETE FROM grades WHERE grade_id = ?;";
        dao.update(sql, grades.getGradeId());
    }

    private Grades mapRowToGrades(SqlRowSet result) {
        Grades grades = new Grades();
        grades.setGradeId(result.getInt("grade_id"));
        grades.setStudentId(result.getInt("student_id"));
        grades.setAssignmentId(result.getInt("assignment_id"));
        grades.setCourseId(result.getInt("course_id"));
        grades.setTotalPoints(result.getInt("total_points"));
        grades.setEarnedPoints(result.getInt("earned_points"));
        grades.setStatus(result.getString("status"));
        grades.setSubmissionContent(result.getString("submission_content"));
        grades.setFeedback(result.getString("feedback"));
        return grades;
    }
}
