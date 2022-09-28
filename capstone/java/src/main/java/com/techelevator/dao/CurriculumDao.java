package com.techelevator.dao;

import com.techelevator.model.Curriculum;

import java.util.List;

public interface CurriculumDao {

    //create
    int createCurriculum(Curriculum curriculum);

    //retrieve all for course
    List<Curriculum> getAllCurriculumInCourse(int courseId);

    //getspecific
    Curriculum getCurriculumById(int curriculumId);


    //update
    void updateCurriculum(Curriculum curriculum);

    //delete
    void deleteCurriculum(Curriculum curriculum);
}
