<template>
  <div class="student-grade-list">
    <view-grade-form
      id="view-grade-form"
      v-if="displayViewGradeForm"
      v-on:exit-view-grade="toggleViewGradeForm"
      v-bind:currentGradeObject="currentGradeObject"
    />
    <h1 id="course-progress-title">Your Course Progress</h1>
    <table class="student-grades-table">
      <thead>
        <tr>
          <th id="assignment-name">Assignment</th>
          <th id="grade-status">Status</th>
          <th id="grade-points">Grade</th>
          <th id="view-column">Details</th>
        </tr>
      </thead>
      <tbody>
        <tr
          v-for="grade in grades"
          v-bind:key="grade.gradeId"
          v-bind:grade="grade"
          v-bind:class="{
            'submitted-highlight': grade.status == 'Submitted',
            'incomplete-highlight': grade.status == 'Incomplete',
          }"
        >
          <td>{{ grade.assignmentTitle }}</td>
          <td>{{ grade.status }}</td>
          <td id="points">{{ grade.earnedPoints }}/{{ grade.totalPoints }}</td>
          <td id="view-grade-btn-container">
            <button
              id="view-grade-detail-btn"
              v-on:click="toggleViewGradeForm(), setCurrentGradeObject(grade)"
            >
              View
            </button>
          </td>
        </tr>
      </tbody>
    </table>
    <div class="total-course-score">
      <h2 id="course-score-text">Current Course Score:</h2>
      <h2 id="course-score-number">{{ totalCourseScore }}</h2>
    </div>
  </div>
</template>

<script>
import AssignmentService from "../services/AssignmentService";
import gradesService from "../services/GradesService";
import ViewGradeForm from "./ViewGradeForm.vue";
export default {
  name: "student-grade-list",
  components: { ViewGradeForm },
  data() {
    return {
      grades: [],
      currentGradeObject: {},
      displayViewGradeForm: false,
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
          this.grades.sort((a, b) => (a.assignmentId > b.assignmentId ? 1 : -1))
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
    toggleViewGradeForm() {
      if (this.displayViewGradeForm == false) {
        this.displayViewGradeForm = true;
      } else {
        this.displayViewGradeForm = false;
      }
    },
    setCurrentGradeObject(grade) {
      this.currentGradeObject = grade;
    },
  },
  computed: {
    totalCourseScore() {
      let earned = 0;
      let total = 0;
      this.grades.forEach((grade) => {
        if (grade.status == "Graded") {
          earned += parseInt(grade.earnedPoints);
          total += parseInt(grade.totalPoints);
        }
      });
      if (this.grades.length == 0) {
        return "You have no grade yet";
      }

      return Math.round((earned / total) * 100) + "%";
    },
  },
};
</script>

<style>
#course-progress-title {
  text-align: center;
  padding: 5px;
  font-size: 1.5rem;
  margin-left: 20%;
  margin-right: 20%;
  margin-top: -40px;
  margin-bottom: 20px;
  text-transform: uppercase;
  border-bottom: 1px solid #040f3142;
  color: #040f31a1;
  font-weight: 500;
}
.student-grade-list {
  display: flex;
  flex-direction: column;
}

.student-grades-table {
  width: 90%;
  border: 1px solid rgba(58, 58, 58, 0.164);
  box-shadow: 0 0 0 2px rgba(131, 130, 130, 0.089);
  border-radius: 10px;
  border-collapse: collapse;
  margin-left: 5%;
  margin-bottom: 40px;
}
.student-grades-table thead {
  font-weight: bold;
  font-size: 1rem;
  background-color: #ddddddb0;
  color: #040f31de;
  border-bottom: 2px solid rgba(58, 58, 58, 0.425);
  border-top: 1px solid rgba(58, 58, 58, 0.164);
  box-shadow: 0 0 0 2px rgba(131, 130, 130, 0.089);
}

.student-grades-table td {
  border: 1px solid rgba(105, 105, 105, 0.11);
  padding-left: 5px;
  padding-bottom: 5px;
  padding-top: 5px;
  padding-right: 5px;
}

#assignment-name {
  width: 60%;
}

#grade-points {
  width: 10%;
}

#grade-status {
  width: 15%;
}

#view-column {
  width: 10%;
  text-align: center;
}

#grade-score-btn {
  width: 90%;
}

#view-grade-detail-btn {
  margin-left: 15%;
  width: fit-content;
  border: none;
  box-shadow: 0 1px 1px 1px rgba(39, 39, 39, 0.171);
  border-radius: 4px;
  font-weight: bold;
  font-size: 0.8em;
  text-transform: uppercase;
  padding: 5px;
  padding-inline: 8%;
  background-color: #5e6681;
  color: #fff8e2;
  box-shadow: 0 8px 24px 0 rgb(16 39 112 / 20%);
}

#view-grade-detail-btn:hover {
  background-color: #0b60ce;
  color: #fcfbf7;
  box-shadow: 0 8px 24px 0 rgb(16 39 112 / 50%);
  transform: translateX(1%);
  transform: translate3d(2%, 2%, 2%);
}

#view-grade-form {
  position: fixed;
  left: 50%;
  right: 0%;
  max-height: 90vh;
  transform: translate(-50%, -55%);
}

.submitted-highlight {
  background-color: #fae89a38;
}

.incomplete-highlight {
  background-color: rgba(235, 145, 145, 0.13);
}

#points {
  font-weight: 600;
  color: #040f31c4;
}

.total-course-score {
  text-align: right;
  margin-right: 10%;
  text-transform: uppercase;
  color: #032647b4;
  padding-bottom: 10px;
  display: inline-flex;
  justify-content: flex-end;
  align-items: center;
}
#course-score-number {
  color: #0b60ce;
  margin-left: 10px;
  font-size: 2rem;
}
</style>