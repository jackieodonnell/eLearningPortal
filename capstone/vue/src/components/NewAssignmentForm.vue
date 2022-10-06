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
          rows="1"
          v-model="assignment.assignmentTitle"
          required
        />
      </div>
      <div class="form-element">
        <label for="assignment-description">Assignment Description:</label>
        <textarea
          type="textarea"
          id="assignment-description"
          rows="8"
          v-model="assignment.assignmentDescription"
          required
        />
      </div>
      <div class="form-element">
        <label for="assigned-date">Assign On Date:</label>
        <input
          type="date"
          id="assigned-date-input"
          v-model="assignment.assignedDate"
          required
        />
      </div>
      <div class="form-element">
        <label for="due-date">Due Date:</label>
        <input
          type="date"
          id="due-date-input"
          v-model="assignment.dueDate"
          required
        />
      </div>
      <div class="form-element">
        <label for="total-points">Total Points:</label>
        <input
          type="number"
          id="total-points-input"
          v-model="totalPoints"
          placeholder="e.g. 20"
          required
        />
      </div>
      <input type="submit" value="Save" id="submit-new-assignment" />
      <button
        v-on:click.prevent="displayNewAssignment"
        id="cancel-new-assignment"
      >
        Cancel
      </button>
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
      newAssignmentId: "",
      totalPoints: "",
    };
  },
  created() {
    this.assignment.dailyInstructionsId = this.dailyInstructionsId;
  },
  methods: {
    createNewAssignment() {
      let newAssignmentWrapper = {
        assignment: this.assignment,
        totalPoints: this.totalPoints,
      };
      assignmentService
        .createAssignment(newAssignmentWrapper)
        .then((response) => {
          if (response.status == 201) {
            this.$emit("toggle-assignment-form", false);
          }
        });
    },
    displayNewAssignment() {
      this.$emit("toggle-assignment-form");
    },
  },
};
</script>

<style>
#cancel-new-assignment {
  width: fit-content;
  height: fit-content;
  font-size: 1rem;
  border-radius: 8px;
  background-color: rgb(73, 109, 226);
  border: none;
  color: white;
  padding: 1%;
  text-decoration: none;
  margin: 4px 4px;
  cursor: pointer;
}

.create-new-assignment {
  width: 95%;
  min-height: 10vh;
  background-color: #fff8d996;
  padding: 20px;
  margin-top: 20px;
  font-family: "Segoe UI", Tahoma, Geneva, Verdana, sans-serif;
  font-size: 1rem;
  box-shadow: 0 0 4px 3px rgba(97, 97, 97, 0.151);
  border: 1px solid rgba(83, 83, 83, 0.637);
  border-radius: 5px;
}

#submit-new-assignment {
  border: none;
  box-shadow: 0 0 0 1px rgba(107, 107, 107, 0.185);
  border-radius: 4px;
  font-weight: bold;
  font-size: 0.8em;
  text-transform: uppercase;
  padding: 10px;
  padding-inline: 3%;
  background-color: #f9dc59;
  color: #5e6681;
  box-shadow: 0 8px 24px 0 rgb(255 235 167 / 20%);
  transition: all 0.3s ease-in-out;
  margin-bottom: 10px;
}

.create-assignment-header {
  text-transform: uppercase;
  text-align: center;
  color: #032647b4;
  font-size: 1.8rem;
  padding-bottom: 10px;
}

#submit-new-assignment:hover {
  background-color: #18a04c;
  color: #fff8e2;
  box-shadow: 0 8px 24px 0 rgb(16 39 112 / 20%);
}

#assignment-description,
#assignment-title {
  box-shadow: 0 1px 3px 1px rgba(39, 39, 39, 0.171);
}

#assigned-date-input,
#due-date-input,
#total-points-input {
  border: none;
  font-family: "Segoe UI", Tahoma, Geneva, Verdana, sans-serif;
  box-shadow: 0 1px 3px 1px rgba(39, 39, 39, 0.171);
  width: 30%;
}
</style>