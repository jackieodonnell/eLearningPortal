package com.techelevator.dao;

import com.techelevator.model.DailyInstruction;

import java.util.List;

public interface DailyInstructionDao {

    //c
    int createInstruction(DailyInstruction dailyInstruction);

    //r
    List<DailyInstruction> getAllInstructionsInCurriculum(int curriculumId);

    DailyInstruction getInstructionById(int dailyInstructionId);

    //u
    void updateInstruction(DailyInstruction dailyInstruction);

    //d
    void deleteInstruction(DailyInstruction dailyInstruction);
}
