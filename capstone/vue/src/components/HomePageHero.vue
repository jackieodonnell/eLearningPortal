<template>
  <div class="home-page-hero">
    <div class="hero-container">
      <div class="hero-one">
        <h1 class="hero-title">
          Welcome to School, {{ $store.state.user.firstname }}!
        </h1>
        <div class="home-page-btn-container">
          <button v-bind="teacher" v-if="!teacher" v-on:click="showCourses">
            Join New Course
          </button>
          <join-course v-if="display" />

          <button
            id="create-course-button"
            v-bind="teacher"
            v-if="teacher && !displayNewCourseForm"
            v-on:click.prevent="toggleNewCourseForm"
          >
            Create Course
          </button>

          <new-course
            id="new-course-form-popup"
            v-if="displayNewCourseForm"
            v-on:toggle-form="toggleNewCourseForm"
          />
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
import JoinCourse from "./JoinCourse.vue";
import NewCourse from "./NewCourse.vue";
export default {
  components: { JoinCourse, NewCourse },
  name: "home-page-hero",
  data() {
    return {
      teacher: this.$store.state.user.authorities.some(
        (e) => e["name"] === "ROLE_TEACHER"
      ),
      display: false,
      displayNewCourseForm: false,
    };
  },
  methods: {
    showCourses() {
      if (this.display == false) {
        this.display = true;
      } else {
        this.display = false;
      }
    },
    toggleNewCourseForm() {
      if (this.displayNewCourseForm == false) {
        this.displayNewCourseForm = true;
      } else {
        this.displayNewCourseForm = false;
      }
    },
  },
};
</script>

<style>
.home-page-hero {
  font-family: "Schoolbell", cursive;
}
.hero-container {
  display: flex;
  justify-content: space-between;
  background-color: #04469e;
  max-height: 20%;
}

.hero-container div {
  display: flex;
  padding: 20px;
}

.home-page-btn-container {
  gap: 5px;
  justify-content: center;
}

.home-page-btn-container button {
  margin: 5px;
  border: none;
  border-radius: 4px;
  font-weight: bold;
  font-size: 0.8em;
  text-transform: uppercase;
  padding: 10px;
  background-color: #f9dc59;
  color: #001a33d0;
  box-shadow: 0 8px 24px 0 #1e1c3b9f;
  transition: all 0.3s ease-in-out;
}

.home-page-btn-container button:hover {
  background-color: #5e6681;
  color: #f9dc59;
  box-shadow: 0 8px 24px 0 #1e1c3b9f;
  transition: all 0.3s ease-in-out;
}

.hero-one {
  flex-direction: column;
  align-self: center;
  color: #f6f4f7;
  width: 50%;
}

.hero-one button {
  width: fit-content;
}

.hero-title {
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

#new-course-form-popup {
  z-index: 100;
  width: 60%;
  position: fixed;
  left: 70%;
  display: block;
  transform: translate(-80%, -45%);
}
</style>