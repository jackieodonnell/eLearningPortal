package com.techelevator.dao;

import com.techelevator.model.StudentCourse;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class JdbcStudentCourseDao implements StudentCourseDao {
    private JdbcTemplate dao;

    public JdbcStudentCourseDao(JdbcTemplate dao) {
        this.dao = dao;
    }

    @Override
    public void enrollInCourse(StudentCourse studentCourse) {
        String sql = "INSERT INTO course_student (student_id, course_id) " +
                "VALUES (?, ?) ";
        dao.queryForObject(sql, Integer.class, studentCourse.getStudentId(), studentCourse.getCourseId());
    }
}
