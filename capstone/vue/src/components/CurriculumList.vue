<template>
  <div class="curriculum-list">
      <div class="curriculum-item" v-for="curriculum in curricula" v-bind:key="curriculum.curriculumId" v-bind:curriculumId="curriculum.curriculumId">
            <h1>{{ curriculum.curriculumTitle }}</h1>
            <p>{{ curriculum.curriculumDescription }}</p>
            <div v-for="instruction in dailyInstructions" v-bind:key="instruction.dailyInstructionsId">
                <instruction v-bind:instructionItem="instruction"/>
            </div>
      </div>
  </div>
</template>

<script>
import CurriculumService from '../services/CurriculumService.js'
import Instruction from '../components/Instruction.vue'
import InstructionService from '../services/InstructionService'

export default {
    name: 'curriculum-list',
    data() {
        return {
            curricula: [],
            dailyInstructions: [],
            curriculumId: 0
        }
    },
    created() {
        CurriculumService.getAllCurriculumInCourse(this.$route.params.courseId).then(response => {
            if(response.status == 200) {
                this.curricula = response.data  
                this.curriculumId = this.curricula[0].curriculumId
            }
        });
        InstructionService.getInstructionsInCurriculum(1).then(response => {
            console.log(this.curriculumId)
            console.log('CONSOLE LOG - SOMETHING' + response)
            if(response.status == 200) {
                this.dailyInstructions = response.data 
            } 
        });
    },
    computed: {

    },
    components: {
        Instruction
    }
}

</script>

<style>

</style>