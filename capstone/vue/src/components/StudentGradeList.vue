<template>
  <div class="student-grade-list">
    <table class="student-grades-table">
      <thead>
        <tr>
          <th>Assignment</th>
          <th>Score</th>
          <th>Status</th>
          <th>Teacher Feedback</th>
        </tr>
      </thead>
      <tbody>
        <tr
          v-for="grade in grades"
          v-bind:key="grade.gradeId"
          v-bind:grade="grade"
        >
          <td>{{ grade.assignmentTitle }}</td>
          <td>{{ grade.earnedPoints }}/{{ grade.totalPoints }}</td>
          <td>{{ grade.status }}</td>
          <td>{{ grade.feedback }}</td>
        </tr>
      </tbody>
    </table>
    <div class="total-course-score">
      <h2 id="course-score-score">
        Current Course Score: {{ totalCourseScore }}%
      </h2>
    </div>
  </div>
</template>

<script>
import AssignmentService from "../services/AssignmentService";
import gradesService from "../services/GradesService";
export default {
  name: "student-grade-list",
  data() {
    return {
      grades: [],
    };
  },
  created() {
    gradesService
      .allJoinedGradesForStudentInCourse(
        this.$route.params.courseId,
        this.$store.state.user.id
      )
      .then((response) => {
        if (response.status == 200) {
          this.grades = response.data;
        }
      });
  },
  methods: {
    getAssignmentNameById(assignmentId) {
      AssignmentService.getAssignmentById(assignmentId).then((resp) => {
        if (resp.status == 200) {
          const assignment = resp.data;
          return assignment.assignmentTitle;
        }
      });
    },
  },
  computed: {
    totalCourseScore() {
      let earned = 0;
      let total = 0;
      this.grades.forEach((grade) => {
        if (grade.status == "Graded") {
          earned += grade.earnedPoints;
          total += grade.totalPoints;
        }
      });
      return (earned / total) * 100;
    },
  },
};
</script>

<style>
.student-grade-list {
  overflow: auto;
  margin: 30px;
}

.student-grades-table {
  width: 100%;
  border-collapse: collapse;
}

.student-grades-table td {
  border: 1px solid black;
}
</style>