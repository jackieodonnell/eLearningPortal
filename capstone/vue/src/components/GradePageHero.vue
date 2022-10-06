<template>
  <div class="grade-page-hero">
    <div class="hero-container">
      <div class="hero-one">
        <h1 class="hero-title">{{ course.courseTitle }}</h1>
        <div class="course-btns-container">
          <router-link :to="{ name: 'course-page' }" tag="button"
            >View Course</router-link
          >
        </div>
      </div>
      <div class="hero-two">
        <img
          class="hero-picture"
          src="https://d92mrp7hetgfk.cloudfront.net/images/sites/misc/Tech_Elevator/original.png?1579896670"
        />
      </div>
    </div>
  </div>
</template>

<script>
import courseService from "../services/CourseService";

export default {
  name: "grade-page-hero",
  data() {
    return {
      course: {
        courseId: "",
        teacherId: "",
        courseTitle: "",
        courseDescription: "",
        difficulty: "",
        cost: "",
        isArchived: "",
      },
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
        }
      });
  },
};
</script>

<style>
.hero-container div {
  display: flex;
}

.hero-one {
  align-self: center;
  justify-content: flex-start;
  color: #f4ff57;
  width: 50%;
}
.course-btns-container {
  gap: 5px;
  justify-content: center;
}

.course-btns-container button {
  margin-right: 10px;
  border: none;
  border-radius: 4px;
  font-weight: bold;
  font-size: 0.8em;
  text-transform: uppercase;
  padding: 10px;
  background-color: #f9dc59;
  color: #5e6681;
  box-shadow: 0 8px 24px 0 #1e1c3b9f;
  transition: all 0.3s ease-in-out;
}

.course-btns-container button:hover {
  background-color: #5e6681;
  color: #ffeba7;
  box-shadow: 0 8px 24px 0 rgb(16 39 112 / 20%);
}

.hero-title {
  font-family: "Schoolbell", cursive;
  text-align: center;
  font-size: 48px;
  font-style: extra-bold;
  color: #f9faf8;
}
.hero-subtitle {
  font-size: 18px;
  color: #e5e7eb;
}

.hero-picture {
  border-radius: 8px;
  height: 20vh;
  justify-content: right;
}
</style>