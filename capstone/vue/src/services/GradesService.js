import axios from 'axios';

export default {
    addGrade(grade){
        return axios.post('/course/assignment/work', grade)
      },

    allGradesForAssignment(id){
        return axios.get(`/course/${id}/grades`)
    },

    allGradesForStudentInCourse(cId, sId){
        return axios.get(`/${cId}/assignment/grades/${sId}`)
    },

    getGrade(aId, sId){
        return axios.get(`/course/curriculum/${aId}/${sId}`)
    },

    getCourseAverageForStudent(cId, sId){
        return axios.get(`/course/averages/${cId}/${sId}`)
    },

    updateGrade(grade){
        return axios.put('/course/assignment/work', grade)
    },

    deleteGrade(grade){
        return axios.delete('/course/assignment/work', grade)
    },

    getStudentIdInCourse(courseId){
        return axios.get(`/course/${courseId}/students`)
    }
}