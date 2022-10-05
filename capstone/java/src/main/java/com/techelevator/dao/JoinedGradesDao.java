package com.techelevator.dao;

import com.techelevator.model.JoinedGrades;

import java.util.List;

public interface JoinedGradesDao {

    //c
    int addJoinedGrade(JoinedGrades joinedGrades);

    //r
    List<JoinedGrades> getAllJoinedGrades();

    List<JoinedGrades> allJoinedGradesForAssignment(int assignmentId);

    List<JoinedGrades> allJoinedGradesForStudentInCourse(int courseId, int studentId);

    List<JoinedGrades> allJoinedGradesForCourse(int courseId);

    JoinedGrades getJoinedGrade(int assignmentId, int studentId);

    double getJoinedCourseAverageForStudent(int courseId, int studentId);

    //u
    void updateJoinedGrade(JoinedGrades joinedGrades);


    //d
    void deleteJoinedGrade(JoinedGrades joinedGrades);
}
