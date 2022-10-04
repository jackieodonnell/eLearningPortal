package com.techelevator.controller;

import com.techelevator.dao.CourseDao;
import com.techelevator.dao.CurriculumDao;
import com.techelevator.dao.UserDao;
import com.techelevator.model.Curriculum;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@PreAuthorize("isAuthenticated()")
public class CurriculumController {
    private UserDao userDao;
    private CourseDao courseDao;
    private CurriculumDao curriculumDao;

    public CurriculumController(UserDao userDao, CourseDao courseDao, CurriculumDao curriculumDao) {
        this.userDao = userDao;
        this.courseDao = courseDao;
        this.curriculumDao = curriculumDao;
    }

    @PreAuthorize("hasRole('ROLE_TEACHER')")
    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(value = "/course/curriculum", method = RequestMethod.POST)
    public int createCurriculum(@RequestBody Curriculum curriculum) {
        return curriculumDao.createCurriculum(curriculum);
    }


    @RequestMapping(value = "/{courseId}/curricula", method = RequestMethod.GET)
    public List<Curriculum> getAllCurriculumInCourse(@PathVariable int courseId){
        return curriculumDao.getAllCurriculumInCourse(courseId);
    }

    @RequestMapping(value = "/course/curriculum/{curriculumId}", method = RequestMethod.GET)
    public Curriculum getCurriculumById(@PathVariable int curriculumId) {
        return curriculumDao.getCurriculumById(curriculumId);
    }

    @PreAuthorize("hasRole('ROLE_TEACHER')")
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/course/curriculum/update/{curriculumId}", method = RequestMethod.PUT)
    public void updateCurriculum(@RequestBody Curriculum curriculum) {
        curriculumDao.updateCurriculum(curriculum);
    }

    @PreAuthorize("hasRole('ROLE_TEACHER')")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @RequestMapping(value = "/course/curriculum/{curriculumId}", method = RequestMethod.DELETE)
    public void deleteCurriculum(@RequestBody Curriculum curriculum) {
        curriculumDao.deleteCurriculum(curriculum);
    }
}
