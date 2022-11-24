import axios from 'axios';

export default {

    getAllCurriculumInCourse(courseId) {
        return axios.get(`/${courseId}/curricula`);
    },

    createCurriculum(curriculum) {
        return axios.post('course/curriculum', curriculum);
    },

    getCurriculumById(curriculumId) {
        return axios.get(`/course/curriculum/${curriculumId}`);
    },

    updateCurriculum(curriculum) {
        const id = curriculum.curriculumId
        return axios.put(`/course/curriculum/update/${id}`, curriculum);
    },

    deleteCurriculum(curriculum) {
        const id = curriculum.curriculumId
        return axios.delete(`/course/curriculum/${id}`, curriculum);
    }

}