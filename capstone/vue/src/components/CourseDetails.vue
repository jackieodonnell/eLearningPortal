<template>
  <div class="course-details">
      <div class="course-container">
          <div class="course-title-box">
              <h1 class="course-title"> {{ course.courseTitle }} | Grade Level: {{ course.difficulty }} </h1>
          </div>
          <div class="course-desc-box">
              <p class="course-description">{{ course.courseDescription }} </p>
          </div>
          <div class="curriculum">
              <h1 class="curr-title">This is where the curriculum/homework will go</h1>
          </div>
      </div>



      
      
  </div>
</template>

<script>
import courseService from '../services/CourseService';
// import CurriculumList from './CurriculumList.vue';

export default {
    name: "course-details",
    components: {
    // CurriculumList 
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

.course-container {
    padding: 20px;
    display: flex;
    flex-direction: column;
    height: 50vh;
    justify-content: flex-start;
}
.course-container div {
    /* border: 1px solid red; */
    margin: 10px;
}

</style>