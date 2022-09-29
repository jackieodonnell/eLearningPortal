<template>
  <div class="course-container">
    <!-- course-card class="card" v-for="course in $store.state.courses" 
    v-bind:key="course.course_title" v-bind:course="course">
    </course-card -->
    <course-card class="card" v-for="course in courses" 
    v-bind:key="course.courseTitle" v-bind:course="course">
    </course-card>
  </div>
</template>

<script>
import CourseCard from './CourseCard.vue';
import courseService from '../services/CourseService';

export default {
    name: 'course-list',
    data() {
        return {
            courses: []
        }
    },
    // props: ['tech'],
    components: {
      CourseCard
    },
    created(){
        // courseService.getCourses()
        // .then(response =>{
        //     this.courses = response.data
        // });
    if(this.$store.state.user.authorities.some(e => e ['name'] === "ROLE_STUDENT")){
            courseService.getCoursesForStudent(this.$store.state.user.id)
            .then(response => {
                if (response.status == 200) {
                this.courses = response.data
                }
            });
        } else if(this.$store.state.user.authorities.some(e => e ['name'] === "ROLE_TEACHER")){
            courseService.getCoursesForTeacher(this.$store.state.user.id)
            .then(response => {
                if (response.status == 200) {
                this.courses = response.data
                }
            });
        }
    }
}
</script>

<style>
.course-container {
    grid-area: courses;
    display:flex;
    justify-content: center;
    gap: 50px;
    flex-wrap: wrap;
}
</style>