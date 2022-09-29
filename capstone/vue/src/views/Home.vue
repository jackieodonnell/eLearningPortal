<template>
  <div class="home">
    <nav-bar />

      <main>
      <div class= "hero-container">
        <div class= "hero-one">
          <h1 class= "hero-title">Welcome to School {{$store.state.user.firstname}}!</h1>
        </div>
        <div class= "hero-two">
          <img class="hero-picture" src="https://d92mrp7hetgfk.cloudfront.net/images/sites/misc/Tech_Elevator/original.png?1579896670">
        </div>
       </div>
     
  
     

       <div class= "classes-container">
          <h1 class= "classes-title">Your Classes</h1>
         <course-list />
       </div>
   
     
     <div class= "calendar-container">
       <div class= "calendar-box">
         <h2>Upcoming assignments</h2>
       </div>
     </div>
   </main>

 </div>
</template>

<script>
import CourseList from '../components/CourseList.vue';
import NavBar from '../components/NavBar.vue';

export default {
  name: "home",
  components: {
    NavBar,
    CourseList,
   
  }
};
</script>

<style>
@import url('https://fonts.googleapis.com/css2?family=Schoolbell&display=swap');

* {
  font-family: 'Schoolbell', cursive;
}
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
  .classes-container {
    margin-top: 20px;
    width: 100%;
    height: 10%;
    background-color: white;
    justify-content: center;
    display: flex;
    flex-direction: column;
    min-height: 25%;
  }
  .classes-title {
    text-align: center;
    font-size: 36px;
    font-weight: 1000;
    color: #1F2937;
  }
  .text-container {
    background-color: white;
    justify-content: center;
    display: flex;
    gap: 70px;
    flex-direction: row;
    height: 150px;
  }
  .text-container div {
    height: 100px;
    width: 100px;
    text-align: center;
    color: #1F2937;
    margin-top: 10px;
    font-weight: bolder;
  }
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
