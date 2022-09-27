<template>
  <div class="home">
    <h1>Home</h1>
    <h2>Hello {{$store.state.user.username}}!</h2>
    <!-- p>You must be authenticated to see this</p -->
    <course-list />
  </div>
</template>

<script>
import CourseList from '../components/CourseList.vue';

export default {
  name: "home",
  components: {
    CourseList
  },
  // methods: {
  //   getCoursesForUser(){
  //     this.$store.commit("GET_COURSES", this.user)
  //   }
  // }
};
</script>

<style scoped>
  .course-card{
    border: 2px solid black;
    border-radius: 10px;
    width: 250px;
    height: 150px;
    margin: 20px;
  }

</style>
