<template>
  <div class="new-assignment">
    <form class="create-new-assignment" v-on:submit="createNewAssignment">
      <div class="form-header">
        <h1 class="create-assignment-header">Create New Assignment</h1>
      </div>
      <div class="form-element">
        <label for="assignment-title">Assignment Title: </label>
        <textarea
          id="assignment-title"
          type="textarea"
          v-model="assignment.assignmentTitle"
          required
        />
      </div>
      <div class="form-element">
        <label for="assignment-description">Assignment Description:</label>
        <textarea
          type="textarea"
          id="assignment-description"
          v-model="assignment.assignmentDescription"
          required
        />
      </div>
      <div class="form-element">
        <label for="assigned-date">Assign On Date:</label>
        <input
          type="date"
          class="assigned-date"
          v-model="assignment.assignedDate"
          required
        />
      </div>
      <div class="form-element">
        <label for="due-date">Due Date:</label>
        <input
          type="date"
          class="due-date"
          v-model="assignment.dueDate"
          required
        />
      </div>
      <input type="submit" value="Save" />
      <input
        type="button"
        value="Cancel"
        v-on:click.prevent="displayNewAssignment"
      />
    </form>
  </div>
</template>

<script>
import assignmentService from "../services/AssignmentService";
export default {
  name: "new-assignment-form",
  props: ["dailyInstructionsId"],
  data() {
    return {
      assignment: {
        dailyInstructionsId: "",
        assignedDate: "",
        dueDate: "",
        assignmentTitle: "",
        assignmentDescription: "",
        assignmentType: "",
      },
    };
  },
  created() {
    this.assignment.dailyInstructionsId = this.dailyInstructionsId;
  },
  methods: {
    createNewAssignment() {
      assignmentService.createAssignment(this.assignment).then((response) => {
        if (response.status == 201) {
          this.displayNewAssignment();
        } else {
          console.log("Error - failed to create new assignment");
        }
      });
    },
    displayNewAssignment() {
      this.$emit("displayNewAssignmentForm", false);
    },
  },
};
</script>

<style>
</style>