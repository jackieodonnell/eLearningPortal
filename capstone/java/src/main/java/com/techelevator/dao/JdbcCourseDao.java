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
        String sql = "INSERT INTO course (course_id, teacher_id, course_title, course_description, difficulty_level, cost) " +
                "VALUES (DEFAULT, ?, ?, ?, ?, ?) RETURNING course_id;";
        return dao.queryForObject(sql, Integer.class, course.getTeacherId(), course.getCourseTitle(), course.getCourseDescription(), course.getDifficulty(), course.getCost());
    }

    @Override
    public List<Course> getAllCourses() {
        List<Course> courses = new ArrayList<>();
        String sql = "SELECT course_id, teacher_id, course_title, course_description, difficulty_level, cost FROM course;";
        SqlRowSet results = dao.queryForRowSet(sql);
        while(results.next()) {
            Course course = mapRowToCourse(results);
            courses.add(course);
        }
        return courses;
    }

    @Override
    public Course getCourseById(int courseId) {
        Course course = null;
        String sql = "SELECT course_id, teacher_id, course_title, course_description, difficulty_level, cost FROM course " +
                "WHERE course_id = ?;";
        SqlRowSet results = dao.queryForRowSet(sql);
        while (results.next()) {
            course = mapRowToCourse(results);
        }
        return course;
    }

    @Override
    public void updateCourse(Course course) {
        String sql = "UPDATE course SET teacher_id = ?, course_title = ?, course_description = ?, difficulty_level = ?, cost = ? " +
                "WHERE course_id = ?;";
        dao.update(sql, course.getTeacherId(), course.getCourseTitle(), course.getCourseDescription(), course.getDifficulty(), course.getCost(), course.getCourseId());
    }

    @Override
    public void deleteCourse(Course course) {
        String sql = "DELETE FROM course WHERE course_id = ?;";
        dao.update(sql, course.getCourseId());
    }

    private Course mapRowToCourse(SqlRowSet result) {
        Course course = new Course();
        course.setCourseId(result.getInt("course_id"));
        course.setTeacherId(result.getInt("teacher_id"));
        course.setCourseTitle(result.getString("course_title"));
        course.setCourseDescription(result.getString("course_description"));
        course.setDifficulty(result.getString("difficulty_level"));
        course.setCost(result.getBigDecimal("cost"));
        return course;
    }
}
