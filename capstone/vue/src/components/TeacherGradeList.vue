<template>
  <div class="teacher-grade-list">
    <grade-card class="grade-card" v-for="grade in grades"
    v-bind:key="grade.gradeId" v-bind:grade="grade"> </grade-card>
    <table class="grades-table">
    <thead>
      <tr>
          <!-- get student name from studentId -->
        <th>Student Name</th>
        <!-- get assignment name for header below using v-for -->
        <th >Assignment Name</th>
        <th>Assignment Id</th>
      </tr>
    </thead>
    <tbody>
        <tr
        v-for="grade in grades"
        v-bind:key="grade.gradeId"
        v-bind:grade="grade"
      >
        <td>{{ grade.studentId }}</td>
        <td >{{ grade.earnedPoints }}/{{ grade.totalPoints }}</td>
        <td> {{ grade.assignmentId }}</td>
        <!-- <td>{{ grade.status }}</td> -->
        </tr>
    </tbody>

    </table>
  </div>
</template>

<script>
import AssignmentService from '../services/AssignmentService';
// import GradeCard from "./GradeCard.vue";
import gradesService from "../services/GradesService";

export default {
  name: "teacher-grade-list",
  data() {
    return {
      grades: [],
      assignments: [],
    };
  },
  components: {
    // GradeCard,
  },
  created() {
    gradesService.getAllGrades().then((response) => {
      if (response.status == 200) {
        const tempGrades = response.data;
        this.grades = tempGrades.filter((grade) => {
          return grade.courseId == this.$route.params.courseId;
        });
        console.log(this.grades);
      }
    });
    AssignmentService.getAllAssignmentsInCourse(this.$route.params.courseId).then((resp) => {
        if (resp.status == 200) {
            this.assignments = resp.data;
        }
        
    });


  },
  computed: {},
};
</script>

<style>
.teacher-grade-list {
    overflow: auto;
    margin: 30px;
}

.grades-table {
    width: 100%;
    border-collapse: collapse;
}

.grades-table td {
    border: 1px solid black;
    
}



</style>
