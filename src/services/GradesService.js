import axios from 'axios';

export default {
    addGrade(grade) {
        return axios.post('/course/assignment/work', grade)
    },

    getAllGrades() {
        return axios.get('/grades')
    },

    getAllJoinedGrades() {
        return axios.get('/j/grades')
    },

    allGradesForAssignment(assignmentId) {
        return axios.get(`/course/${assignmentId}/grades`)
    },

    allJoinedGradesForAssignment(assignmentId) {
        return axios.get(`/j/course/${assignmentId}/grades`)
    },

    allGradesForStudentInCourse(courseId, studentId) {
        return axios.get(`/${courseId}/assignment/grades/${studentId}`)
    },

    allJoinedGradesForStudentInCourse(courseId, studentId) {
        return axios.get(`/j/${courseId}/assignment/grades/${studentId}`)
    },

    getGrade(assignmentId, studentId) {
        return axios.get(`/course/curriculum/${assignmentId}/${studentId}`)
    },

    getCourseAverageForStudent(courseId, studentId) {
        return axios.get(`/course/averages/${courseId}/${studentId}`)
    },

    updateGrade(grade) {
        return axios.put('/course/assignment/work', grade)
    },

    deleteGrade(grade) {
        return axios.delete('/course/assignment/work', grade)
    },

    getStudentIdInCourse(courseId) {
        return axios.get(`/course/${courseId}/students`)
    }
}