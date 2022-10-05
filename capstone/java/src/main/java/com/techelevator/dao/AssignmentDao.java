package com.techelevator.dao;

import com.techelevator.model.Assignment;

import java.util.List;

public interface AssignmentDao {

    int createAssignment(Assignment assignment);

    List<Assignment> getAllAssignments();

    int getCourseIdByAssignmentId(int assignmentId);

    List<Assignment> getAllAssignmentsByInstructionId(int instructionId);

    List<Assignment> getAllAssignmentsByCurriculumId(int curriculumId);

    List<Assignment> getAllAssignmentsByCourseId(int courseId);

    List<Assignment> getAllAssignmentsByStudentId(int studentId);

    Assignment getAssignmentById(int assignmentId);

    void updateAssignment(Assignment assignment);

    void deleteAssignment(Assignment assignment);
}
