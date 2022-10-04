package com.techelevator.dao;

import com.techelevator.model.Grades;

import java.util.List;

public interface GradesDao {

    //c
    int addGrade(Grades grades);

    //r
    List<Grades> getAllGrades();

    List<Grades> allGradesForAssignment(int assignmentId);

    List<Grades> allGradesForStudentInCourse(int courseId, int studentId);

    Grades getGrade(int assignmentId, int studentId);

    double getCourseAverageForStudent(int courseId, int studentId);

    //u
    void updateGrade(Grades grades);


    //d
    void deleteGrade(Grades grades);
}
