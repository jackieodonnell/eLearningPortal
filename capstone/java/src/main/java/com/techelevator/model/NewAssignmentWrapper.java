package com.techelevator.model;

public class NewAssignmentWrapper {
    private Assignment assignment;
    private int totalPoints;

    public NewAssignmentWrapper(Assignment assignment, int totalPoints) {
        this.assignment = assignment;
        this.totalPoints = totalPoints;
    }

    public NewAssignmentWrapper() {
    }

    public Assignment getAssignment() {
        return assignment;
    }

    public void setAssignment(Assignment assignment) {
        this.assignment = assignment;
    }

    public int getTotalPoints() {
        return totalPoints;
    }

    public void setTotalPoints(int totalPoints) {
        this.totalPoints = totalPoints;
    }
}
