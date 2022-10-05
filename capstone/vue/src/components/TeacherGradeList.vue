<template>
  <div class="teacher-grade-list">
    <edit-grade-form v-if="displayEditGradeForm" v-on:save-edit-grade="toggleEditGradeForm" v-bind:currentGradeObject="currentGradeObject"/>
    <div
      class="assignment-div"
      v-for="assignment in filteredAssignments()"
      v-bind:key="assignment.assignmentId"
    >
      <h2 id="assignment-title">{{ assignment.assignmentTitle }}</h2>
      <table class="grades-table">
        <thead>
          <tr>
            <td class="grade-name">Student Name</td>
            <td class="grade-points">Grade</td>
            <td class="grade-status">Status</td>
            <td class="grade-sub-content">Submission Content</td>
            <td class="grade-feedback">Feedback</td>
          </tr>
        </thead>
        <tbody>
          <tr v-for="grade in filteredGrades(assignment.assignmentId)" v-bind:key="grade.assignmentId" >
            <td class="grade-name"> {{grade.lastName}}, {{ grade.firstName }} </td>
            <td class="grade-points"> <button v-on:click="toggleEditGradeForm(), setCurrentGradeObject(grade)"> {{grade.earnedPoints}} / {{grade.totalPoints}} </button></td>
            <td class="grade-status">{{grade.status}}</td>
            <td class="grade-sub-content">{{grade.submissionContent}}</td>
            <td class="grade-feedback">{{grade.feedback}}</td>
          </tr>
        </tbody>
      </table>
    </div>
  </div>
</template>

<script>
import AssignmentService from "../services/AssignmentService";
import gradesService from "../services/GradesService";
import EditGradeForm from '../components/EditGradeForm.vue'

export default {
  name: "teacher-grade-list",
  data() {
    return {
      grades: [],
      assignments: [],
      currentGradeObject: {},
      displayEditGradeForm: false
    };
  },
  components: {
    EditGradeForm
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
        this.grades = resp.data.filter(grade => grade.courseId == this.$route.params.courseId)
      }
    });
  },
  methods: {
    filteredGrades(assignmentId) {
      let tempArray = this.grades;
      return tempArray.filter(grade => grade.assignmentId == assignmentId).sort((a, b) => (a.lastName > b.lastName ? 1 : -1));
    },
    filteredAssignments() {
      let tempAssigns = this.assignments;
      return tempAssigns.filter(assignment => 
        this.filteredGrades(assignment.assignmentId).length > 0
      )
    },
    toggleEditGradeForm() {
      if (this.displayEditGradeForm == false) {
        this.displayEditGradeForm = true
      } else {
        this.displayEditGradeForm = false
      }
    },
    setCurrentGradeObject(grade) {
      this.currentGradeObject = grade
    }
  },
  
};
</script>

<style>
.grades-table thead {
  font-weight: bold;
}

.teacher-grade-list {
  margin: 30px;
}

.grades-table {
  width: 100%;
  border-collapse: collapse;
  margin-bottom: 10px;
}

.grades-table td {
  border: 1px solid black;
  /* overflow: auto; */
}

.grade-name {
  width: 30%;
}

.grade-sub-content {
  width: 40%;
}

.grade-feedback {
  width: 30%;
}

.grade-points {
  width: 6%;
}


</style>
