<template>
  <div class="course-details">
      <h1 class="course-title">
          {{ course.courseTitle }} | Grade Level: {{ course.difficulty }}
      </h1>
      <p class="course-description">
          {{ course.courseDescription }}
      </p>
  </div>
</template>

<script>
import courseService from '../services/CourseService';

export default {
    name: "course-details",
    data(){
        return {
            course: {
                courseId: '',
                teacherId: '',
                courseTitle: '',
                courseDescription: '',
                difficulty: '',
                cost: '',
            }
        }
    },
    created(){
        courseService.getCourseByCourseId(this.$route.params.courseId).then(response => {
            if (response.status == 200){
                this.course = response.data;
            }
        })       
    }
}
</script>

<style>

</style>