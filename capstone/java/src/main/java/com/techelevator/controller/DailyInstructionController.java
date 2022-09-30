package com.techelevator.controller;

import com.techelevator.dao.CourseDao;
import com.techelevator.dao.CurriculumDao;
import com.techelevator.dao.DailyInstructionDao;
import com.techelevator.dao.UserDao;
import com.techelevator.model.DailyInstruction;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@PreAuthorize("isAuthenticated()")
public class DailyInstructionController {
    private UserDao userDao;
    private CourseDao courseDao;
    private CurriculumDao curriculumDao;
    private DailyInstructionDao dailyInstructionDao;

    public DailyInstructionController(UserDao userDao, CourseDao courseDao, CurriculumDao curriculumDao, DailyInstructionDao dailyInstructionDao) {
        this.userDao = userDao;
        this.courseDao = courseDao;
        this.curriculumDao = curriculumDao;
        this.dailyInstructionDao = dailyInstructionDao;
    }

    @PreAuthorize("hasRole('ROLE_TEACHER')")
    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(value = "/course/curriculum/instruction", method = RequestMethod.POST)
    public int createDailyInstruction(@RequestBody DailyInstruction dailyInstruction) {
        return dailyInstructionDao.createInstruction(dailyInstruction);
    }

    @RequestMapping(value = "/curriculum/{curriculumId}/instructions", method = RequestMethod.GET)
    public List<DailyInstruction> getAllInstructionsInCurriculum(@PathVariable int curriculumId) {
        return dailyInstructionDao.getAllInstructionsInCurriculum(curriculumId);
    }

    @RequestMapping(value = "/course/{courseId}/instructions", method = RequestMethod.GET)
    public List<DailyInstruction> getAllInstructionsInCourse(@PathVariable int courseId) {
        return dailyInstructionDao.getAllInstructionsInCourse(courseId);
    }

    @RequestMapping(value = "/course/curriculum/instruction/{dailyInstructionId}", method = RequestMethod.GET)
    public DailyInstruction getInstructionByID(@PathVariable int dailyInstructionId) {
        return dailyInstructionDao.getInstructionById(dailyInstructionId);
    }

    @PreAuthorize("hasRole('ROLE_TEACHER')")
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/course/curriculum/{dailyInstructionId}", method = RequestMethod.PUT)
    public void updateDailyInstruction(@RequestBody DailyInstruction dailyInstruction) {
        dailyInstructionDao.updateInstruction(dailyInstruction);
    }

    @PreAuthorize("hasRole('ROLE_TEACHER')")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @RequestMapping(value = "/course/curriculum/{dailyInstructionId}", method = RequestMethod.DELETE)
    public void deleteDailyInstruction(@RequestBody DailyInstruction dailyInstruction) {
        dailyInstructionDao.deleteInstruction(dailyInstruction);
    }
}
