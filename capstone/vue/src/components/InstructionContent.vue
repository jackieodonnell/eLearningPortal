<template>
  <div>
      <div id="instruction-heading">        
        <h3>{{dailyInstruction.currentDay}}</h3>  
        <h2>{{dailyInstruction.instructions}}</h2>
      </div>
      <div id="instruction-content">
        <p>{{dailyInstruction.content}}</p>
      </div>
      <div id="assignment-content" v-for="assignment in assignments" v-bind:key="assignment.assignmentId">
        <h2>&#128211;{{assignment.assignmentType}} Due On: {{assignment.dueDate}}</h2>
        <h3>{{assignment.assignmentTitle}}</h3>
        <p>{{assignment.assignmentDescription}}</p>
      </div>
  </div>
</template>

<script>
import AssignmentService from '../services/AssignmentService';
import InstructionService from '../services/InstructionService'

export default {
    name: "instruction-content",
    props: {
        dailyInstructionsId: Number,
    },
    data(){
    return {
        dailyInstruction: {

            dailyInstructionsId: '',
            currentDay: '',
            curriculumId: '',
            instructions: '',
            content: ''
        },
        assignments: [],
        // assignment: {
        //     assignmentId: '',
        //     dailyInstructionsId: '',
        //     assignedDate: '',
        //     dueDate: '',
        //     assignmentTitle: '',
        //     assignmentDescription: '',
        //     assignmentType: ''
        // }
    }
},
    created() {
        InstructionService.getInstructionById(this.$route.params.instructionId).then(
            response => {
                if (response.status == 200){
                    this.dailyInstruction = response.data;
                    AssignmentService.getAllAssignmentsInDailyInstruction(this.dailyInstruction.dailyInstructionsId).then(resp => {
                        if (resp.status == 200){
                            this.assignments = resp.data;
                        }
                    })
                }
        })
    },
    updated() {
        InstructionService.getInstructionById(this.$route.params.instructionId).then(
            response => {
                if (response.status == 200){
                    this.dailyInstruction = response.data;
                }
        })
    },
    
}

</script>

<style>
#instruction-heading {
    text-align: center;
}
#assignment-content {
    border-top: 1px solid gray;
    text-transform: capitalize;
}

</style>