<template>
  <div class="create-course">
      <new-course />
  </div>
</template>

<script>
import NewCourse from '../components/NewCourse.vue';

export default {
    name: "create-course",
    components: { 
        NewCourse 
    },
};
</script>

<style>

</style>