<template>
  <div class="new-course">
    <form class="create-new-course" v-on:submit.prevent="createNewCourse">
      <div id="new-course-form-header">
        <h1 class="create-course-header">Create New Course</h1>
      </div>
      <div class="form-element">
        <label for="course-title">Course Title:</label>
        <input
          id="course-title-input"
          type="text"
          v-model="newCourse.courseTitle"
          required
        />
      </div>
      <div class="form-element">
        <label for="course-description">Course Description:</label>
        <textarea
          id="course-description-input"
          v-model="newCourse.courseDescription"
          rows="5"
          required
        />
      </div>
      <div class="form-element">
        <label for="difficulty">Grade Level:</label>
        <select
          id="difficulty-input"
          form="create-new-course"
          v-model="newCourse.difficulty"
          required
        >
          <option value="K">K</option>
          <option value="1">1</option>
          <option value="2">2</option>
          <option value="3">3</option>
          <option value="4">4</option>
          <option value="5">5</option>
          <option value="6">6</option>
          <option value="7">7</option>
          <option value="8">8</option>
        </select>
      </div>
      <div class="form-element">
        <label for="cost">Tuition Cost:</label>
        <select
          id="cost-input"
          form="create-new-course"
          v-model="newCourse.cost"
          required
        >
          <option value="0.00">FREE</option>
        </select>
      </div>
      <input type="submit" value="Save" />
      <input type="button" value="Cancel" v-on:click.prevent="cancelForm" />
    </form>
  </div>
</template>

<script>
import curriculumService from "../services/CurriculumService";
import courseService from "../services/CourseService";

export default {
  name: "create-course",
  data() {
    return {
      newCourse: {
        teacherId: this.$store.state.user.id,
        courseTitle: "",
        courseDescription: "",
        difficulty: "",
        cost: "",
        isArchived: false,
      },
    };
  },
  methods: {
    createNewCourse() {
      courseService.createCourse(this.newCourse).then((response) => {
        if (response.status == 201) {
          const courseId = response.data;
          const newCurriculum = {
            curriculumId: "",
            courseId: courseId,
            curriculumTitle: "",
            curriculumDescription: "",
          };
          curriculumService.createCurriculum(newCurriculum).then((resp) => {
            if (resp.status == 201) {
              this.resetForm();
            }
          });
        } else {
          console.log("Error - failed to create new course");
        }
      });
    },
    resetForm() {
      this.newCourse = {
        teacherId: this.$store.state.user.id,
        courseTitle: "",
        courseDescription: "",
        difficultyLevel: "",
        cost: "",
        isArchived: false,
      };
      this.$emit("toggle-form");
      this.$router.go();
    },
    cancelForm() {
      this.$emit("toggle-form");
    },
  },
};
</script>

<style>
.new-course {
  width: 100%;
}

.create-new-course {
  width: 95%;
  min-height: 10vh;
  background-color: #e4e4e4fd;
  padding: 20px;
  margin-top: 20px;
  font-family: "Segoe UI", Tahoma, Geneva, Verdana, sans-serif;
  font-size: 1rem;
  box-shadow: 0 0 4px 3px rgba(97, 97, 97, 0.308);
  border: 1px solid rgba(83, 83, 83, 0.637);
  border-radius: 5px;
}

#new-course-form-header {
  justify-content: center;
  font-weight: bold;
  font-size: 1rem;
  line-height: 1.5rem;
  color: #040f31de;
  text-transform: uppercase;
}

div.form-element {
  flex-direction: column;
}
div.form-element > label {
  display: block;
}
div.form-element > input,
div.form-element > select {
  border-radius: 4px;
}
div.form-element > textarea {
  width: 100%;
  box-sizing: border-box;
  border: 2px solid #ccc;
  background-color: #f8f8f8;
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
  text-decoration: none;
  margin: 4px 4px;
  cursor: pointer;
}

form > input[type="submit"]:hover {
  background-color: #04aa6d;
  box-shadow: 0 8px 12px 0 rgb(16 39 112 / 30%);
}
form > input[type="button"]:hover {
  background-color: #eb453f;
  box-shadow: 0 8px 12px 0 rgb(16 39 112 / 30%);
}

#course-title-input,
#course-description-input {
  width: 95%;
  padding: 10px;
  font-size: 1rem;
}
#course-description-input {
  width: 98%;
  padding: 15px;
  box-shadow: 0 8px 12px 0 rgb(16 39 112 / 20%);
}

#difficulty-input,
#cost-input {
  width: 30%;
  height: 30px;
  box-shadow: 0 8px 12px 0 rgb(16 39 112 / 20%);
}
</style>