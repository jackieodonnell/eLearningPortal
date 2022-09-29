<template>
<nav>
    <div class="title-div">
        <h2>Incrementum</h2>
        <img src="https://img.icons8.com/pastel-glyph/64/000000/school-backpack--v1.png"/>
    </div>

    <ul>
        <li><router-link :to="{name: 'home'}">Home</router-link></li>
        <li><router-link :to="{name: 'create-course'}" v-bind="teacher" v-if="teacher">Create</router-link></li>
        <!-- li><router-link :to="{name: '#'}">Grades</router-link></li -->
        <li><router-link :to="{name: '#'}">Account</router-link></li>
        <li><router-link :to="{ name: 'logout' }" v-if="$store.state.token != ''">Logout</router-link></li>
    </ul>
  
  
  
  
  
</nav>
    
</template>

<script>
export default {
    name: 'nav-bar',
    data(){
      return{
        teacher: this.$store.state.user.authorities.some(e => e ['name'] === "ROLE_TEACHER")
      }
    }
}
</script>

<style>
@import url('https://fonts.googleapis.com/css2?family=Schoolbell&display=swap');

* {
  grid-area: navbar;
  padding: 0;
  margin: 0;
}

body {
  font-family:'Gill Sans', 'Gill Sans MT', Calibri, 'Trebuchet MS', sans-serif;
  color: #263238;
}

.title-div {
    /* border: 1px solid red; */
    display: flex;
}

.title-div h2 {
    font-family: 'Schoolbell', cursive;
    color: #0d47a1;
}

img {
    height: 30px;
}

nav {
    display: flex;
    justify-content: space-between;
    padding: 1rem 2rem;
    background: #cfd8dc;
}
nav ul {
  display: flex; /* 5 */
  list-style: none; /* 6 */
}

nav li {
  padding-left: 1rem; /* 7! */
}
nav a {
  text-decoration: none;
  color: #0d47a1
}

nav a:hover {
  box-shadow: inset 100px 0 0 0 #54b3d6;
  color: white;
}


</style>