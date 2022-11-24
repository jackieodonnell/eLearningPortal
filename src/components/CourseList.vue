<template>
  <div class="courses-container">
    <course-card
      class="card"
      v-for="course in activeCourses"
      v-bind:key="course.courseTitle"
      v-bind:course="course"
    >
    </course-card>
  </div>
</template>

<script>
import CourseCard from "./CourseCard.vue";
import courseService from "../services/CourseService";

export default {
  name: "course-list",
  data() {
    return {
      courses: [],
    };
  },
  components: {
    CourseCard,
  },
  created() {
    if (
      this.$store.state.user.authorities.some(
        (e) => e["name"] === "ROLE_STUDENT"
      )
    ) {
      courseService
        .getCoursesForStudent(this.$store.state.user.id)
        .then((response) => {
          if (response.status == 200) {
            this.courses = response.data;
          }
        });
    } else if (
      this.$store.state.user.authorities.some(
        (e) => e["name"] === "ROLE_TEACHER"
      )
    ) {
      courseService
        .getCoursesForTeacher(this.$store.state.user.id)
        .then((response) => {
          if (response.status == 200) {
            this.courses = response.data;
          }
        });
    }
  },
  computed: {
    activeCourses() {
      let activeCourses = this.courses.filter((course) => {
        return !course.archived;
      });
      return activeCourses;
    },
  },
};
</script>

<style>
.courses-container {
  grid-area: courses;
  display: flex;
  justify-content: center;
  gap: 10px;
  flex-wrap: wrap;
}
</style>