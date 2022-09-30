package com.techelevator.controller;

import com.techelevator.dao.*;
import com.techelevator.model.Assignment;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@PreAuthorize("isAuthenticated()")
public class AssignmentController {
    private UserDao userDao;
    private CourseDao courseDao;
    private CurriculumDao curriculumDao;
    private DailyInstructionDao dailyInstructionDao;
    private AssignmentDao assignmentDao;

    public AssignmentController(UserDao userDao, CourseDao courseDao, CurriculumDao curriculumDao, DailyInstructionDao dailyInstructionDao, AssignmentDao assignmentDao) {
        this.userDao = userDao;
        this.courseDao = courseDao;
        this.curriculumDao = curriculumDao;
        this.dailyInstructionDao = dailyInstructionDao;
        this.assignmentDao = assignmentDao;
    }

    @PreAuthorize("hasRole('ROLE_TEACHER')")
    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(value = "/assignments/new", method = RequestMethod.POST)
    public int createAssignment(@RequestBody Assignment assignment) {
        return assignmentDao.createAssignment(assignment);
    }

    @RequestMapping(value = "/assignments/all", method = RequestMethod.GET)
    public List<Assignment> getAllAssignments(){
        return assignmentDao.getAllAssignments();
    }

    @RequestMapping(value = "/instruction/{dailyInstructionId}/assignments", method = RequestMethod.GET)
    public List<Assignment> getAllAssignmentsByInstructionId(@PathVariable int dailyInstructionId) {
        return assignmentDao.getAllAssignmentsByInstructionId(dailyInstructionId);
    }

    @RequestMapping(value = "/curriculum/{curriculumId}/assignments", method = RequestMethod.GET)
    public List<Assignment> getAllAssignmentsByCurriculumId(@PathVariable int curriculumId) {
        return assignmentDao.getAllAssignmentsByCurriculumId(curriculumId);
    }

    @RequestMapping(value = "/courses/{courseId}/assignments", method = RequestMethod.GET)
    public List<Assignment> getAllAssignmentsByCourseId(@PathVariable int courseId) {
        return assignmentDao.getAllAssignmentsByCourseId(courseId);
    }

    @RequestMapping(value = "/students/{studentId}/assignments", method = RequestMethod.GET)
    public List<Assignment> getAllAssignmentsByStudentId(@PathVariable int studentId) {
        return assignmentDao.getAllAssignmentsByStudentId(studentId);
    }

    @RequestMapping(value = "/assignments/{assignmentId}", method = RequestMethod.GET)
    public Assignment getAssignmentById(@PathVariable int assignmentId) {
        return assignmentDao.getAssignmentById(assignmentId);
    }

    @PreAuthorize("hasRole('ROLE_TEACHER')")
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "assignments/{assignmentId}/update", method = RequestMethod.PUT)
    public void updateAssignment(@RequestBody Assignment assignment){
        assignmentDao.updateAssignment(assignment);
    }

    @PreAuthorize("hasRole('ROLE_TEACHER')")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @RequestMapping(value = "assignments/{assignmentId}/delete", method = RequestMethod.DELETE)
    public void deleteAssignment(@RequestBody Assignment assignment) {
        assignmentDao.deleteAssignment(assignment);
    }
}
