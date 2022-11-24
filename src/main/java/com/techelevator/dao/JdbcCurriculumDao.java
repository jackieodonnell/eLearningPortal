package com.techelevator.dao;

import com.techelevator.model.Curriculum;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcCurriculumDao implements CurriculumDao{

    private JdbcTemplate dao;

    public JdbcCurriculumDao(JdbcTemplate dao) {
        this.dao = dao;
    }

    @Override
    public int createCurriculum(Curriculum curriculum) {
        String sql = "INSERT INTO curriculum (curriculum_id, course_id, curriculum_title, curriculum_description) " +
                "VALUES (DEFAULT, ?, ?, ?) RETURNING curriculum_id;";
        return dao.queryForObject(sql, Integer.class, curriculum.getCourseId(), curriculum.getCurriculumTitle(), curriculum.getCurriculumDescription());
    }

    //get all curricula within a course
    @Override
    public List<Curriculum> getAllCurriculumInCourse(int courseId) {
        List<Curriculum> curricula = new ArrayList<>();
        String sql = "SELECT curriculum_id, course_id, curriculum_title, curriculum_description " +
                "FROM curriculum WHERE course_id = ? ;";
        SqlRowSet results = dao.queryForRowSet(sql, courseId);
        while (results.next()) {
            Curriculum curriculum = mapRowToCurriculum(results);
            curricula.add(curriculum);
        }
        return curricula;
    }

    //get specific curriculum
    @Override
    public Curriculum getCurriculumById(int curriculumId) {
        Curriculum curriculum = null;
        String sql = "SELECT curriculum_id, course_id, curriculum_title, curriculum_description " +
                "FROM curriculum WHERE curriculum_id = ?;";
        SqlRowSet results = dao.queryForRowSet(sql, curriculumId);
        while(results.next()) {
            curriculum = mapRowToCurriculum(results);
        }
        return curriculum;
    }

    @Override
    public void updateCurriculum(Curriculum curriculum) {
        String sql = "UPDATE curriculum SET curriculum_id = ?, course_id = ?, curriculum_title = ?, curriculum_description = ? " +
                "WHERE curriculum_id = ?;";
        dao.update(sql, curriculum.getCurriculumId(), curriculum.getCourseId(), curriculum.getCurriculumTitle(), curriculum.getCurriculumDescription(), curriculum.getCurriculumId());
    }

    @Override
    public void deleteCurriculum(Curriculum curriculum) {
        String sql = "DELETE FROM curriculum WHERE curriculum_id = ?;";
        dao.update(sql, curriculum.getCurriculumId());
    }

    private Curriculum mapRowToCurriculum(SqlRowSet result) {
        Curriculum curriculum = new Curriculum();
        curriculum.setCurriculumId(result.getInt("curriculum_id"));
        curriculum.setCourseId(result.getInt("course_id"));
        curriculum.setCurriculumTitle(result.getString("curriculum_title"));
        curriculum.setCurriculumDescription(result.getString("curriculum_description"));
        return curriculum;

    }
}
