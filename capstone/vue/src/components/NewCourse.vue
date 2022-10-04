<template>
  <div class="new-course">
      <form class="create-new-course" v-on:submit.prevent="createNewCourse">
          <div class="form-header">
              <h1 class="create-course-header">Create New Course</h1>
          </div>
          <div class="form-element">
              <label for="course-title">Course Title:</label>
              <input id="course-title" type="text" v-model="newCourse.courseTitle" required />
          </div>
          <div class="form-element">
              <label for="course-description">Course Description:</label>
              <input type="textarea" id="course-description" v-model="newCourse.courseDescription" required />
          </div>
          <div class="form-element">
              <label for="difficulty">Grade Level:</label>
              <select id="difficulty" form="create-new-course" v-model="newCourse.difficulty" required>
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
              <select id="cost" form="create-new-course" v-model="newCourse.cost" required>
                  <option value="0.00">FREE</option>
              </select>
          </div>
          <input type="submit" value="Save" />
          <input type="button" value="Cancel" v-on:click.prevent="resetForm" />       
      </form>
  </div>
</template>

<script>
import curriculumService from '../services/CurriculumService';
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
                isArchived: false,
            }
        }
    },
    methods: {
        createNewCourse() {
            courseService.createCourse(this.newCourse).then(response => {
                if (response.status == 201) {
                    const courseId = response.data;
                    const newCurriculum = {
                        curriculumId: '',
                        courseId: courseId,
                        curriculumTitle: '',
                        curriculumDescription: '',
                    }
                    curriculumService.createCurriculum(newCurriculum).then(resp => {
                        if (resp.status == 201){
                            this.resetForm();
                        }
                    })
                
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
                isArchived: false,
            };
            this.$router.push({name: 'home'})
        },
    }
}
</script>

<style>
.new-course {
    width: 100%;
}

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
  width: 80%;
  border-radius: 4px;
  padding: 3px 10px;
}
div.form-element > textarea {
  width: 80%;
  height: 50%;
  padding: 10px 10px;
  box-sizing: border-box;
  border: 2px solid #ccc;
  border-radius: 4px;
  background-color: #f8f8f8;
  resize: none;
}
form > input[type="button"], form > input[type="submit"]{
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
    background-color:#04AA6D
}
form > input[type="button"]:hover {
    background-color:#eb453f
}
</style>