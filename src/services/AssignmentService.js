import axios from "axios";

export default {

    createAssignment(newAssignmentWrapper) {
        return axios.post('assignments/new', newAssignmentWrapper);
    },

    getAssignmentById(assignmentId) {
        return axios.get(`/assignments/${assignmentId}`);
    },

     getAllAssignmentsInDailyInstruction(dailyInstructionId){
        return axios.get(`/instruction/${dailyInstructionId}/assignments`);
    },

    getAllAssignmentsInCurriculum(curriculum){
        const curriculumId = curriculum.curriculumId
        return axios.get(`/curriculum/${curriculumId}/assignments`);
    },

    getAllAssignmentsInCourse(courseId){
        // const courseId = course.courseId
        return axios.get(`/courses/${courseId}/assignments`);
    },

    getAllAssignmentsForStudent(studentId){
        return axios.get(`/students/${studentId}/assignments`);
    },

    updateAssignment(assignment){
        const assignmentId = assignment.assignmentId
        return axios.put(`/assignments/${assignmentId}/update`, assignment);
    },

    deleteAssignment(assignment){
        const assignmentId = assignment.assignmentId
        return axios.delete(`/assignments/${assignmentId}/delete`, assignment);
    }


}