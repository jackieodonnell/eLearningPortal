package com.techelevator.controller;

import com.techelevator.dao.StudentCourseDao;
import com.techelevator.model.StudentCourse;
import com.techelevator.model.User;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@PreAuthorize("isAuthenticated()")
public class StudentCourseController {

    private StudentCourseDao studentCourseDao;

    public StudentCourseController(StudentCourseDao studentCourseDao) {
        this.studentCourseDao = studentCourseDao;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(value = "/student/enroll/{studentId}/{courseId}")
    public void enrollInCourse(@PathVariable int studentId, @PathVariable int courseId, @RequestBody StudentCourse studentCourse) {
        studentCourseDao.enrollInCourse(studentCourse);
    }

    @RequestMapping(value= "/course/{courseId}/students", method= RequestMethod.GET)
    public List<Integer> getStudentsByCourseId(@PathVariable int courseId) {
        return studentCourseDao.getStudentsByCourseId(courseId);
    }


}
