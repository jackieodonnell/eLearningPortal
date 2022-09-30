<template>
  <div class="course-page">
      <nav-bar />
      <class-page-hero />
      
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
import NavBar from '../components/NavBar.vue';
import ClassPageHero from '../components/ClassPageHero.vue';

export default {
    name: "course-page",
    components: {
        CourseDetails,
        NavBar,
        ClassPageHero
    },
}
</script>

<style>
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