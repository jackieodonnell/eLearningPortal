<template>
  <div class="course-page">
      <nav-bar />
      <div class= "hero-container">
        <div class= "hero-one">
          <h1 class= "hero-title"> {{ course.courseTitle}}</h1>

        </div>
        <div class= "hero-two">
          <img class="hero-picture" src="https://d92mrp7hetgfk.cloudfront.net/images/sites/misc/Tech_Elevator/original.png?1579896670">
        </div>
       </div>
       
       <div class= "details-container">
            <course-details />
       </div>

            
     <div class= "assignments-container">
       <div class= "assignments-box">
         <h2>Upcoming assignments</h2>
       </div>
     </div>

       
    
     
     


    
  </div>
</template>

<script>
import CourseDetails from '../components/CourseDetails.vue';
import NavBar from '../components/NavBar.vue'
import courseService from '../services/CourseService';
export default {
    name: "course-page",
    components: {
        CourseDetails,
        NavBar
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
.hero-container {
    display: flex;
    justify-content: space-between;
    background: #000b6c;
    height: 25%;
  }

  .hero-container div {
    display: flex;
    margin: 50px;
    /* border: 1px solid red; */
  }
  
  .hero-one {
    align-self: center;
    color: white;
    width: 50%;
  }

  .hero-title {
    font-size: 48px;
    font-style: extra-bold;
    font-family: #F9FAF8;
  }
  .hero-subtitle {
    font-size: 18px;
    font-family: #E5E7EB;
  }

  .hero-picture {
    border-radius: 8px;
    height: 20vh;
    justify-content: right;
  }
  .details-container {
    margin-top: 20px;
    width: 100%;
    height: 10%;
    background-color: white;
    justify-content: center;
    display: flex;
    flex-direction: column;
    min-height: 25%;
  }
  .details-title {
    text-align: center;
    font-size: 36px;
    font-weight: 1000;
    color: #1F2937;
  }

   .assignments-container {
    display: flex;
    height: 30vh;
    background-color: #E5E7EB;
    justify-items: center;
    align-items: center;
  }
  .assignments-box {
    background-color: #E5E7EB;
    text-align: center;
    font-size: 18px;
    font-style: italic;
    font-weight: lighter;
    margin: 80px;
  }

</style>