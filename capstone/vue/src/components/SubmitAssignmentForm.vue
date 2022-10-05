<template>
  <div class="submit-assignment-container">
<<<<<<< HEAD
      <form action="submit-assignment" id="submit-assignment-form" v-on:submit.prevent="submitAssignment">
          <textarea v-model="grade.submissionContent" name="submit-assignment-textarea" id="submit-assignment-textarea" cols="100" rows="25"></textarea>
          <br>
          <button id="submit-assignment-button">
              Submit
          </button>
          <button id="cancel-submission-button">
              Cancel
          </button>
      </form>
=======
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
        rows="25"
      ></textarea>
      <br />
      <button id="submit-assignment-button">Submit</button>
      <button
        id="cancel-submission-button"
        v-on:click.prevent="cancelSubmision"
      >
        Cancel
      </button>
    </form>
>>>>>>> main
  </div>
</template>

<script>
<<<<<<< HEAD
import gradesService from "../services/GradesService"

export default {
    name: "submit-assignment-form",
    // props: ['displaySubmitForm'],
    data() {
        return {
            grade: {
                submissionContent: '',
                status: "Submitted"
            }
            
    }
    },
    methods: {
        submitAssignment() {
            // need to update grade status
            gradesService.updateGrade(this.grade)
            this.$emit('displaySubmitForm', false)


        }
    }

}
=======
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
      // need to update grade status
      this.$emit("displaySubmitForm", false);
      alert("Assignment Successfully Submitted!");
    },

    cancelSubmission() {
      this.$emit("displaySubmitForm", false);
    },
  },
};
>>>>>>> main
</script>

<style>
#submit-assignment-container button {
  text-align: right;
}

#submit-assignment-button,
#cancel-submission-button {
  border: none;
  margin-right: 1%;
  box-shadow: 0 0 0 1px rgba(107, 107, 107, 0.185);
  border-radius: 4px;
  font-weight: bold;
  font-size: 0.8em;
  text-transform: uppercase;
  padding: 10px;
  padding-inline: 3%;
  background-color: #6ddf99;
  color: #040f31de;
  box-shadow: 0 8px 24px 0 rgb(255 235 167 / 20%);
  transition: all 0.3s ease-in-out;
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