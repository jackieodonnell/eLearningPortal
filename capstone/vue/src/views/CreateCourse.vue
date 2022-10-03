<template>
  <div class="create-course">
    <nav-bar />
    <new-course />
  </div>
</template>

<script>
import NavBar from "../components/NavBar.vue";
import NewCourse from "../components/NewCourse.vue";

export default {
  name: "create-course",
  components: {
    NewCourse,
    NavBar,
  },
};
</script>

<style>
</style>