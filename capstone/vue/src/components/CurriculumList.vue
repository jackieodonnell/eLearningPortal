<template>
  <div class="curriculum-list">
      <div class="curriculum-item" v-for="curriculum in curricula" v-bind:key="curriculum.curriculumId" v-bind:curriculumId="curriculum.curriculumId">
            <h1 class="header">{{ curriculum.curriculumTitle }}</h1>
            <p class="header">{{ curriculum.curriculumDescription }}</p>
            <div class="daily-instructions"> 
                <div class="sidebar">
                    <router-link v-bind:to="{name: 'course-page'}" v-for="instruction in dailyInstructions" v-bind:key="instruction.dailyInstructionsId">
                        <instruction v-bind:instructionItem="instruction" />
                    </router-link>    
                </div>
                <div class="content">
                    {{ instruction.content }}
                    <!-- <instruction-content v-bind:instructionItem="this.instruction"/> -->
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
import Instruction from '../components/Instruction.vue';
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
        Instruction,
        // InstructionContent
        // Assignment
    }
}

</script>

<style>
/* .curriculum-item{
    display: grid;
    grid-template-columns: 1 fr 1 fr 1 fr 1 fr 1 fr;
    grid-template-areas:
        "head head head head head"
        "side main main main main";
    gap: 40px;
} */
/* .header {
    grid-area: head;
} */
.daily-instructions {
    display: flex;
}

.sidebar {
    width: 20%;
    flex-direction: column;
    flex: 0 0 auto;
    display: flex;
}

.content {
    flex: 1 1 auto;
}

</style>