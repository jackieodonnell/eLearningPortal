<template>
  <div class="new-lesson">
    <form class="create-new-lesson" v-on:submit="createNewDailyInstruction">
      <div id="form-header">
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
          rows="10"
          v-model="newDailyInstruction.content"
          required
        />
      </div>
      <div class="form-element">
        <label for="lesson-date">Lesson Date:</label>
        <input
          type="date"
          class="lesson-date"
          id="lesson-date-input"
          v-model="newDailyInstruction.currentDay"
          required
        />
      </div>
      <input type="submit" value="Save" />
      <input
        type="button"
        value="Cancel"
        v-on:click.prevent="displayNewLesson"
      />
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

  props: ["curriculumId"],
  methods: {
    createNewDailyInstruction() {
      InstructionService.createInstruction(this.newDailyInstruction).then(
        (response) => {
          if (response.status == 201) {
            this.displayNewLesson();
          } else {
            console.log("Error - failed to create new course");
          }
        }
      );
    },
    displayNewLesson() {
      this.$emit("displayNewLesson", false);
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
  min-height: 70vh;
  min-width: 50vw;
  background-color: #e4e4e4fd;
  box-shadow: 0 0 6px 4px rgba(44, 43, 43, 0.233);
  border-radius: 10px;
  padding-left: 40px;
  padding-right: 40px;
  padding-top: 20px;
  padding-bottom: 30px;
  font-family: sans-serif;
}
.create-lesson-header {
  text-transform: uppercase;
  text-align: center;
  color: #032647b4;
  font-size: 1.8rem;
  padding-bottom: 10px;
}
.create-new-lesson {
  padding: 5%;
}

div.form-element {
  margin-top: 10px;
  margin-bottom: 10px;
}
div.form-element > label {
  display: block;
  font-weight: bold;
  font-size: 1rem;
  line-height: 1.5rem;
  color: #040f31a9;
  text-transform: uppercase;
}

div.form-element > textarea {
  width: 100%;
  padding: 10px 10px;
  font-family: "Segoe UI", Tahoma, Geneva, Verdana, sans-serif;
  box-sizing: border-box;
  border-radius: 4px;
  box-shadow: 0 8px 24px 0 rgb(16 39 112 / 10%);
  background-color: #f8f8f8;
  resize: vertical;
  overflow: auto;
}

#lesson-date-input {
  font-family: "Segoe UI", Tahoma, Geneva, Verdana, sans-serif;
  box-shadow: 0 1px 1px 1px rgba(39, 39, 39, 0.171);
  width: 30%;
}

form > input[type="button"],
form > input[type="submit"] {
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
form > input[type="button"] {
  background-color: #d66c6c;
  color: #040f31de;
}

form > input[type="submit"]:hover,
form > input[type="button"]:hover {
  box-shadow: 0 8px 24px 0 rgb(16 39 112 / 40%);
  transform: translateX(1%);
  transform: translate3d(2%, 2%, 2%);
  background-color: #a71d1d;
  color: #fff8e2;
}

form > input[type="submit"]:hover {
  background-color: #18a04c;
  color: #fff8e2;
  box-shadow: 0 8px 24px 0 rgb(16 39 112 / 40%);
}
</style>