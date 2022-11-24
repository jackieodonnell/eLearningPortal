package com.techelevator.dao;

import com.techelevator.model.StudentCourse;
import com.techelevator.model.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

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
        dao.update(sql, studentCourse.getStudentId(), studentCourse.getCourseId());
    }

    @Override
    public List<Integer> getStudentsByCourseId(int courseId) {
        List<Integer> resultList = new ArrayList<>();
        String sql = "SELECT student_id, course_id FROM course_student WHERE course_id = ?";
        SqlRowSet result = dao.queryForRowSet(sql, courseId);
        while (result.next()) {
            StudentCourse StudentCourse = mapRowToStudentCourse(result);
            resultList.add(StudentCourse.getStudentId());
        }
        return resultList;
    }


    private StudentCourse mapRowToStudentCourse(SqlRowSet result) {
        StudentCourse studentCourse = new StudentCourse();
        studentCourse.setStudentId(result.getInt("student_id"));
        studentCourse.setCourseId(result.getInt("course_id"));
        return studentCourse;
    }


}
