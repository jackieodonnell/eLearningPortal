<template>
  <div class="new-lesson">
    <form
      class="create-new-lesson"
      v-on:submit="createNewDailyInstruction"
    >
      <div class="form-header">
        <h1 class="create-lesson-header">Create New Lesson</h1>
      </div>
      <div class="form-element">
        <label for="lesson-title">Lesson Title: </label>
        <textarea
          id="lesson-title"
          type="textarea"
          v-model="newDailyInstruction.instructions"
          required
        />
      </div>
      <div class="form-element">
        <label for="lesson-content">Lesson Content:</label>
        <textarea
          type="textarea"
          id="lesson-content"
          v-model="newDailyInstruction.content"
          required
        />
      </div>
      <div class="form-element">
        <label for="lesson-date">Lesson Date:</label>
        <input
          type="date"
          class="lesson-date"
          v-model="newDailyInstruction.currentDay"
          required
        />
      </div>
      <input type="submit" value="Save" />
      <input type="button" value="Cancel" v-on:click.prevent="displayNewLesson" />
    </form>
  </div>
</template>

<script>
import InstructionService from "../services/InstructionService";

export default {
  name: "new-lesson-form",
  data() {
    return {
      newDailyInstruction: {
        currentDay: Date,
        curriculumId: this.curriculumId,
        instructions: "",
        content: "",
      },
    };
  },
  created() {
      this.newDailyInstruction.curriculumId = this.curriculumId;
  },

  props: [ 'curriculumId' ],
  methods: {
    createNewDailyInstruction() {
      InstructionService.createInstruction(this.newDailyInstruction).then(
        (response) => {
          if (response.status == 201) {
            this.displayNewLesson();
            // this.resetForm();
          } else {
            console.log("Error - failed to create new course");
          }
        }
      );
    },
    displayNewLesson() {
        this.$emit("displayNewLesson", false)
    },
    resetForm() {
      this.newDailyInstruction = {
        currentDay: Date,
        curriculumId: 0,
        instructions: "",
        content: "",
      };
      this.$router.back();
    },
  },
};
</script>

<style>
.new-lesson {
    position: fixed;
  width: 70%;
  height: 100%;
}

.create-new-lesson {
  background-color: #e4e4e4f5;
  box-shadow: 0 0 0 5px rgba(107, 107, 107, 0.185);
  border-radius: 10px;
  padding: 30px;
  font-family: sans-serif;
}

.form-header {
  text-align: center;
}

div.form-element {
  margin-top: 10px;
  margin-bottom: 10px;
}
div.form-element > label {
  display: block;
}
/* div.form-element > input {
  height: 50px;
  width: 80%;
  border-radius: 4px;
} */

div.form-element > textarea {
  padding: 10px 10px;
  box-sizing: border-box;
  border: 2px solid #ccc;
  border-radius: 4px;
  background-color: #f8f8f8;
  resize: vertical;
  overflow: auto;
}

form > input[type="button"],
form > input[type="submit"] {
  width: 10%;
  height: 10%;
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

form > input[type="submit"]:hover {
  background-color: #04aa6d;
}
form > input[type="button"]:hover {
  background-color: #eb453f;
}
</style>