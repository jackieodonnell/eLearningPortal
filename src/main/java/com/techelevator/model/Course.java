package com.techelevator.model;

import java.math.BigDecimal;

public class Course {
    private int courseId;
    private int teacherId;
    private String courseTitle;
    private String courseDescription;
    private String difficulty;
    private BigDecimal cost;
    private boolean isArchived;

    public Course(int courseId, int teacherId, String courseTitle, String courseDescription, String difficulty, BigDecimal cost, boolean isArchived) {
        this.courseId = courseId;
        this.teacherId = teacherId;
        this.courseTitle = courseTitle;
        this.courseDescription = courseDescription;
        this.difficulty = difficulty;
        this.cost = cost;
        this.isArchived = isArchived;
    }

    public Course() {
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public int getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(int teacherId) {
        this.teacherId = teacherId;
    }

    public String getCourseTitle() {
        return courseTitle;
    }

    public void setCourseTitle(String courseTitle) {
        this.courseTitle = courseTitle;
    }

    public String getCourseDescription() {
        return courseDescription;
    }

    public void setCourseDescription(String courseDescription) {
        this.courseDescription = courseDescription;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }

    public BigDecimal getCost() {
        return cost;
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }

    public boolean isArchived() {
        return isArchived;
    }

    public void setIsArchived(boolean archived) {
        isArchived = archived;
    }
}
