<template>
  <div class="home-page-hero">
    <div class="hero-container">
      <div class="hero-one">
        <h1 class="hero-title">
          Welcome to School {{ $store.state.user.firstname }}!
        </h1>
        <div class="home-page-btn-container">
        <button v-bind="teacher" v-if="!teacher" v-on:click="showCourses">Join New Course</button>
        <join-course v-if="display" />
        <router-link :to="{name: 'create-course'}" tag="button" v-bind="teacher" v-if="teacher">Create Course</router-link>

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
import JoinCourse from './JoinCourse.vue';
export default {
  components: { JoinCourse },
  name: "home-page-hero",
  data() {
    return {
       teacher: this.$store.state.user.authorities.some(e => e ['name'] === "ROLE_TEACHER"),
       display: false,
    }
  },
  methods: {
    showCourses(){
      if (this.display == false) {
        this.display = true;
      } else {
        this.display = false;
      }

    }
  }
};

</script>

<style>
.home-page-hero {
  font-family: 'Schoolbell', cursive;
}
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

  .home-page-btn-container {
  gap: 5px;
  justify-content: center;
}

  .home-page-btn-container button {
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

.home-page-btn-container button:hover {
 background-color: #5e6681;
 color: #ffeba7;
 box-shadow: 0 8px 24px 0 rgb(16 39 112 / 20%);
}
  
  .hero-one {
    flex-direction: column;
    align-self: center;
    color: white;
    width: 50%;
  }

  .hero-one button {
    width: fit-content;
  }

  .hero-title {
    font-size: 48px;
    font-style: extra-bold;
    font-family: #F9FAF8;
  }
  .hero-subtitle {
    font-size: 18px;
    font-family: #E5E7EB;
  }

  .hero-picture {
    border-radius: 8px;
    height: 20vh;
    justify-content: right;
  }
</style>