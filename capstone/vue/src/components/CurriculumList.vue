<template>
  <div class="curriculum-list">
      <div class="curriculum-item" v-for="curriculum in curricula" v-bind:key="curriculum.curriculumId">
            <h1>{{ curriculum.curriculumTitle }}</h1>
            <p>{{ curriculum.curriculumDescription }}</p>
            <div>
            <instruction/>
            </div>
      </div>
  </div>
</template>

<script>
import CurriculumService from '../services/CurriculumService.js'
import Instruction from '../components/Instruction.vue'

export default {
    name: 'curriculum-list',
    data() {
        return {
            curricula: []
        }
    },
    created() {
        CurriculumService.getAllCurriculumInCourse(this.$route.params.courseId).then(response => {
            if(response.status == 200) {
                this.curricula = response.data
            }
        })
    },
    components: {
        Instruction
    }
}

</script>

<style>

</style>