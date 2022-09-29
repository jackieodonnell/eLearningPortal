<template>
  <div class="course-details">
      <h1 class="course-title">
          {{ course.courseTitle }}
      </h1>
      <p class="course-description">
          Level: {{ course.difficulty }} - {{ course.courseDescription }}
      </p>
      <curriculum-list/>
  </div>
</template>

<script>
import courseService from '../services/CourseService';
import CurriculumList from './CurriculumList.vue';

export default {
    name: "course-details",
    components: {
    CurriculumList 
    },
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