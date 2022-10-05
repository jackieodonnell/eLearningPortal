package com.techelevator.controller;

import com.techelevator.dao.GradesDao;
import com.techelevator.model.Grades;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@PreAuthorize("isAuthenticated()")
public class GradesController {

    private GradesDao gradesDao;

    public GradesController(GradesDao gradesDao) {
        this.gradesDao = gradesDao;
    }

    @PreAuthorize("hasRole('ROLE_TEACHER')")
    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(value = "/course/assignment/work", method = RequestMethod.POST)
    public int addGrade(@RequestBody Grades grades) {
        return gradesDao.addGrade(grades);
    }

    @RequestMapping(value = "/course/{assignmentId}/grades", method = RequestMethod.GET)
    public List<Grades> allGradesForAssignment(@PathVariable int assignmentId) {
        return gradesDao.allGradesForAssignment(assignmentId);
    }

    @RequestMapping(value = "/{courseId}/assignment/grades/{studentId}", method = RequestMethod.GET)
    public List<Grades> allGradesForStudentInCourse(@PathVariable int courseId, @PathVariable int studentId) {
        return gradesDao.allGradesForStudentInCourse(courseId,studentId);
    }

    @RequestMapping(value = "/course/curriculum/{assignmentId}/{studentId}", method = RequestMethod.GET)
    public Grades getGrade(@PathVariable int assignmentId, @PathVariable int studentId) {
        return gradesDao.getGrade(assignmentId, studentId);
    }

    @RequestMapping(value = "/course/averages/{courseId}/{studentId}", method = RequestMethod.GET)
    public double getCourseAverageForStudent(@PathVariable int courseId, @PathVariable int studentId) {
        return gradesDao.getCourseAverageForStudent(courseId, studentId);
    }

    @RequestMapping(value = "/grades", method = RequestMethod.GET)
    public List<Grades> getAllGrades() {
        return gradesDao.getAllGrades();
    }

//    @PreAuthorize("hasRole('ROLE_TEACHER')")
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/course/assignment/work", method = RequestMethod.PUT)
    public void updateGrade(@RequestBody Grades grades) {
        gradesDao.updateGrade(grades);
    }

    @PreAuthorize("hasRole('ROLE_TEACHER')")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @RequestMapping(value = "/course/assignment/work", method = RequestMethod.DELETE)
    public void deleteGrade(Grades grades) {
        gradesDao.deleteGrade(grades);
    }
}
