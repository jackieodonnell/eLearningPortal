<template>
  <div class="assignment">
      <h2 class="assigned-date"> Assigned On: {{assignment.assignedDate}}</h2> | <h2 class="due-date">{{dueDate}}</h2>
      <h2 class="assignment-title">{{assignment.assignmentTitle}}</h2>
      <p class="assignment-description">{{assignment.assignmentDescription}}</p>
  </div>
</template>

<script>
import assignmentService from '../services/AssignmentService';

export default {
  name: "assignment",
  props: ['assignmentItem'],
  data(){
      return {
          assignment: {
              assignmentId: '',
              dailyInstructionsId: '',
              assignedDate: '',
              dueDate: '',
              assignmentTitle: '',
              assignmentDescription: '',
              assignmentType: ''
          }
      }
  },
  created(){
      assignmentService.getAssignmentById(this.assignmentItem.assignmentId).then(
          response => {
              if (response.status == 200){
                  this.assignment = response.data;
              }
          }
      )
  }
}
</script>
  

<style>

</style>