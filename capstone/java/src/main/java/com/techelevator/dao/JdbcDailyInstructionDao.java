package com.techelevator.dao;

import com.techelevator.model.DailyInstruction;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcDailyInstructionDao implements  DailyInstructionDao{

    private JdbcTemplate dao;

    public JdbcDailyInstructionDao(JdbcTemplate dao) {
        this.dao = dao;
    }

    @Override
    public int createInstruction(DailyInstruction dailyInstruction) {
        String sql = "INSERT INTO daily_instructions (daily_instructions_id, current_day, curriculum_id, instructions) " +
                "VALUES (DEFAULT, ?, ?, ?) RETURNING daily_instructions_id;";
        return dao.queryForObject(sql, Integer.class, dailyInstruction.getCurrentDay(), dailyInstruction.getCurriculumId(), dailyInstruction.getInstructions());
    }

    @Override
    public List<DailyInstruction> getAllInstructionsInCurriculum(int curriculumId) {
        List<DailyInstruction> dailyInstructionList = new ArrayList<>();
        String sql = "SELECT daily_instructions_id, current_day, curriculum_id, instructions " +
                "FROM daily_instructions WHERE curriculum_id = ?;";
        SqlRowSet results = dao.queryForRowSet(sql, curriculumId);
        while (results.next()) {
            DailyInstruction dailyInstruction = mapRowToDailyInstruction(results);
            dailyInstructionList.add(dailyInstruction);
        }
        return dailyInstructionList;
    }

    @Override
    public DailyInstruction getInstructionById(int dailyInstructionId) {
        DailyInstruction instruction = null;
        String sql = "SELECT daily_instructions_id, current_day, curriculum_id, instructions " +
                "FROM daily_instructions WHERE daily_instructions_id = ?;";
        SqlRowSet results = dao.queryForRowSet(sql, dailyInstructionId);
        while (results.next()) {
            instruction = mapRowToDailyInstruction(results);
        }
        return instruction;
    }

    @Override
    public void updateInstruction(DailyInstruction dailyInstruction) {
        String sql = "UPDATE daily_instructions SET daily_instructions_id = ?, current_day = ?, curriculum_id = ?, instructions = ? " +
                "WHERE daily_instructions_id = ?;";
        dao.update(sql, dailyInstruction.getDailyInstructionsId(), dailyInstruction.getCurrentDay(), dailyInstruction.getCurriculumId(), dailyInstruction.getInstructions());
    }

    @Override
    public void deleteInstruction(DailyInstruction dailyInstruction) {
        String sql = "DELETE FROM daily_instructions WHERE daily_instructions_id = ?;";
        dao.update(sql, dailyInstruction.getDailyInstructionsId());
    }

    private DailyInstruction mapRowToDailyInstruction(SqlRowSet results) {
        DailyInstruction dailyInstruction = new DailyInstruction();
        dailyInstruction.setDailyInstructionsId(results.getInt("daily_instructions_id"));
        dailyInstruction.setCurrentDay(results.getDate("current_day").toLocalDate());
        dailyInstruction.setCurriculumId(results.getInt("curriculum_id"));
        dailyInstruction.setInstructions(results.getString("instructions"));
        return dailyInstruction;
    }
}
