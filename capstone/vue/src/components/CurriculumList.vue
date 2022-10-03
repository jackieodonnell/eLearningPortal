<template>
    <div class="curriculum-list">
      <div id="curriculum-items" v-for="curriculum in curricula" v-bind:key="curriculum.curriculumId" v-bind:curriculumId="curriculum.curriculumId">
            <div id="overview-item">
                <router-link v-bind:to="{name: 'course-page'}" id="overview-link">
                    Course Home Page
                </router-link>
            </div> 
            <div id="instruction-item" v-for="instruction in dailyInstructions" v-bind:key="instruction.dailyInstructionsId">
                <router-link v-bind:to="{name: 'instruction-content', params: {instructionId: instruction.dailyInstructionsId} }" 
                        v-bind:dailyInstructionsId="instruction.dailyInstructionsId"
                        id="instruction-link">
                    {{instruction.instructions}}
                </router-link>    
            </div>
            <div id="add-lesson-btn-container">
                <button id="add-lesson-btn">
                    Add Lesson
                </button>
            </div> 
        </div>
    </div>
</template>

<script>
import CurriculumService from '../services/CurriculumService.js';
import InstructionService from '../services/InstructionService';
import AssignmentService from '../services/AssignmentService';

export default {
    name: 'curriculum-list',
    data() {
        return {
            instruction: {},
            curricula: [],
            dailyInstructions: [],
            curriculumId: 0,
            assignments: []
        }
    },
    created() {
        CurriculumService.getAllCurriculumInCourse(this.$route.params.courseId).then(response => {
            if(response.status == 200) {
                this.curricula = response.data  
                this.curriculumId = this.curricula[0].curriculumId
            }
        });
        InstructionService.getInstructionsInCourse(this.$route.params.courseId).then(response => {
            if(response.status == 200) {
                this.dailyInstructions = response.data 
            } 
        });
        AssignmentService.getAllAssignmentsInCourse(this.$route.params.courseId).then(response => {
            if (response.status == 200) {
                this.assignments = response.data;
            }
        });
    },
}
</script>

<style>
#curriculum-items {
    display: flex;
    flex-direction: column;
}

#instruction-item, #overview-item {
    margin-top: 1px;
    padding-top: 8px;
    padding-bottom: 8px;
    padding-left: 3%;
    padding-right: 3%;
    /* border-bottom: 1px solid rgba(128, 128, 128, 0.411); */
    /* border-right: 1px solid rgba(128, 128, 128, 0.411); */
    /* background-color: #c3e7dd; */
    background-color: #202d53a1;
    border-radius: 2px;
    box-shadow: 0 0 0 1px rgba(107, 107, 107, 0.185);
}

#overview-item {
    background-color: #384c8ab0;
}


#instruction-item:hover, #overview-item:hover{
    background-color:#fffdfdf5;
    color:#1e1c3b;
    opacity: 1;
    transform: translateX(1%);
    box-shadow: 0 10px 20px 4px rgba(104, 104, 104, 0.1);
}
#instruction-link, #overview-link {
    text-decoration: none;
    color: #f6f4f7;
    font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
    font-size: 1.1rem;
    font-weight: 300;
}

#instruction-item:hover #instruction-link {
    color:#1e1c3b;
    font-weight: 400;
}
#overview-item:hover #overview-link {
    color:#1e1c3b;
    font-weight: 400;
}
#overview-link {
    font-weight: 500;
}

#add-lesson-btn-container{
    text-align: center;
    margin-top: 10px;
    margin-bottom: 10px;
}

#add-lesson-btn-container button{
    border: none;
    border-radius: 4px;
    font-weight: bold;
    font-size: .8em;
    text-transform: uppercase;
    padding: 10px;
    padding-inline: 10%;
    background-color: #f9dc59;
    color: #5e6681;
    box-shadow: 0 8px 24px 0 rgb(255 235 167 / 20%);
    transition: all .3s ease-in-out;
}
#add-lesson-btn-container button:hover {
 background-color: #5e6681;
 color: #ffeba7;
 box-shadow: 0 8px 24px 0 rgb(16 39 112 / 20%);
}




</style>