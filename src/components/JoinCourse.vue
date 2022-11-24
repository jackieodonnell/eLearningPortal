<template>
  <div class="joinClass">
    <form action="join-class" v-on:submit.prevent="enrollInCourse">
      <select name="courses" id="courses" v-model="selection">
        <option
          v-for="course in filteredCourses()"
          v-bind:key="course.courseTitle"
          v-bind:course="course"
        >
          {{ course.courseTitle }}-- Course ID: {{ course.courseId }}
        </option>
      </select>
      <input type="submit" value="Join" id="join-course-submit-btn" />
    </form>
  </div>
</template>

<script>
import courseService from "../services/CourseService";
export default {
  name: "join-class",
  data() {
    return {
      studentCourse: {
        studentId: this.$store.state.user.id,
        courseId: this.selectedCourseId,
      },
      courses: [],
      selection: "",
    };
  },
  computed: {
    selectedCourseId() {
      return this.selection.charAt(this.selection.length - 1);
    },
  },
  created() {
    courseService.getCourses().then((response) => {
      this.courses = response.data;
    });
  },
  methods: {
    filteredCourses() {
      let filteredCourses = this.courses;
      return filteredCourses.filter((course) => course.archived == false)
    },
    enrollInCourse() {
      courseService
        .enrollInCourse(this.studentCourse.studentId, this.selectedCourseId)
        .then((response) => {
          if (response.status == 201) {
            this.$router.go();
          } else {
            console.log("Error -- failed to join course");
          }
        });
    },
  },
};
</script>

<style>
#join-course-submit-btn {
  min-height: 100%;
  min-width: fit-content;
  padding: 5px;
}
</style>