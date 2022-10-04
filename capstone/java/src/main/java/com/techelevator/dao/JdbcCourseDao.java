package com.techelevator.dao;

import com.techelevator.model.Course;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcCourseDao implements CourseDao {

    private JdbcTemplate dao;

    public JdbcCourseDao(JdbcTemplate dao) {
        this.dao = dao;
    }

    @Override
    public int createCourse(Course course) {
        String sql = "INSERT INTO course (course_id, teacher_id, course_title, course_description, difficulty_level, cost, isArchived) " +
                "VALUES (DEFAULT, ?, ?, ?, ?, ?, ?) RETURNING course_id;";
        return dao.queryForObject(sql, Integer.class, course.getTeacherId(), course.getCourseTitle(), course.getCourseDescription(), course.getDifficulty(), course.getCost(), course.isArchived());
    }

    @Override
    public List<Course> getAllCourses() {
        List<Course> courses = new ArrayList<>();
        String sql = "SELECT course_id, teacher_id, course_title, course_description, difficulty_level, cost, isArchived FROM course;";
        SqlRowSet results = dao.queryForRowSet(sql);
        while(results.next()) {
            Course course = mapRowToCourse(results);
            courses.add(course);
        }
        return courses;
    }

    @Override
    public List<Course> getAllCoursesByStudentId(int studentId) {
        List<Course> courses = new ArrayList<>();
        String sql = "SELECT course.course_id, teacher_id, course_title, course_description, difficulty_level, cost, isArchived FROM course " +
                "JOIN course_student ON course.course_id = course_student.course_id WHERE course_student.student_id = ?;";
        SqlRowSet results = dao.queryForRowSet(sql, studentId);
        while(results.next()) {
            Course course = mapRowToCourse(results);
            courses.add(course);
        }
        return courses;
    }

    @Override
    public List<Course> getAllCoursesByTeacherId(int teacherId) {
        List<Course> courses = new ArrayList<>();
        String sql = "SELECT course_id, teacher_id, course_title, course_description, difficulty_level, cost, isArchived FROM course " +
                "WHERE teacher_id = ?;";
        SqlRowSet results = dao.queryForRowSet(sql,teacherId);
        while(results.next()) {
            Course course = mapRowToCourse(results);
            courses.add(course);
        }
        return courses;
    }

    @Override
    public Course getCourseById(int courseId) {
        Course course = null;
        String sql = "SELECT course_id, teacher_id, course_title, course_description, difficulty_level, cost, isArchived FROM course " +
                "WHERE course_id = ?;";
        SqlRowSet results = dao.queryForRowSet(sql, courseId);
        while (results.next()) {
            course = mapRowToCourse(results);
        }
        return course;
    }

    @Override
    public void updateCourse(Course course) {
        String sql = "UPDATE course SET teacher_id = ?, course_title = ?, course_description = ?, difficulty_level = ?, cost = ?, isArchived = ? " +
                "WHERE course_id = ?;";
        dao.update(sql, course.getTeacherId(), course.getCourseTitle(), course.getCourseDescription(), course.getDifficulty(), course.getCost(), course.isArchived(), course.getCourseId());
    }

    @Override
    public void deleteCourse(Course course) {
        String sql = "DELETE FROM course_student WHERE course_id = ?; " +
                "DELETE FROM course WHERE course_id = ?;";
        dao.update(sql, course.getCourseId(), course.getCourseId());
    }

    private Course mapRowToCourse(SqlRowSet result) {
        Course course = new Course();
        course.setCourseId(result.getInt("course_id"));
        course.setTeacherId(result.getInt("teacher_id"));
        course.setCourseTitle(result.getString("course_title"));
        course.setCourseDescription(result.getString("course_description"));
        course.setDifficulty(result.getString("difficulty_level"));
        course.setCost(result.getBigDecimal("cost"));
        course.setIsArchived(result.getBoolean("isArchived"));
        return course;
    }
}
