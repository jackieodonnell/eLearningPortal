package com.techelevator.model;

import java.time.LocalDate;

public class DailyInstruction {
    private int dailyInstructionsId;
    private LocalDate currentDay;
    private int curriculumId;
    private String instructions;
    private String content;

    public DailyInstruction(int dailyInstructionsId, LocalDate currentDay, int curriculumId, String instructions, String content) {
        this.dailyInstructionsId = dailyInstructionsId;
        this.currentDay = currentDay;
        this.curriculumId = curriculumId;
        this.instructions = instructions;
        this.content = content;
    }

    public DailyInstruction() {
    }

    public int getDailyInstructionsId() {
        return dailyInstructionsId;
    }

    public void setDailyInstructionsId(int dailyInstructionsId) {
        this.dailyInstructionsId = dailyInstructionsId;
    }

    public LocalDate getCurrentDay() {
        return currentDay;
    }

    public void setCurrentDay(LocalDate currentDay) {
        this.currentDay = currentDay;
    }

    public int getCurriculumId() {
        return curriculumId;
    }

    public void setCurriculumId(int curriculumId) {
        this.curriculumId = curriculumId;
    }

    public String getInstructions() {
        return instructions;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
