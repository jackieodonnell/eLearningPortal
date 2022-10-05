package com.techelevator.controller;

import com.techelevator.dao.*;
import com.techelevator.model.Assignment;
import com.techelevator.model.JoinedGrades;
import com.techelevator.model.NewAssignmentWrapper;
import com.techelevator.model.StudentCourse;
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
    private StudentCourseDao studentCourseDao;
    private JoinedGradesDao joinedGradesDao;

    public AssignmentController(UserDao userDao, CourseDao courseDao, CurriculumDao curriculumDao, DailyInstructionDao dailyInstructionDao, AssignmentDao assignmentDao, StudentCourseDao studentCourseDao, JoinedGradesDao joinedGradesDao) {
        this.userDao = userDao;
        this.courseDao = courseDao;
        this.curriculumDao = curriculumDao;
        this.dailyInstructionDao = dailyInstructionDao;
        this.assignmentDao = assignmentDao;
        this.studentCourseDao = studentCourseDao;
        this.joinedGradesDao = joinedGradesDao;
    }

    @PreAuthorize("hasRole('ROLE_TEACHER')")
    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(value = "/assignments/new", method = RequestMethod.POST)
    public void createAssignment(@RequestBody NewAssignmentWrapper newAssignmentWrapper) {
        Assignment assignment = newAssignmentWrapper.getAssignment();
        int totalPoints = newAssignmentWrapper.getTotalPoints();
        int assignmentId = assignmentDao.createAssignment(assignment);
        List<Integer> studentsInCourse = studentCourseDao.getStudentsByCourseId(assignmentDao.getCourseIdByAssignmentId(assignmentId));
        for (int i = 0; i < studentsInCourse.size(); i++) {
            JoinedGrades joinedGrades = new JoinedGrades();
            joinedGrades.setStudentId(studentsInCourse.get(i));
            joinedGrades.setAssignmentId(assignmentId);
            joinedGrades.setCourseId(assignmentDao.getCourseIdByAssignmentId(assignmentId));
            joinedGrades.setTotalPoints(totalPoints);
            joinedGrades.setEarnedPoints(0);
            joinedGrades.setStatus("Incomplete");
            joinedGrades.setSubmissionContent("");
            joinedGrades.setFeedback("");
            joinedGradesDao.addJoinedGrade(joinedGrades);
        }
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
