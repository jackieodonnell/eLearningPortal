package com.techelevator.controller;

import com.techelevator.dao.StudentCourseDao;
import com.techelevator.model.StudentCourse;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@PreAuthorize("isAuthenticated()")
public class StudentCourseController {

    private StudentCourseDao studentCourseDao;

    public StudentCourseController(StudentCourseDao studentCourseDao) {
        this.studentCourseDao = studentCourseDao;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(value = "/student/enroll/{courseId}/{studentId}")
    public void enrollInCourse(@RequestBody StudentCourse studentCourse) {
        studentCourseDao.enrollInCourse(studentCourse);
    }
}
