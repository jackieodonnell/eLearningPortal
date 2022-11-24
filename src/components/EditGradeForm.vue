<template>
  <div>
    <form class="edit-grade-form" v-on:submit.prevent="saveGrade">
      <h2 id="edit-grade-form-header">REVIEW STUDENT SUBMISSION</h2>
      <table id="student-assignment-info">
        <thead id="grade-header-row">
          <tr>
            <td id="grade-student-name-head">STUDENT NAME</td>
            <td class="assignment-title">ASSIGNMENT</td>
            <td class="assignment-status">STATUS</td>
          </tr>
        </thead>
        <tbody>
          <tr id="grade-body-row">
            <td class="grade-name">
              {{ currentGradeObject.firstName }}
              {{ currentGradeObject.lastName }}
            </td>
            <td class="assignment-title">
              {{ currentGradeObject.assignmentTitle }}
            </td>
            <td class="assignment-status">{{ currentGradeObject.status }}</td>
          </tr>
        </tbody>
      </table>
      <div class="submission-section">
        <label for="submission-content" id="submission-content-label"
          >STUDENT SUBMISSION:</label
        >
        <p id="submission-content">
          {{ currentGradeObject.submissionContent }}
        </p>
      </div>
      <table id="student-score-table">
        <thead>
          <tr id="score-header-row">
            <td id="score-label">SCORE</td>
            <td id="total-label">TOTAL</td>
          </tr>
          <tr id="score-body-row">
            <td>
              <input
                id="earned-points-input"
                type="number"
                v-model="earnedPoints"
              />
            </td>
            <td id="total-points-value">
              {{ currentGradeObject.totalPoints }}
            </td>
          </tr>
        </thead>
      </table>
      <div class="feedback-section">
        <label for="feedback" id="feedback-label">FEEDBACK:</label>
        <textarea id="feedback" v-model="feedback" />
      </div>
      <input type="submit" value="Save" id="edit-grade-submit-btn" />
      <button id="edit-grade-cancel-btn" v-on:click.prevent="cancelGrade">
        Cancel
      </button>
    </form>
  </div>
</template>

<script>
import gradesService from "../services/GradesService";
export default {
  name: "edit-grade-form",
  props: ["currentGradeObject"],
  data() {
    return {
      updatedGradeObject: {},
      earnedPoints: "",
      feedback: "",
    };
  },
  created() {
    this.updatedGradeObject = this.currentGradeObject;
    this.feedback = this.currentGradeObject.feedback;
    this.earnedPoints = this.currentGradeObject.earnedPoints;
  },
  methods: {
    saveGrade() {
      (this.updatedGradeObject.earnedPoints = this.earnedPoints),
        (this.updatedGradeObject.feedback = this.feedback);
      this.updatedGradeObject.status = "Graded";
      gradesService.updateGrade(this.updatedGradeObject).then((response) => {
        if (response.status == 200) {
          this.$emit("save-edit-grade", false);
          alert("The assignment grade have been saved successfully!");
        }
      });
    },
    cancelGrade() {
      this.$emit("save-edit-grade");
    },
  },
};
</script>

<style>
.edit-grade-form {
  background-color: #e4e4e4fd;
  box-shadow: 0 0 6px 4px rgba(44, 43, 43, 0.233);
  border-radius: 10px;
  padding-left: 40px;
  padding-right: 40px;
  padding-top: 20px;
  padding-bottom: 30px;
  font-family: sans-serif;
}
#edit-grade-form-header {
  text-align: center;
  color: #032647b4;
  padding-bottom: 10px;
}

#student-assignment-info {
  width: 100%;
  margin-bottom: 30px;
  box-shadow: 0 0 4px 3px rgba(97, 97, 97, 0.151);
  border: none;
  border-radius: 5px;
}

#grade-header-row {
  font-weight: bold;
  font-size: 1rem;
  background-color: #ddddddb0;
  line-height: 1.5rem;
  color: #040f31de;
  border-bottom: 2px solid rgba(58, 58, 58, 0.425);
  border-top: 1px solid rgba(58, 58, 58, 0.164);
  box-shadow: 0 0 0 2px rgba(131, 130, 130, 0.089);
}
#grade-body-row {
  background-color: #f3f3f3b4;
  line-height: 1.5rem;
}

#submission-content {
  font-family: "Segoe UI", Tahoma, Geneva, Verdana, sans-serif;
  background: white;
  width: 95%;
  padding-top: 15px;
  padding-bottom: 20px;
  padding-left: 15px;
  padding-right: 15px;
  margin-top: 0px;
  min-height: 20vh;
  max-height: 20vh;
  box-shadow: 0 0 2px 1px rgba(71, 71, 71, 0.205);
  border: none;
  border-radius: 5px;
}
#submission-content-label,
#feedback-label {
  font-weight: bold;
  font-size: 1rem;
  line-height: 1.5rem;
  color: #040f31de;
}

#grade-student-name-head {
  width: 30%;
}

#student-score-table {
  width: fit-content;
  display: flex;
  flex-direction: column;
  align-items: flex-end;
  border-collapse: collapse;
  text-align: center;
  margin-left: 5%;
  margin-bottom: 10px;
  box-shadow: 0 0 4px 4px rgba(97, 97, 97, 0.151);
  border: none;
  border-radius: 10px;
}

#score-header-row {
  font-weight: bold;
  font-size: 1rem;
  background-color: #abdb9fb0;
  line-height: 1.5rem;
  color: #040f31de;
  border-bottom: 2px solid rgba(58, 58, 58, 0.425);
  border-top: 1px solid rgba(58, 58, 58, 0.164);
  box-shadow: 0 0 0 2px rgba(131, 130, 130, 0.089);
}

#score-label {
  padding: 10px;
}
#total-label {
  background-color: #fcb069d8;
  padding: 10px;
}

#earned-points-input {
  align-items: center;
  width: 50px;
  padding: 5px;
}

#total-points-value {
  text-align: center;
  font-weight: bold;
  font-size: 1rem;
  line-height: 1.5rem;
  color: #040f31de;
  border-top: 2px solid rgba(58, 58, 58, 0.164);
  border-left: 2px solid rgba(58, 58, 58, 0.164);
}

.edit-grade-form > label {
  display: block;
}

.edit-grade-form > input[type="submit"] {
  display: block;
}

#feedback {
  width: 95%;
  min-height: 10vh;
  background-color: #fff8d9fd;
  padding: 20px;
  font-family: "Segoe UI", Tahoma, Geneva, Verdana, sans-serif;
  font-size: 1rem;
  box-shadow: 0 0 4px 3px rgba(97, 97, 97, 0.151);
  border: 1px solid rgba(173, 26, 26, 0.637);
  border-radius: 5px;
}

#edit-grade-submit-btn,
#edit-grade-cancel-btn {
  display: inline;
  width: 15%;
  text-align: center;
  border: none;
  box-shadow: 0 1px 1px 1px rgba(39, 39, 39, 0.171);
  border-radius: 4px;
  font-weight: bold;
  font-size: 0.8em;
  text-transform: uppercase;
  padding: 5px;
  background-color: #6ddf99;
  color: #040f31de;
}

#edit-grade-cancel-btn {
  background-color: #d66c6c;
  color: #040f31de;
}

#edit-grade-submit-btn:hover,
#edit-grade-cancel-btn:hover {
  box-shadow: 0 8px 24px 0 rgb(16 39 112 / 40%);
  transform: translateX(1%);
  transform: translate3d(2%, 2%, 2%);
  background-color: #a71d1d;
  color: #fff8e2;
}
#edit-grade-submit-btn:hover {
  background-color: #18a04c;
  color: #fff8e2;
  box-shadow: 0 8px 24px 0 rgb(16 39 112 / 40%);
}
</style>