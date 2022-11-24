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
            instructions: '',
            content: ''
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
    },
    methods: {
        displayContent(event){
            this.instruction = event.target;
        }
    },
}

</script>

<style>

</style>