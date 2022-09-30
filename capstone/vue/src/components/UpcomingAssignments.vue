<template>
  <div class="assignments-container">
      <h2 class="title">Upcoming Assignments</h2>
      <table class="assignment-item"> 
         <tr v-for="assignment in assignments" v-bind:key="assignment.assignmentId" v-bind:assignmentItem="assignment">
           <assignment />
        </tr>
      </table>
  </div>
</template>

<script>
import Assignment from '../components/Assignment.vue';
import assignmentService from '../services/AssignmentService';

export default {
  name: "upcoming-assignments",
  data(){
    return {
      assignments: [],
    }
  },
  created(){
    assignmentService.getAllAssignmentsForStudent(this.$store.state.user.id).then(response => {
      if (response.status == 200){
        this.assignments = response.data;
      }
    })
  },
  components: {
    Assignment
  } 
}
</script>

<style>
  .assignments-container {
    display: flex;
  }
</style>