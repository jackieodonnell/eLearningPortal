<template>
  <div class="course-details">
    <div class="course-details-heading">
      <h2 class="course-title">
        {{ course.courseTitle }} | Level: {{ course.difficulty }}
      </h2>
      <p class="course-description">{{ course.courseDescription }}</p>
      <div class="edit-course-overview" v-bind="teacher" v-if="teacher">
        <button id="edit-course-overview-btn">Edit Description</button>
      </div>
    </div>
    <div class="curriculum-details">
      <h3 class="curriculum-title">Curriculum Overview:</h3>
      <p class="curriculum-description">
        {{ curricula[0].curriculumDescription }}
      </p>
      <div class="edit-curriculum-overview" v-bind="teacher" v-if="teacher">
        <button id="edit-curriculum-overview-btn">Edit Overview</button>
      </div>
    </div>
  </div>
</template>

<script>
import courseService from "../services/CourseService";
import CurriculumService from "../services/CurriculumService";

export default {
  name: "course-details",
  components: {},
  data() {
    return {
      course: {
        courseId: "",
        teacherId: "",
        courseTitle: "",
        courseDescription: "",
        difficulty: "",
        cost: "",
      },
      curricula: [],
      teacher: this.$store.state.user.authorities.some(
        (e) => e["name"] === "ROLE_TEACHER"
      ),
    };
  },
  created() {
    courseService
      .getCourseByCourseId(this.$route.params.courseId)
      .then((response) => {
        if (response.status == 200) {
          this.course = response.data;
          this.curricula = CurriculumService.getAllCurriculumInCourse(
            this.course.courseId
          ).then((response) => {
            if (response.status == 200) {
              this.curricula = response.data;
            }
          });
        }
      });
  },
};
</script>

<style>
.course-container {
  padding: 20px;
  display: flex;
  flex-direction: column;
  height: 50vh;
  justify-content: flex-start;
}
.course-container div {
  margin: 10px;
}

.curriculum-details {
  border-top: 1px solid gray;
}

.course-title {
  text-align: center;
}
.course-description {
  text-align: center;
}

.edit-course-overview,
.edit-curriculum-overview {
  text-align: right;
  margin-bottom: 10px;
}

#edit-course-overview-btn,
#edit-curriculum-overview-btn {
  width: fit-content;
  border: none;
  box-shadow: 0 1px 1px 1px rgba(39, 39, 39, 0.171);
  border-radius: 4px;
  font-weight: bold;
  font-size: 0.8em;
  text-transform: uppercase;
  padding: 5px;
  padding-inline: 3%;
  background-color: #f76451;
  color: #f1f1f1;
  transition: all 0.3s ease-in-out;
}

#edit-course-overview-btn:hover,
#edit-curriculum-overview-btn:hover {
  background-color: #f9dc59;
  color: #5e6681;
}
</style>