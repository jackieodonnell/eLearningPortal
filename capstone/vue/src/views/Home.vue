<template>
  <div class="home">
    <nav-bar />
    <home-page-hero />


       <div class= "classes-container">
          <h1 class= "classes-title">Your Classes Dashboard</h1>
         <course-list />
       </div>
   
     
     <div class= "calendar-container">
       <div class= "calendar-box">
         <!-- <upcoming-assignments /> -->
       </div>
     </div>

 </div>
</template>

<script>
import CourseList from '../components/CourseList.vue';
import NavBar from '../components/NavBar.vue';
import HomePageHero from '../components/HomePageHero.vue';
// import UpcomingAssignments from '../components/UpcomingAssignments.vue';

export default {
  name: "home",
  components: {
    NavBar,
    CourseList,
    HomePageHero,
    // UpcomingAssignments,
  }
};
</script>

<style>
@import url('https://fonts.googleapis.com/css2?family=Schoolbell&display=swap');


  .classes-container {
    font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
    margin-top: 0px;
    width: 100%;
    height: 10%;
    /* background-color: white; */
    background-color: #f6f4f7;
    justify-content: center;
    display: flex;
    flex-direction: column;
    min-height: 25%;
  }
  .classes-title {
    text-align: center;
    padding: 5px;
    font-size: 1.5rem;
    margin-left: 20%;
    margin-right: 20%;
    margin-top: 20px;
    text-transform: uppercase;
    border-bottom: 1px solid #1f2937cc;
    color: #1f2937cc;
    font-weight: 400;
  }
  /* .text-container {
    background-color: white;
    justify-content: center;
    display: flex;
    /* gap: 70px; */
    /* flex-direction: row; */
    /* height: 150px; */
  /* } */
  /* .text-container div { */
    /* height: 100px; */
    /* width: 100px;
    text-align: center;
    color: #1F2937;
    margin-top: 10px;
    font-weight: bolder;
  } */ 
  .calendar-container {
    display: flex;
    height: 30vh;
    background-color: #E5E7EB;
    justify-items: center;
    align-items: center;
  }
  .calendar-box {
    background-color: #E5E7EB;
    text-align: center;
    font-size: 18px;
    font-style: italic;
    font-weight: lighter;
    margin: 80px;
  }
  
.footer {
  grid-area: footer;
  height: 10vh;
}


</style>
