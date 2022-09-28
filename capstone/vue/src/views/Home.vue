<template>
  <div class="home">
    <h1>Home</h1>
    <h2>Hello {{$store.state.user.firstname}}!</h2>
    <!-- p>You must be authenticated to see this</p -->
    <course-list />
    <div class="footer">
      <h1>footer</h1>
    </div>
  </div>
</template>

<script>
import CourseList from '../components/CourseList.vue';
// import NavBar from '../components/NavBar.vue';

export default {
  name: "home",
  components: {
    // NavBar,
    CourseList
  }
};
</script>

<style>
.home {
  /* background-image: url(https://images.unsplash.com/photo-1614292253351-4deb4913c142?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1170&q=80);
  background-size: cover; */
  display: grid;
  grid-template-columns: 1fr 8fr 1fr;
  grid-template-areas:
  "navbar navbar navbar"
  "welcome welcome welcome"
  ". courses ."
  "footer footer footer"
}

.welcome {
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
  grid-area: welcome;
  height: 20vh;
}

.footer {
  grid-area: footer;
  height: 10vh;
}


</style>
