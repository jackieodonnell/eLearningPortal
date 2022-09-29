<template>
  <div class="course-details">

  </div>
</template>

<script>
import courseService from '../services/CourseService';

export default {
    name: "course-details",
    data(){
        return {
            course: {
                courseId: '',
                teacherId: '',
                courseTitle: '',
                courseDescription: '',
                difficulty: '',
                cost: '',
            }
        }
    },
    created(){
        courseService.getCourseByCourseId(this.$route.params.courseId).then(response => {
            if (response.status == 200){
                this.course = response.data;
            }
        })       
    }
}
</script>

<style>

</style>