package com.techelevator.model;

import java.time.LocalDate;

public class Assignment {
    private int assignmentId;
    private int dailyInstructionsId;
    private LocalDate assignedDate;
    private LocalDate dueDate;
    private String assignmentTitle;
    private String assignmentDescription;
    private String assignmentType;


    public Assignment(int assignmentId, int dailyInstructionsId, LocalDate assignedDate, LocalDate dueDate, String assignmentTitle, String assignmentDescription, String assignmentType) {
        this.assignmentId = assignmentId;
        this.dailyInstructionsId = dailyInstructionsId;
        this.assignedDate = assignedDate;
        this.dueDate = dueDate;
        this.assignmentTitle = assignmentTitle;
        this.assignmentDescription = assignmentDescription;
        this.assignmentType = assignmentType;
    }

    public Assignment() {
    }

    public int getAssignmentId() {
        return assignmentId;
    }

    public void setAssignmentId(int assignmentId) {
        this.assignmentId = assignmentId;
    }

    public int getDailyInstructionsId() {
        return dailyInstructionsId;
    }

    public void setDailyInstructionsId(int dailyInstructionsId) {
        this.dailyInstructionsId = dailyInstructionsId;
    }

    public LocalDate getAssignedDate() {
        return assignedDate;
    }

    public void setAssignedDate(LocalDate assignedDate) {
        this.assignedDate = assignedDate;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public String getAssignmentTitle() {
        return assignmentTitle;
    }

    public void setAssignmentTitle(String assignmentTitle) {
        this.assignmentTitle = assignmentTitle;
    }

    public String getAssignmentDescription() {
        return assignmentDescription;
    }

    public void setAssignmentDescription(String assignmentDescription) {
        this.assignmentDescription = assignmentDescription;
    }

    public String getAssignmentType() {
        return assignmentType;
    }

    public void setAssignmentType(String assignmentType) {
        this.assignmentType = assignmentType;
    }

}
