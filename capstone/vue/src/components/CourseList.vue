<template>
  <div class="course-container">
    <course-card class="card" v-for="course in $store.state.courses" 
    v-bind:key="course.title" v-bind:course="course">
    </course-card>
  </div>
</template>

<script>
import CourseCard from './CourseCard.vue';

export default {
    name: 'course-list',
    props: ['course'],
    components: {
      CourseCard
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