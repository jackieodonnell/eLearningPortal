package com.techelevator.dao;

import com.techelevator.model.Course;

import java.util.List;

public interface CourseDao {

    int createCourse(Course course);

    List<Course> getAllCourses();

    Course getCourseById(int courseId);

    void updateCourse(Course course);

    void deleteCourse(Course course);
}
