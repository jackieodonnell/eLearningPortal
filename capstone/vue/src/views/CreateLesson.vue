<template>
  <div class="create-lesson-view">
      <nav-bar />
      <new-lesson />
  </div>
</template>

<script>
import NavBar from "../components/NavBar.vue"
import NewLesson from "../components/NewLesson.vue"

export default {
    name: "create-lesson",
  components: { NavBar, NewLesson }

}
</script>

<style>

</style>