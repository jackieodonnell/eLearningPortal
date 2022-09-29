import axios from 'axios';

export default {

    getInstructionsInCurriculum(curriculumId) {
        return axios.get(`/course/${curriculumId}/instructions`);
    },

    getInstructionById(dailyInstructionsId) {
        return axios.get(`/course/curriculum/instruction/${dailyInstructionsId}`)
    },

    createInstruction(dailyInstruction) {
        return axios.post('/course/curriculum/instruction', dailyInstruction)
    },

    updateInstruction(dailyInstruction) {
        const dailyInstructionsId = dailyInstruction.dailyInstructionsId
        return axios.put(`/course/curriculum/${dailyInstructionsId}`)
    },

    deleteInstruction(dailyInstruction) {
        const dailyInstructionsId = dailyInstruction.dailyInstructionsId
        return axios.delete(`/course/curriculum/${dailyInstructionsId}`)
    },

}