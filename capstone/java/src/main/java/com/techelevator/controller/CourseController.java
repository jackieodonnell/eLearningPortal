package com.techelevator.controller;

import com.techelevator.dao.CourseDao;
import com.techelevator.dao.UserDao;
import com.techelevator.model.Course;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;
import java.util.List;

@RestController
@CrossOrigin
@PreAuthorize("isAuthenticated()")
public class CourseController {

    private CourseDao courseDao;
    private UserDao userDao;

    public CourseController(CourseDao courseDao, UserDao userDao) {
        this.courseDao = courseDao;
        this.userDao = userDao;
    }

    @PreAuthorize("hasRole('ROLE_TEACHER')")
    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(value = "/courses", method = RequestMethod.POST)
    public int createCourse(@Valid @RequestBody Course course) {
          return courseDao.createCourse(course);
    }

    @RequestMapping(value = "/courses", method = RequestMethod.GET)
    public List<Course> getAllCourses() {
        return courseDao.getAllCourses();
    }

    @RequestMapping(value = "/course/{id}", method = RequestMethod.GET)
    public Course getCourseById(@PathVariable int id) {
        return courseDao.getCourseById(id);
    }

    @PreAuthorize("hasRole('ROLE_TEACHER')")
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/course/{id}", method = RequestMethod.PUT)
    public void updateCourse(@RequestBody Course course) {
        courseDao.updateCourse(course);
    }

    @PreAuthorize("hasRole('ROLE_TEACHER')")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @RequestMapping(value = "/course/{id}", method = RequestMethod.DELETE)
    public void deleteCourse(@RequestBody Course course) {
        courseDao.deleteCourse(course);
    }

    @RequestMapping(value = "/student/{studentId}/courses", method = RequestMethod.GET)
    public List<Course> getAllCoursesByStudentId(@PathVariable int studentId){
        return courseDao.getAllCoursesByStudentId(studentId);
    }

    @RequestMapping(value = "/teacher/{teacherId}/courses", method = RequestMethod.GET)
    public List<Course> getAllCoursesByTeacherId(@PathVariable int teacherId){
        return courseDao.getAllCoursesByTeacherId(teacherId);
    }



}
