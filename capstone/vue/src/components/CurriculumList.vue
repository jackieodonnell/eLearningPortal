<template>
  <div class="curriculum-list">
      <div class="curriculum-item" v-for="curriculum in curricula" v-bind:key="curriculum.curriculumId" v-bind:curriculumId="curriculum.curriculumId">
            <!-- <h1 class="header">{{ curriculum.curriculumTitle }}</h1>
            <p class="header">{{ curriculum.curriculumDescription }}</p> -->
            <div class="daily-instructions">
                    <div class="course-overview">
                        <router-link v-bind:to="{name: 'course-page'}" class="overview-item">
                            Course Overview
                        </router-link>
                    </div> 
                     <div class="instruction-item" 
                        v-for="instruction in dailyInstructions" 
                        v-bind:key="instruction.dailyInstructionsId"
                        >
                        <router-link v-bind:to="{name: 'instruction-content', params: {instructionId: instruction.dailyInstructionsId} }" 
                        v-bind:dailyInstructionsId="instruction.dailyInstructionsId"
                        class="instruction-links">
                            {{instruction.instructions}}
                        </router-link>    
                    </div> 

                
            </div>
            <!-- <div class="course-assignments" v-for="assignment in assignments" v-bind:key="assignment.assignmentId">
                <assignment v-bind:assignmentItem="assignment"/>
            </div>   -->
            
      </div>
  </div>
</template>

<script>
import CurriculumService from '../services/CurriculumService.js';
// import Instruction from '../components/Instruction.vue';
import InstructionService from '../services/InstructionService';
// import Assignment from '../components/Assignment.vue';
import AssignmentService from '../services/AssignmentService';
// import InstructionContent from '../components/InstructionContent.vue';

export default {
    name: 'curriculum-list',
    data() {
        return {
            instruction: {},
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
        // Instruction,
        // InstructionContent
        // Assignment
    }
}

</script>

<style>
.instruction-item, .course-overview {
    padding-top: 8px;
    padding-bottom: 8px;
    padding-left: 3%;
    padding-right: 3%;
    border-bottom: 1px solid gray;
}

.instruction-links, .overview-item {
    text-decoration: none;
    font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
    font-size: 1.1rem;
}

</style>