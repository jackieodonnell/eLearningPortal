<template>
  <div class="new-course">
      <form class="create-new-course" v-on:submit="createNewCourse">
          <div class="form-header">
              <h1 class="create-course-header">Create New Course</h1>
          </div>
          <div class="form-element">
              <label for="course-title">Course Title:</label>
              <input id="course-title" type="text" v-model="newCourse.courseTitle" />
          </div>
          <div class="form-element">
              <label for="course-description">Course Description:</label>
              <textarea id="course-description" v-model="newCourse.courseDescription"></textarea>
          </div>
          <div class="form-element">
              <label for="difficulty">Grade Level:</label>
              <select id="difficulty" v-model="newCourse.difficulty">
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
              <select id="cost" v-model="newCourse.cost">
                  <option value="0.00">FREE</option>
              </select>
          </div>
          <input type="submit" value="Save"/>
          <input type="button" value="Cancel" v-on:click.prevent="resetForm" />       
      </form>
  </div>
</template>

<script>
import courseService from '../services/CourseService';

export default {
    name: "create-course",
    data(){
        return {
            newCourse: {
                teacherId: this.$store.state.user.id,
                courseTitle: '',
                courseDescription: '',
                difficulty: '',
                cost: '',
            }
        }
    },
    methods: {
        createNewCourse() {
            courseService.createCourse(this.newCourse).then(response => {
                if (response.status == 201) {
                    this.resetForm();
                    this.$router.push({name: 'Home'});
                } else {
                    console.log('Error - failed to create new course');
                }
            })

        },
        resetForm() {
            this.newCourse = {
                teacherId: this.$store.state.user.id,
                courseTitle: '',
                courseDescription: '',
                difficultyLevel: '',
                cost: '',
            };
        }
    }
}
</script>

<style>
.create-new-course {
    background-color: #cccccc94;
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
div.form-element > input,
div.form-element > select {
  height: 30px;
  width: 300px;
  border-radius: 4px;
  padding: 3px 10px;
}
div.form-element > textarea {
  width: 100%;
  height: 150px;
  padding: 10px 10px;
  box-sizing: border-box;
  border: 2px solid #ccc;
  border-radius: 4px;
  background-color: #f8f8f8;
  resize: none;
}
form > input[type="button"], form > input[type="submit"]{
  width: 40%;
  font-size: 1rem;
  border-radius: 8px;
  background-color: rgb(73, 109, 226);
  border: none;
  color: white;
  padding: 5% 10%;
  text-decoration: none;
  margin: 4px 4px;
  cursor: pointer;
}

form > input[type="submit"]:hover {
    background-color:#04AA6D
}
form > input[type="button"]:hover {
    background-color:#eb453f
}
</style>