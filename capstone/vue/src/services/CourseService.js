import axios from 'axios';

export default {

  getCoursesForStudent(id) {
    return axios.get(`/student/${id}/courses`)
  },

  getCourses(){
    return axios.get('/courses')
  }

}