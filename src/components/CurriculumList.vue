<template>
  <div class="curriculum-list">
    <new-lesson
      v-bind:curriculumId="curriculumId"
      v-if="displayNewLesson"
      v-on:displayNewLesson="showNewLessonForm"
      id="new-lesson-form"
    />
    <div
      id="curriculum-items"
      v-for="curriculum in curricula"
      v-bind:key="curriculum.curriculumId"
      v-bind:curriculumId="curriculum.curriculumId"
    >
      <div id="overview-item">
        <router-link v-bind:to="{ name: 'course-page' }" id="overview-link">
          Course Home Page
        </router-link>
      </div>
      <div
        id="instruction-item"
        v-for="instruction in dailyInstructions"
        v-bind:key="instruction.dailyInstructionsId"
      >
        <router-link
          v-bind:to="{
            name: 'instruction-content',
            params: { instructionId: instruction.dailyInstructionsId },
          }"
          v-bind:dailyInstructionsId="instruction.dailyInstructionsId"
          id="instruction-link"
          class="instruction-link"
        >
          {{ instruction.instructions }}
        </router-link>
      </div>
      <div id="add-lesson-btn-container">
        <button v-bind="teacher" v-if="teacher" v-on:click="showNewLessonForm">
          Add Lesson
        </button>
      </div>
    </div>
  </div>
</template>

<script>
import CurriculumService from "../services/CurriculumService.js";
import InstructionService from "../services/InstructionService";
import AssignmentService from "../services/AssignmentService";
import NewLesson from "../components/NewLesson.vue";

export default {
  name: "curriculum-list",
  data() {
    return {
      instruction: {},
      curricula: [],
      dailyInstructions: [],
      curriculumId: 0,
      assignments: [],
      teacher: this.$store.state.user.authorities.some(
        (e) => e["name"] === "ROLE_TEACHER"
      ),
      displayNewLesson: false,
    };
  },
  created() {
    CurriculumService.getAllCurriculumInCourse(
      this.$route.params.courseId
    ).then((response) => {
      if (response.status == 200) {
        this.curricula = response.data;
        this.curriculumId = this.curricula[0].curriculumId;
      }
    });
    InstructionService.getInstructionsInCourse(
      this.$route.params.courseId
    ).then((response) => {
      if (response.status == 200) {
        this.dailyInstructions = response.data;
      }
    });
    AssignmentService.getAllAssignmentsInCourse(
      this.$route.params.courseId
    ).then((response) => {
      if (response.status == 200) {
        this.assignments = response.data;
      }
    });
  },
  components: {
    NewLesson,
  },
  methods: {
    showNewLessonForm() {
      if (this.displayNewLesson == false) {
        this.displayNewLesson = true;
      } else {
        this.displayNewLesson = false;
      }
    },
  },
};
</script>

<style>
#curriculum-items {
  display: flex;
  flex-direction: column;
}

#instruction-item,
#overview-item {
  margin-top: 1px;
  padding-top: 8px;
  padding-bottom: 8px;
  padding-left: 3%;
  padding-right: 3%;
  background-color: #202d53a1;
  border-radius: 2px;
  box-shadow: 0 5px 5px 1px rgba(105, 105, 133, 0.349);
  flex-wrap: wrap;
}

#overview-item {
  background-color: #7175a062;
  box-shadow: 0 5px 5px 1px rgba(40, 40, 53, 0.842);
}

#instruction-item:hover,
#overview-item:hover {
  background-color: #fffdfdf5;
  color: #1e1c3b;
  opacity: 1;
  transform: translateX(1%);
  box-shadow: 0 10px 20px 4px rgba(104, 104, 104, 0.1);
}

.instruction-link,
#overview-link {
  text-decoration: none;
  color: #f6f4f7;
  font-family: "Segoe UI", Tahoma, Geneva, Verdana, sans-serif;
  font-size: 1.1rem;
  font-weight: 300;
}

#overview-link {
  text-decoration: none;
  color: #f6f4f7;
  font-family: "Segoe UI", Tahoma, Geneva, Verdana, sans-serif;
  font-size: 1.1rem;
  font-weight: 300;
}

#instruction-item:hover #instruction-link {
  color: #1e1c3b;
  font-weight: 400;
}

#overview-item:hover #overview-link {
  color: #1e1c3b;
  font-weight: 400;
}
#overview-link {
  font-weight: 500;
}
#instruction-item:has(a.router-link-active) {
  background-color: #fffdfdf5;
  opacity: 1;
  transform: translateX(1%);
  box-shadow: 0 10px 20px 4px rgba(104, 104, 104, 0.1);
}

.router-link-active {
  color: #1e1c3b;
  font-weight: 400;
}

#add-lesson-btn-container {
  text-align: center;
  margin-top: 10px;
  margin-bottom: 10px;
}

#add-lesson-btn-container button {
  border: none;
  border-radius: 4px;
  font-weight: bold;
  font-size: 0.8em;
  text-transform: uppercase;
  padding: 10px;
  padding-inline: 10%;
  background-color: #f9dc59;
  color: #5e6681;
  box-shadow: 0 8px 24px 0 #1e1c3b9f;
  transition: all 0.3s ease-in-out;
}
#add-lesson-btn-container button:hover {
  background-color: #5e6681;
  color: #ffeba7;
  box-shadow: 0 8px 24px 0 rgb(16 39 112 / 20%);
}
#new-lesson-form {
  position: fixed;
  left: 50%;
  right: 0%;
  top: 40%;
  transform: translate(-50%, -50%);
}
</style>