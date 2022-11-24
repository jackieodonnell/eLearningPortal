<template>
  <div class="submit-assignment-container">
    <form
      action="submit-assignment"
      id="submit-assignment-form"
      v-on:submit.prevent="submitAssignment"
    >
      <textarea
        name="submit-assignment-textarea"
        v-model="inputText"
        id="submit-assignment-textarea"
        cols="100"
        rows="20"
      ></textarea>
      <br />
      <button id="submit-assignment-button">Submit</button>
      <button
        id="cancel-submission-button"
        v-on:click.prevent="cancelSubmission"
      >
        Cancel
      </button>
    </form>
  </div>
</template>

<script>
import GradesService from "../services/GradesService";
export default {
  name: "submit-assignment-form",
  props: ["selectedAssignment"],
  data() {
    return {
      grade: {},
      inputText: "",
    };
  },
  created() {
    GradesService.getGrade(
      this.selectedAssignment.assignmentId,
      this.$store.state.user.id
    ).then((response) => {
      this.grade = response.data;
    });
  },
  methods: {
    submitAssignment() {
      this.grade.submissionContent = this.inputText;
      this.grade.status = "Submitted";
      GradesService.updateGrade(this.grade);
      this.$emit("displaySubmitForm", false);
      alert("Assignment Successfully Submitted!");
    },

    cancelSubmission() {
      this.$emit("displaySubmitForm", false);
    },
  },
};
</script>

<style>
#submit-assignment-container button {
  text-align: right;
}

#submit-assignment-textarea {
  font-family: "Segoe UI", Tahoma, Geneva, Verdana, sans-serif;
  padding: 15px;
  width: 98%;
  box-shadow: 0 0 2px 1px rgba(71, 71, 71, 0.205);
}

#submit-assignment-button,
#cancel-submission-button {
  border: none;
  margin-right: 1%;
  border-radius: 4px;
  font-weight: bold;
  font-size: 0.8em;
  text-transform: uppercase;
  padding: 10px;
  padding-inline: 3%;
  background-color: #6ddf99;
  color: #040f31de;
  box-shadow: 0 1px 4px 1px rgba(39, 39, 39, 0.171);
  transition: all 0.3s ease-in-out;
  margin-bottom: 20px;
}
#cancel-submission-button {
  background-color: #d66c6c;
  color: #040f31de;
}
#submit-assignment-button:hover {
  background-color: #18a04c;
  color: #fff8e2;
  box-shadow: 0 8px 24px 0 rgb(16 39 112 / 20%);
}
#cancel-submission-button:hover {
  background-color: #a71d1d;
  color: #fff8e2;
  box-shadow: 0 8px 24px 0 rgb(16 39 112 / 20%);
}
</style>