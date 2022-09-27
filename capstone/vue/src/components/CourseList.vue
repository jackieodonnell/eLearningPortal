<template>
  <div class="course-container">
    <course-card class="card" v-for="course in $store.state.courses" 
    v-bind:key="course.title" v-bind:course="course">
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
    props: ['course'],
    components: {
      CourseCard
    },
    created(){
        courseService.getCoursesForStudent(this.$store.state.user.user_id)
        .then(response => {
            if (response.status == 200) {
                this.courses = response.data
            }
        }); 
    }
}
</script>

<style>
.book-container {
    display:flex;
    justify-content: space-evenly;
    flex-wrap: wrap;
}
</style>