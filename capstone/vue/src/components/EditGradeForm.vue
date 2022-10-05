<template>
  <div>
    <form class="edit-grade-form" v-on:submit.prevent="saveGrade">
      <h1>Edit Grade Form</h1>
      <h3>
        {{ currentGradeObject.firstName }} {{ currentGradeObject.lastName }}
      </h3>
      <h3>{{ currentGradeObject.assignmentTitle }}</h3>
      <p>{{ currentGradeObject.submissionContent }}</p>
      <label for="earnedPoints">Earned Points: </label>
      <input id="earnedPoints" type="number" v-model="earnedPoints" />
      <p>Total Points: {{ currentGradeObject.totalPoints }}</p>
      <label for="feedback">Feedback: </label>
      <textarea id="feedback" v-model="feedback" />
      <input type="submit" value="Save" />
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
  },
  methods: {
    saveGrade() {
      (this.updatedGradeObject.earnedPoints = this.earnedPoints),
        (this.updatedGradeObject.feedback = this.feedback);
        (this.updatedGradeObject.status = "Graded")
      gradesService.updateGrade(this.updatedGradeObject).then((response) => {
        if (response.status == 200) {
          this.$emit("save-edit-grade", false);
        }
      });
    },
  },
};
</script>

<style>
.edit-grade-form {
  background-color: #e4e4e4f5;
  box-shadow: 0 0 0 5px rgba(107, 107, 107, 0.185);
  border-radius: 10px;
  padding: 30px;
  font-family: sans-serif;
}

.edit-grade-form > label {
  display: block;
}

.edit-grade-form > input[type="submit"] {
  display: block;
}

#feedback {
    width: 100%;
}
</style>