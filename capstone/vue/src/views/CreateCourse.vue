<template>
  <div class="create-course">
    <nav-bar />
    <home-page-hero />
    <new-course />
    <footer-section />
  </div>
</template>

<script>
import FooterSection from "../components/FooterSection.vue";
import HomePageHero from "../components/HomePageHero.vue";
import NavBar from "../components/NavBar.vue";
import NewCourse from "../components/NewCourse.vue";

export default {
  name: "create-course",
  components: {
    NewCourse,
    NavBar,
    HomePageHero,
    FooterSection,
  },
};
</script>

<style>
</style>