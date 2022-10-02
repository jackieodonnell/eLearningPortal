<template>
  <div class="course-details">
      <div class="course-details-heading">
        <h2 class="course-title"> {{ course.courseTitle }} | Level: {{ course.difficulty }} </h2>
        <p class="course-description">{{ course.courseDescription }} </p>          
      </div>
      <div class="curriculum-details">
          <h3 class="curriculum-title">Curriculum Overview:</h3>
          <p class="curriculum-description">{{curricula[0].curriculumDescription}}</p>         
      </div>
    </div>
</template>

<script>
import courseService from '../services/CourseService';
import CurriculumService from '../services/CurriculumService';
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
            },
            curricula: []
        }
    },
    created(){
        courseService.getCourseByCourseId(this.$route.params.courseId).then(response => {
            if (response.status == 200){
                this.course = response.data;
                this.curricula = CurriculumService.getAllCurriculumInCourse(this.course.courseId).then(response => {
                    if (response.status == 200){
                        this.curricula = response.data;
                    }
                });     
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

.curriculum-details {
    border-top: 1px solid gray;
}

.course-details-heading {
    text-align: center;
}



</style>