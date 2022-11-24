<template>
  <div class="teacher-grade-list">
    <edit-grade-form
      id="edit-grade-form"
      v-if="displayEditGradeForm"
      v-on:save-edit-grade="toggleEditGradeForm"
      v-bind:currentGradeObject="currentGradeObject"
    />
    <div
      class="assignment-div"
      v-for="assignment in filteredAssignments()"
      v-bind:key="assignment.assignmentId"
    >
      <router-link
        :to="{
          name: 'instruction-content',
          params: {
            instructionId: assignment.dailyInstructionsId,
          },
        }"
      >
        <span id="assignment-grade-header">
          <h2 id="assignment-grade-title">{{ assignment.assignmentTitle }}</h2>
          <h2 id="due-date">Due: {{ assignment.dueDate }}</h2>
        </span>
      </router-link>
      <table class="grades-table">
        <thead>
          <tr>
            <td class="grade-name">Student Name</td>
            <td class="grade-points">Grade</td>
            <td class="grade-status">Status</td>
            <td class="grade-feedback">Feedback</td>
            <td class="view-column">Submission</td>
          </tr>
        </thead>
        <tbody>
          <tr
            v-for="grade in filteredGrades(assignment.assignmentId)"
            v-bind:key="grade.assignmentId"
            v-bind:class="{
              'submitted-highlight': grade.status == 'Submitted',
              'incomplete-highlight': grade.status == 'Incomplete',
            }"
            class="student-grade-row"
          >
            <td class="grade-name" id="student-name">
              {{ grade.lastName }}, {{ grade.firstName }}
            </td>
            <td class="grade-points">
              <button
                id="grade-score-btn"
                v-on:click="toggleEditGradeForm(), setCurrentGradeObject(grade)"
              >
                {{ grade.earnedPoints }} / {{ grade.totalPoints }}
              </button>
            </td>
            <td class="grade-status">{{ grade.status }}</td>
            <td class="grade-feedback" id="teacher-feedback">
              {{ grade.feedback }}
            </td>
            <td class="view-column">
              <button
                id="view-grade-btn"
                v-if="grade.status != 'Incomplete'"
                v-on:click="toggleEditGradeForm(), setCurrentGradeObject(grade)"
              >
                View
              </button>
            </td>
          </tr>
        </tbody>
      </table>
    </div>
  </div>
</template>

<script>
import AssignmentService from "../services/AssignmentService";
import gradesService from "../services/GradesService";
import EditGradeForm from "../components/EditGradeForm.vue";

export default {
  name: "teacher-grade-list",
  data() {
    return {
      grades: [],
      assignments: [],
      currentGradeObject: {},
      displayEditGradeForm: false,
    };
  },
  components: {
    EditGradeForm,
  },
  created() {
    AssignmentService.getAllAssignmentsInCourse(
      this.$route.params.courseId
    ).then((response) => {
      if (response.status == 200) {
        this.assignments = response.data;
      }
    });
    gradesService.getAllJoinedGrades().then((resp) => {
      if (resp.status == 200) {
        this.grades = resp.data.filter(
          (grade) => grade.courseId == this.$route.params.courseId
        );
      }
    });
  },
  methods: {
    filteredGrades(assignmentId) {
      let tempArray = this.grades;
      return tempArray
        .filter((grade) => grade.assignmentId == assignmentId)
        .sort((a, b) => (a.lastName > b.lastName ? 1 : -1));
    },
    filteredAssignments() {
      let tempAssigns = this.assignments;
      return tempAssigns
        .filter(
          (assignment) =>
            this.filteredGrades(assignment.assignmentId).length > 0
        )
        .sort((a, b) => (a.assignmentId > b.assignmentId ? 1 : -1));
    },
    toggleEditGradeForm() {
      if (this.displayEditGradeForm == false) {
        this.displayEditGradeForm = true;
      } else {
        this.displayEditGradeForm = false;
      }
    },
    setCurrentGradeObject(grade) {
      this.currentGradeObject = grade;
    },
  },
};
</script>

<style>
.teacher-grade-list {
  display: flex;
  flex-direction: column;
}

.assignment-div > a {
  text-decoration: none;
  color: #0564bd;
}
.assignment-div > a:hover {
  text-decoration: none;
  color: #9521b8de;
}

#assignment-grade-header {
  display: flex;
  flex-direction: row;
  justify-content: space-between;
  align-items: flex-end;
  margin-left: 4%;
  margin-right: 4%;
  margin-bottom: 5px;
}

#assignment-grade-title {
  font-size: 1.3rem;
}

#due-date {
  font-size: 1.1rem;
  color: #040f31c0;
}

.grades-table thead {
  font-weight: bold;
  font-size: 1rem;
  background-color: #ddddddb0;
  color: #040f31de;
  border-bottom: 2px solid rgba(58, 58, 58, 0.425);
  border-top: 1px solid rgba(58, 58, 58, 0.164);
  box-shadow: 0 0 0 2px rgba(131, 130, 130, 0.089);
}

.grades-table {
  width: 90%;
  border: 1px solid rgba(58, 58, 58, 0.164);
  box-shadow: 0 0 0 2px rgba(131, 130, 130, 0.089);
  border-radius: 10px;
  border-collapse: collapse;
  margin-left: 5%;
  margin-bottom: 40px;
}

.student-grade-row {
  background-color: #f6f4f7;
  border-top: 1px solid gray;
}

.submitted-highlight {
  background-color: #fae89a38;
}

.incomplete-highlight {
  background-color: rgba(235, 145, 145, 0.13);
}

.grades-table td {
  border: 1px solid rgba(105, 105, 105, 0.11);
  padding-left: 5px;
  padding-bottom: 5px;
  padding-top: 5px;
  padding-right: 5px;
}

.grade-name {
  width: 20%;
}

#student-name {
  font-weight: 500;
  color: rgba(42, 42, 43, 0.705);
}

.grade-points {
  width: 10%;
}

.grade-status {
  width: 12%;
}

.grade-feedback {
  width: 50%;
}
#teacher-feedback {
  font-style: italic;
  color: rgb(83, 83, 83);
}

.view-column {
  width: fit-content;
  text-align: center;
}

#grade-score-btn {
  width: 90%;
}

#view-grade-btn {
  width: fit-content;
  border: none;
  box-shadow: 0 1px 1px 1px rgba(39, 39, 39, 0.171);
  border-radius: 4px;
  font-weight: bold;
  font-size: 0.8em;
  text-transform: uppercase;
  padding: 5px;
  padding-inline: 8%;
  background-color: #f33e26a9;
  color: #f1f1f1;
}

#view-grade-btn:hover {
  background-color: #f9dc59;
  color: #001a33d0;
  box-shadow: 0 8px 24px 0 rgb(16 39 112 / 20%);
  transform: translateX(1%);
  transform: translate3d(2%, 2%, 2%);
}

#edit-grade-form {
  position: fixed;
  left: 50%;
  right: 0%;
  transform: translate(-50%, -45%);
}
</style>
