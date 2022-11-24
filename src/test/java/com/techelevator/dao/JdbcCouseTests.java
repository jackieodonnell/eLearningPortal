package com.techelevator.dao;

import com.techelevator.model.Course;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class JdbcCouseTests extends BaseDaoTests{

    private static final Course COURSE_1 = new Course(1,4, "course1", "courseStuff", "5", new BigDecimal("0"), false);
    private static final Course COURSE_2 = new Course(2,7, "course2", "courseStuff", "4", new BigDecimal("0"), false);

    private JdbcCourseDao sut;

    @Before
    public void setup() {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        sut = new JdbcCourseDao(jdbcTemplate);
    }

    @Test
    public void createCourse_returns_course_id() {
        Course newCourse = new Course(3, 4, "course3", "courseStuff", "6", new BigDecimal("0"), false);

        int expectedCourseId = 3;
        int actualCourseId = sut.createCourse(newCourse);

        Assert.assertEquals(expectedCourseId, actualCourseId);
    }

    @Test
    public void getAllCourses_returns_correct_list_size() {
        int expectedSize = 2;
        int actual = sut.getAllCourses().size();

        Assert.assertEquals(expectedSize, actual);
    }

    @Test
    public void getCourseById_should_return_course_object() {
        Course expected = COURSE_1;
        Course actual = sut.getCourseById(1);

        Assert.assertEquals(expected.getCourseTitle(), actual.getCourseTitle());
    }

    @Test
    public void updateCourse_updates_course(){
        COURSE_2.setCourseDescription("tacos");
        sut.updateCourse(COURSE_2);

        Course courseThing = sut.getCourseById(2);
        Assert.assertEquals(COURSE_2.getCourseDescription(), courseThing.getCourseDescription());
    }

    @Test
    public void deleteCourse_removes_one_less_in_list() {
        int expectedSize = 1;

        sut.deleteCourse(COURSE_2);

        int actual = sut.getAllCourses().size();

        Assert.assertEquals(expectedSize, actual);
    }

    @Test
    public void getAllCoursesByStudentId_returns_correct_size() {
        int expectedSize = 2;
        int actual = sut.getAllCoursesByStudentId(5).size();

        Assert.assertEquals(expectedSize, actual);
    }

    @Test
    public void getAllCoursesByTeacherId_returns_correct_size() {
        int expectedSize = 1;
        int actual = sut.getAllCoursesByTeacherId(4).size();

        Assert.assertEquals(expectedSize, actual);

    }
}







