<template>
  <div>
    <div id="instruction-heading">
      <h3>{{ dailyInstruction.currentDay }}</h3>
      <h2>{{ dailyInstruction.instructions }}</h2>
    </div>
    <div id="instruction-content">
      <p>{{ dailyInstruction.content }}</p>
    </div>
    <div
      id="assignment-content"
      v-for="assignment in assignments"
      v-bind:key="assignment.assignmentId"
    >
      <h2 id="assignment-type">
        &#128211;{{ assignment.assignmentType }} Due On:
        {{ assignment.dueDate }}
      </h2>
      <h3>{{ assignment.assignmentTitle }}</h3>
      <p>{{ assignment.assignmentDescription }}</p>
      <div
        id="submit-assignment-btn-container"
        v-bind="teacher"
        v-if="!teacher"
      >
        <button
          id="submit-assignment-btn"
          v-on:click="showSubmitForm"
          v-if="displaySubmitForm == false"
        >
          Submit Assignment
        </button>
      </div>
      <submit-assignment-form
        v-if="displaySubmitForm"
        v-on:displaySubmitForm="showSubmitForm"
      />
    </div>
    <div id="add-assignment-btn-container" v-bind="teacher" v-if="teacher">
      <button id="add-assignment-btn" v-on:click="showNewAssignmentForm">
        Add Assignment
      </button>
      <new-assignment-form
        v-if="displayNewAssignmentForm"
        v-bind:dailyInstructionsId="dailyInstruction.dailyInstructionsId"
      />
    </div>
  </div>
</template>

<script>
import AssignmentService from "../services/AssignmentService";
import InstructionService from "../services/InstructionService";
import NewAssignmentForm from "./NewAssignmentForm.vue";
import SubmitAssignmentForm from "./SubmitAssignmentForm.vue";

export default {
  name: "instruction-content",
  props: {
    dailyInstructionsId: Number,
  },
  data() {
    return {
      dailyInstruction: {
        dailyInstructionsId: "",
        currentDay: "",
        curriculumId: "",
        instructions: "",
        content: "",
      },
      assignments: [],
      displaySubmitForm: false,
      displayNewAssignmentForm: false,
      teacher: this.$store.state.user.authorities.some(
        (e) => e["name"] === "ROLE_TEACHER"
      ),
    };
  },
  watch: {
    "$route.params.instructionId": function (instructionId) {
      InstructionService.getInstructionById(
        this.$route.params.instructionId
      ).then((response) => {
        if (response.status == 200) {
          this.dailyInstruction = response.data;
        }
      });
      AssignmentService.getAllAssignmentsInDailyInstruction(instructionId).then(
        (resp) => {
          if (resp.status == 200) {
            this.assignments = resp.data;
          }
        }
      );
    },
  },
  created() {
    InstructionService.getInstructionById(
      this.$route.params.instructionId
    ).then((response) => {
      if (response.status == 200) {
        this.dailyInstruction = response.data;
        AssignmentService.getAllAssignmentsInDailyInstruction(
          this.dailyInstruction.dailyInstructionsId
        ).then((resp) => {
          if (resp.status == 200) {
            this.assignments = resp.data;
          }
        });
      }
    });
  },
  components: {
    SubmitAssignmentForm,
    NewAssignmentForm,
  },
  methods: {
    showSubmitForm() {
      if (this.displaySubmitForm == false) {
        this.displaySubmitForm = true;
      } else {
        this.displaySubmitForm = false;
      }
    },
    showNewAssignmentForm() {
      if (this.displayNewAssignmentForm == false) {
        this.displayNewAssignmentForm = true;
      } else {
        this.displayNewAssignmentForm = false;
      }
    },
  },
};
</script>

<style>
#instruction-heading {
  text-align: center;
}

#assignment-content {
  border-top: 1px solid gray;
}

#assignment-content h2 {
  text-transform: capitalize;
}

#add-assignment-btn-container,
#submit-assignment-btn-container {
  border-top: 1px solid gray;
  padding-top: 10px;
  text-align: left;
  margin-top: 10px;
  margin-bottom: 10px;
}
#submit-assignment-btn-container {
  border: none;
  margin-top: 0px;
  margin-bottom: 0px;
}
#add-assignment-btn-container button,
#submit-assignment-btn-container button {
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
}
#submit-assignment-btn-container button {
  background-color: #6ddf99;
  color: #040f31de;
}

#add-assignment-btn-container button:hover {
  background-color: #5e6681;
  color: #ffeba7;
  box-shadow: 0 8px 24px 0 rgb(16 39 112 / 20%);
}

#submit-assignment-btn-container button:hover {
  background-color: #18a04c;
  color: #fff8e2;
  box-shadow: 0 8px 24px 0 rgb(16 39 112 / 20%);
}
</style>