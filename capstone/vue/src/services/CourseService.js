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

  createCourse(course){
    return axios.post('/courses', course)
  },

  getCourseByCourseId(courseId){
    return axios.get(`/course/${courseId}`)
  },

  enrollInCourse(studentId, courseId){
    return axios.post(`/student/enroll/${studentId}/${courseId}`)
  }

}