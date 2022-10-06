<template>
  <div class="grades">
    <nav-bar />
    <grade-page-hero />
    <student-grade-list v-if="!teacher" id="student-grade-list" />
    <teacher-grade-list v-if="teacher" id="teacher-grade-list" />
    <footer-section id="grades-footer" />
  </div>
</template>

<script>
import FooterSection from "../components/FooterSection.vue";
import GradePageHero from "../components/GradePageHero.vue";
import NavBar from "../components/NavBar.vue";
import StudentGradeList from "../components/StudentGradeList.vue";
import TeacherGradeList from "../components/TeacherGradeList.vue";

export default {
  name: "grades",
  components: {
    TeacherGradeList,
    NavBar,
    GradePageHero,
    StudentGradeList,
    FooterSection,
  },
  data() {
    return {
      teacher: this.$store.state.user.authorities.some(
        (e) => e["name"] === "ROLE_TEACHER"
      ),
    };
  },
};
</script>

<style>
/* .account {
  display: flex;
  align-items: center;
  justify-content: center;
} */

.grades {
  background-color: #ddddddb0;
}

#student-grade-list {
  width: 70%;
  box-shadow: 0 0 0 1px rgba(107, 107, 107, 0.185);
  font-family: "Segoe UI", Tahoma, Geneva, Verdana, sans-serif;
  margin-left: 15%;
  margin-right: 15%;
  margin-top: 2px;
  padding-top: 5%;
  padding-left: 20px;
  padding-right: 20px;
  border: none;
  border-radius: 4px;
  background-color: #f6f4f7;
  min-height: 50vh;
}
#teacher-grade-list {
  width: 70%;
  box-shadow: 0 0 0 2px rgba(182, 179, 179, 0.281);
  font-family: "Segoe UI", Tahoma, Geneva, Verdana, sans-serif;
  margin-left: 15%;
  margin-right: 15%;
  margin-top: 1px;
  margin-bottom: 50px;
  padding-top: 15px;
  padding-left: 20px;
  padding-right: 20px;
  padding-bottom: 15px;
  border: none;
  border-radius: 4px;
  background-color: #f6f4f7;
  min-height: 50vh;
}
</style>