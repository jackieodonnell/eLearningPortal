<template>
  <div class="joinClass">
    <form action="join-class" v-on:submit.prevent="enrollInCourse" >
      <select name="courses" id="courses" v-model="selection">
        <option
          v-for="course in courses"
          v-bind:key="course.courseTitle"
          v-bind:course="course"
        >
          {{ course.courseTitle }}-- Course ID: {{ course.courseId }}
        </option>
      </select>
      <input type="submit" id="join-course-btn" value="Join" />
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
      selection: ''
    };
  },
  computed: {
    selectedCourseId(){
      return this.selection.charAt(this.selection.length - 1);
    }
  },
  created() {
    courseService.getCourses().then((response) => {
      this.courses = response.data;
    });
  },
  methods: {
      enrollInCourse() {
          courseService.enrollInCourse(this.studentCourse.studentId, this.selectedCourseId).then(response => {
              if (response.status == 201) {
                  this.$router.go()
              } else {
                  console.log("Error -- failed to join course")
              }
          })
      }
  }
};
</script>

<style>
#join-course-btn {
  width: fit-content;
  display: inline;
  height: fit-content;
  font-size: 1rem;
  border-radius: 8px;
  background-color: rgb(73, 109, 226);
  border: none;
  color: white;
  padding: 1%;
  text-decoration: none;
  margin: 4px 4px;
  cursor: pointer;
}

#join-course-btn:hover {
    background-color:#04AA6D
}
</style>