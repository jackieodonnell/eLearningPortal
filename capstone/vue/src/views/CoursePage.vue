<template>
  <div class="course-page">
    <nav-bar />
    <class-page-hero />
    <div class="curriculum-container">
      <div class="sidebar">
        <curriculum-list />
      </div>
      <div class="content">
        <course-details v-if="this.$route.name == 'course-page'" />
        <router-view v-else></router-view>
      </div>
    </div>
    <footer-section />
  </div>
</template>

<script>
import NavBar from "../components/NavBar.vue";
import ClassPageHero from "../components/ClassPageHero.vue";
import CurriculumList from "../components/CurriculumList.vue";
import CourseDetails from "../components/CourseDetails.vue";
import FooterSection from "../components/FooterSection.vue";

export default {
  name: "course-page",
  components: {
    NavBar,
    ClassPageHero,
    CurriculumList,
    CourseDetails,
    FooterSection,
  },
};
</script>

<style>
.course-page {
  background-color: #ddddddb0;
}

.details-container {
  margin-top: 20px;
  width: 100%;
  height: 10%;
  background-color: white;
  justify-content: center;
  display: flex;
  flex-direction: column;
  min-height: 25%;
}
.details-title {
  text-align: center;
  font-size: 36px;
  font-weight: 1000;
  color: #1f2937;
}

.assignments-container {
  display: flex;
  height: 30vh;
  background-color: #e5e7eb;
  justify-items: center;
  align-items: center;
}
.assignments-box {
  background-color: #e5e7eb;
  text-align: center;
  font-size: 18px;
  font-style: italic;
  font-weight: lighter;
  margin: 80px;
}

.curriculum-container {
  box-shadow: 0 0 0 1px rgba(107, 107, 107, 0.185);
  font-family: "Segoe UI", Tahoma, Geneva, Verdana, sans-serif;
  margin-left: 15%;
  margin-right: 15%;
  margin-bottom: 5%;
  display: flex;
  border: none;
  border-radius: 4px;
  background-color: #f6f4f7;
  min-height: 80vh;
}
.sidebar {
  flex: 0 0 25%;
  flex-direction: column;
  flex-wrap: wrap;
  margin-right: 1%;
  background-color: #040f31de;
  max-width: 25%;
}

.content {
  flex: 0 0 70%;
  flex-direction: column;
  background-color: #f6f4f7;
  padding-left: 1%;
  max-width: 75%;
}
</style>