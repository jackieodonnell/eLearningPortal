<template>
  <div class="curriculum-list">
      <div class="curriculum-item" v-for="curriculum in curricula" v-bind:key="curriculum.curriculumId" v-bind:curriculumId="curriculum.curriculumId">
            <h1>{{ curriculum.curriculumTitle }}</h1>
            <p>{{ curriculum.curriculumDescription }}</p>
            <div class="daily-instructions" v-for="instruction in dailyInstructions" v-bind:key="instruction.dailyInstructionsId">
                <instruction v-bind:instructionItem="instruction"/>
              
            </div>
            <div class="course-assignments" v-for="assignment in assignments" v-bind:key="assignment.assignmentId">
                <assignment v-bind:assignmentItem="assignment"/>
            </div>  
            
      </div>
  </div>
</template>

<script>
import CurriculumService from '../services/CurriculumService.js';
import Instruction from '../components/Instruction.vue';
import InstructionService from '../services/InstructionService';
import Assignment from '../components/Assignment.vue';
import AssignmentService from '../services/AssignmentService';

export default {
    name: 'curriculum-list',
    data() {
        return {
            curricula: [],
            dailyInstructions: [],
            curriculumId: 0,
            assignments: []
        }
    },
    created() {
        CurriculumService.getAllCurriculumInCourse(this.$route.params.courseId).then(response => {
            if(response.status == 200) {
                this.curricula = response.data  
                this.curriculumId = this.curricula[0].curriculumId
            }
        });
        InstructionService.getInstructionsInCourse(this.$route.params.courseId).then(response => {
            if(response.status == 200) {
                this.dailyInstructions = response.data 
            } 
        });
        AssignmentService.getAllAssignmentsInCourse(this.$route.params.courseId).then(response => {
            if (response.status == 200) {
                this.assignments = response.data;
            }
        });
    },
    computed: {

    },
    components: {
        Instruction,
        Assignment
    }
}

</script>

<style>

</style>