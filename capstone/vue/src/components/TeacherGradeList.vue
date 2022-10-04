<template>
    <div class="teacher-grade-list">
        <grade-card class="grade-card" v-for="grade in grades"
    v-bind:key="grade.gradeId" v-bind:grade="grade"> </grade-card>
    </div>
</template>

<script>
import GradeCard from './GradeCard.vue';
import gradesService from '../services/GradesService';

export default {
    name: "teacher-grade-list",
    data() {
        return {
            grades: []
        }
    },
    components: {
      GradeCard
    },
    created(){
        gradesService.allGradesForAssignment(this.$route.params.assignmentId)
            .then(response => {
                if (response.status == 200) {
                this.grades = response.data
                }
            })
    
    }
}
</script>

<style>

</style>
