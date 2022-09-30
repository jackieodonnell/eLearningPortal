<template>
  <div class="class-page-hero">
    <div class="hero-container">
      <div class="hero-one">
        <h1 class="hero-title">{{ course.courseTitle }}</h1>
        <div class="course-btns-container">
          <router-link :to="{}" tag="button" v-bind="teacher" v-if="teacher">Add Curriculum</router-link>
          <router-link :to="{}" tag="button" v-bind="teacher" v-if="teacher">Edit Curriculum</router-link>
          <router-link :to="{}" tag="button" v-bind="teacher" v-if="teacher">Delete Curriculum</router-link>
          <router-link :to="{}" tag="button" v-bind="teacher" v-if="teacher">Delete Course</router-link>

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
  name: "class-page-hero",
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
      teacher: this.$store.state.user.authorities.some(e => e ['name'] === "ROLE_TEACHER")
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
.hero-container {
  display: flex;
  justify-content: space-between;
  background: #000b6c;
  height: 25%;
}

.hero-container div {
  display: flex;
  margin: 50px;
  /* border: 1px solid red; */
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
 margin: 5px;
 border: none;
 border-radius: 4px;
 font-weight: bold;
 font-size: .8em;
 text-transform: uppercase;
 padding: 3px;
 background-color: #f4ff57;
 color: #5e6681;
 box-shadow: 0 8px 24px 0 rgb(255 235 167 / 20%);
 transition: all .3s ease-in-out;
}

.course-btns-container button:hover {
 background-color: #5e6681;
 color: #ffeba7;
 box-shadow: 0 8px 24px 0 rgb(16 39 112 / 20%);
}

.hero-title {
  text-align: center;
  font-size: 48px;
  font-style: extra-bold;
  font-family: #f9faf8;
}
.hero-subtitle {
  font-size: 18px;
  font-family: #e5e7eb;
}

.hero-picture {
  border-radius: 8px;
  height: 20vh;
  justify-content: right;
}
</style>