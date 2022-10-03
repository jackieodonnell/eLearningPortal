<template>
  <div class="assignment">
        <h2>&#128211;{{assignment.assignmentType}} Due On: {{assignment.dueDate}}</h2>
        <h3>{{assignment.assignmentTitle}}</h3>
        <p>{{assignment.assignmentDescription}}</p>
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