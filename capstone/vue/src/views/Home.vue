<template>
  <div class="home">
    <nav-bar />

      <main>
        <section>
      <div class= "hero-container">
        <div class= "hero-one">
          <h1 class= "hero-title">Welcome to School {{$store.state.user.firstname}}!</h1>
        </div>
        <div class= "hero-two">
          <img class="hero-picture" src="https://d92mrp7hetgfk.cloudfront.net/images/sites/misc/Tech_Elevator/original.png?1579896670">
        </div>
       </div>
     </section>
     <section>
     

       <div class= "product-container">
          <h1 class= "product-title">Your Classes</h1>
         <course-list />
       </div>
     </section>
     
     <div class= "quote-container">
       <div class= "quote-box">
         <h2>This container can be used for grades or notifications or something</h2>
       </div>
     </div>
   </main>

    <div class="footer">
      <h1>footer</h1>
    </div>
  </div>
</template>

<script>
import CourseList from '../components/CourseList.vue';
import NavBar from '../components/NavBar.vue';

export default {
  name: "home",
  components: {
    NavBar,
    CourseList
  }
};
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
  .product-container {
    margin-top: 20px;
    width: 100%;
    height: 10%;
    background-color: white;
    justify-content: center;
    display: flex;
    flex-direction: column;
    min-height: 25%;
  }
  .product-title {
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
  .quote-container {
    display: flex;
    height: 250px;
    background-color: #E5E7EB;
    justify-items: center;
    align-items: center;
  }
  .quote-box {
    background-color: #E5E7EB;
    text-align: center;
    font-size: 18px;
    font-style: italic;
    font-weight: lighter;
    margin: 80px;
  }
  .cta-container {
    display: flex;
    height: 250px;
    width: auto;
    background-color: white;
    justify-content: center;
    align-items: center;  
  }
  .cta-item {
    background-color: #3882F6;
    height: 75%;
    width: 75%;
    border-radius: 8px;
    display: flex;
    justify-content: center;
    align-items: center;
    gap: 200px;
  }
  .cta-text {
    color: white;
    justify-content: center;
    align-items: center;
  }
  .cta-title {
    font-size: 36px;
    font-weight: 1000;
  }
  .cta-write {
    font-size: 20px;
    font-style: italic;
  }
  .cta-button {
    border: 2px solid white;
    border-radius: 8px;
    background-color: transparent;
    color: white;
    font-size: 20px;
    padding: 3px;
  }

.footer {
  grid-area: footer;
  height: 10vh;
}


</style>
