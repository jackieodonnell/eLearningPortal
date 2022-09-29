<template>
  <div>
      {{dailyInstruction.currentDay}}
      {{dailyInstruction.instructions}}
  </div>
</template>

<script>
import InstructionService from '../services/InstructionService'

export default {
    name: "instruction",
    props: ['instructionItem'],
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
        InstructionService.getInstructionById(this.instructionItem.dailyInstructionsId).then(
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