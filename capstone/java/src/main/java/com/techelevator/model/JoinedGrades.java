package com.techelevator.model;

public class JoinedGrades {
    private int gradeId;
    private int courseId;
    private int studentId;
    private int assignmentId;
    private String firstName;
    private String lastName;
    private String assignmentTitle;
    private int totalPoints;
    private int earnedPoints;
    private String status;
    private String submissionContent;
    private String feedback;

    public JoinedGrades(int gradeId, int courseId, int studentId, int assignmentId, String firstName, String lastName, String assignmentTitle, int totalPoints, int earnedPoints, String status, String submissionContent, String feedback) {
        this.gradeId = gradeId;
        this.courseId = courseId;
        this.studentId = studentId;
        this.assignmentId = assignmentId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.assignmentTitle = assignmentTitle;
        this.totalPoints = totalPoints;
        this.earnedPoints = earnedPoints;
        this.status = status;
        this.submissionContent = submissionContent;
        this.feedback = feedback;
    }

    public JoinedGrades() {
    }

    public int getGradeId() {
        return gradeId;
    }

    public void setGradeId(int gradeId) {
        this.gradeId = gradeId;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public int getAssignmentId() {
        return assignmentId;
    }

    public void setAssignmentId(int assignmentId) {
        this.assignmentId = assignmentId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAssignmentTitle() {
        return assignmentTitle;
    }

    public void setAssignmentTitle(String assignmentTitle) {
        this.assignmentTitle = assignmentTitle;
    }

    public int getTotalPoints() {
        return totalPoints;
    }

    public void setTotalPoints(int totalPoints) {
        this.totalPoints = totalPoints;
    }

    public int getEarnedPoints() {
        return earnedPoints;
    }

    public void setEarnedPoints(int earnedPoints) {
        this.earnedPoints = earnedPoints;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getSubmissionContent() {
        return submissionContent;
    }

    public void setSubmissionContent(String submissionContent) {
        this.submissionContent = submissionContent;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }
}
