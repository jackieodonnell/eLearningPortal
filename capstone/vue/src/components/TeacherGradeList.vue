<template>
    <div class="teacher-grade-list">
        <!-- <grade-card class="grade-card" v-for="grade in grades"
    v-bind:key="grade.gradeId" v-bind:grade="grade"> </grade-card> -->
        <thead>
            <tr></tr>
        </thead>
        <tbody>
            <tr v-for="grade in grades" v-bind:key="grade.gradeId" v-bind:grade="grade">
                <td> {{ grade }}</td>
            </tr>
        </tbody>
    </div>
</template>

<script>
// import GradeCard from './GradeCard.vue';
import gradesService from '../services/GradesService';

export default {
    name: "teacher-grade-list",
    data() {
        return {
            grades: []
        }
    },
    components: {
    //   GradeCard
    },
    created(){
        gradesService.getAllGrades()
            .then(response => {
                if (response.status == 200) {
                    this.grades = response.data;
                    console.log(this.grades)
                }
            })
    
    }
}
</script>

<style>

</style>
