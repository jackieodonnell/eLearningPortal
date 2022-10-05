<template>
    <div class="teacher-grade-list">
        <table>
            <tr>
                <th> Grade </th>
                <th> Status </th>
                <th> Submission Content </th>
            </tr>
        </table>
        <grade-card class="grade-card" v-for="grade in grades"
    v-bind:key="grade.gradeId" v-bind:grade="grade"> </grade-card>
    </div>
</template>

<script>
import GradeCard from './GradeCard.vue';
import gradesService from '../services/GradesService';
import assignmentService from '../services/AssignmentService';

export default {
    name: "teacher-grade-list",
    data() {
        return {
            grades: [],
            assignments: [],
        }
    },
    components: {
      GradeCard,
    },
    created(){
        gradesService.allGradesForAssignment(this.assignments.assignmentId[0])
            .then(response => {
                if (response.status == 200) {
                    this.grades = response.data;
                }
            });
        assignmentService.getAllAssignmentsInCourse(this.$route.params.courseId)
            .then(response => {
                if (response.status == 200) {
                    this.assignments = response.data;
                }
            });
    
    }
}
</script>

<style>

</style>
