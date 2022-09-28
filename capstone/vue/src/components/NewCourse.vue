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
              <label for="difficulty-level">Grade Level:</label>
              <select id="difficulty-level" v-model="newCourse.difficultyLevel">
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
              <select id="cost">
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
                difficultyLevel: '',
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

<style scoped>
div.form-element {
  margin-top: 10px;
}
div.form-element > label {
  display: block;
}
div.form-element > input,
div.form-element > select {
  height: 30px;
  width: 300px;
}
div.form-element > textarea {
  height: 60px;
  width: 300px;
}
form > input[type="button"] {
  width: 100px;
}
form > input[type="submit"] {
  width: 100px;
  margin-right: 10px;
}

</style>