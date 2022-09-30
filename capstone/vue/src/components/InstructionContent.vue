<template>
  <div>
      {{dailyInstruction.content}}
  </div>
</template>

<script>
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
        }
    }
},
    created() {
        InstructionService.getInstructionById(this.$route.params.instructionId).then(
            response => {
                if (response.status == 200){
                    this.dailyInstruction = response.data;
                }
        })
        }
}

</script>

<style>

</style>