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

  updateCourse(course){
    const courseId = course.courseId
    return axios.put(`/course/${courseId}`, course)
  },

  getCourseByCourseId(courseId){
    return axios.get(`/course/${courseId}`)
  },

  enrollInCourse(studentId, courseId){
    const studentCourseObject = {
      courseId: courseId,
      studentId: studentId
    }
    return axios.post(`/student/enroll/${studentId}/${courseId}`, studentCourseObject)
  }

}