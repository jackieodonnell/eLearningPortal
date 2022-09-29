<template>
  <div>
      {{dailyInstruction.instructions}}
  </div>
</template>

<script>
import InstructionService from '../services/InstructionService'

export default {
    name: "instruction",
    props: ['curriculum'],
    data(){
    return {
        dailyInstruction: {

            dailyInstructionsId: '',
            currentDay: '',
            curriculumId: '',
            instructions: ''
        
        }
    }
},
    created() {
        InstructionService.getInstructionsInCurriculum(this.curriculum.curriculumId).then(response => {
            if(response.status == 200) {
                this.dailyInstruction = response.data
            }
        })
    }
}
</script>

<style>

</style>