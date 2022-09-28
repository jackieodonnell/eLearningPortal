import axios from 'axios';

export default {

  getCoursesForStudent(id) {
    return axios.get(`/student/${id}/courses`)
  },

  getCoursesForTeacher(id){
    return axios.get(`/teacher/${id}/courses`)
  },

  getCourses(){
    return axios.get('/courses')
  },

}