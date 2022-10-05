package com.techelevator.controller;

import com.techelevator.dao.JoinedGradesDao;
import com.techelevator.model.JoinedGrades;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@PreAuthorize("isAuthenticated()")
public class JoinedGradesController {

    private JoinedGradesDao joinedGradesDao;

    public JoinedGradesController(JoinedGradesDao joinedGradesDao) {
        this.joinedGradesDao = joinedGradesDao;
    }

    @PreAuthorize("hasRole('ROLE_TEACHER')")
    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(value = "/j/course/assignment/work", method = RequestMethod.POST)
    public int addJoinedGrade(@RequestBody JoinedGrades joinedGrades) {
        return joinedGradesDao.addJoinedGrade(joinedGrades);
    }

    @RequestMapping(value = "/j/course/{assignmentId}/grades", method = RequestMethod.GET)
    public List<JoinedGrades> allJoinedGradesForAssignment(@PathVariable int assignmentId) {
        return joinedGradesDao.allJoinedGradesForAssignment(assignmentId);
    }

    @RequestMapping(value = "/j/{courseId}/assignment/grades/{studentId}", method = RequestMethod.GET)
    public List<JoinedGrades> allJoinedGradesForStudentInCourse(@PathVariable int courseId, @PathVariable int studentId) {
        return joinedGradesDao.allJoinedGradesForStudentInCourse(courseId,studentId);
    }

    @RequestMapping(value = "/j/{courseId}/assignment/grades/", method = RequestMethod.GET)
    public List<JoinedGrades> allJoinedGradesForCourse(@PathVariable int courseId) {
        return joinedGradesDao.allJoinedGradesForCourse(courseId);
    }

    @RequestMapping(value = "/j/course/curriculum/{assignmentId}/{studentId}", method = RequestMethod.GET)
    public JoinedGrades getJoinedGrade(@PathVariable int assignmentId, @PathVariable int studentId) {
        return joinedGradesDao.getJoinedGrade(assignmentId, studentId);
    }

    @RequestMapping(value = "/j/course/averages/{courseId}/{studentId}", method = RequestMethod.GET)
    public double getJoinedCourseAverageForStudent(@PathVariable int courseId, @PathVariable int studentId) {
        return joinedGradesDao.getJoinedCourseAverageForStudent(courseId, studentId);
    }

    @RequestMapping(value = "/j/grades", method = RequestMethod.GET)
    public List<JoinedGrades> getAllJoinedGrades() {
        return joinedGradesDao.getAllJoinedGrades();
    }

    @PreAuthorize("hasRole('ROLE_TEACHER')")
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/j/course/assignment/work", method = RequestMethod.PUT)
    public void updateGrade(@RequestBody JoinedGrades joinedGrades) {
        joinedGradesDao.updateJoinedGrade(joinedGrades);
    }

    @PreAuthorize("hasRole('ROLE_TEACHER')")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @RequestMapping(value = "/j/course/assignment/work", method = RequestMethod.DELETE)
    public void deleteGrade(JoinedGrades joinedGrades) {
        joinedGradesDao.deleteJoinedGrade(joinedGrades);
    }
}
