package com.techelevator.model;

public class Curriculum {
    private int curriculumId;
    private int courseId;
    private String curriculumTitle;
    private String curriculumDescription;

    public Curriculum(int curriculumId, int courseId, String curriculumTitle, String curriculumDescription) {
        this.curriculumId = curriculumId;
        this.courseId = courseId;
        this.curriculumTitle = curriculumTitle;
        this.curriculumDescription = curriculumDescription;
    }

    public Curriculum() {
    }

    public int getCurriculumId() {
        return curriculumId;
    }

    public void setCurriculumId(int curriculumId) {
        this.curriculumId = curriculumId;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public String getCurriculumTitle() {
        return curriculumTitle;
    }

    public void setCurriculumTitle(String curriculumTitle) {
        this.curriculumTitle = curriculumTitle;
    }

    public String getCurriculumDescription() {
        return curriculumDescription;
    }

    public void setCurriculumDescription(String curriculumDescription) {
        this.curriculumDescription = curriculumDescription;
    }
}
