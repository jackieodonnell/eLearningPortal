<template>
  <div class="teacher-grade-list">
    <div
      class="assignment-div"
      v-for="assignment in assignments"
      v-bind:key="assignment.assignmentId"
    >
      <h2 id="assignment-title">{{ assignment.assignmentTitle }}</h2>
      <table class="assignment-table">
        <thead>
          <tr>
            <td>Student Name</td>
            <td>Grade</td>
          </tr>
        </thead>
        <tbody>
          <tr></tr>
        </tbody>
      </table>
    </div>
  </div>
</template>

<script>
import AssignmentService from "../services/AssignmentService";
// import GradeCard from "./GradeCard.vue";
// import gradesService from "../services/GradesService";

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
    AssignmentService.getAllAssignmentsInCourse(
      this.$route.params.courseId
    ).then((response) => {
      if (response.status == 200) {
        this.assignments = response.data;
      }
    });
  },
  // methods: {
  //   // gradesService.getAllJoinedGradesForAssignment(){

  //   }
  // },
  // computed: {},
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
