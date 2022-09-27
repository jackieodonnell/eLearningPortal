<template>
  <div id="login" class="text-center">
    <form class="form-signin" @submit.prevent="login">
      <h1 class="app-title">Incrementum</h1>
      <h1 class="msg">Please Sign In</h1>
      <div
        class="alert alert-danger"
        role="alert"
        v-if="invalidCredentials"
      >Invalid username and password!</div>
      <div
        class="alert alert-success"
        role="alert"
        v-if="this.$route.query.registration"
      >Thank you for registering, please sign in.</div>
      <!-- <label for="username" class="sr-only">Username</label> -->
      <input
        type="text"
        id="username"
        class="form-control"
        placeholder="Username"
        v-model="user.username"
        required
        autofocus
      />
      <!-- <label for="password" class="sr-only">Password</label> -->
      <input
        type="password"
        id="password"
        class="form-control"
        placeholder="Password"
        v-model="user.password"
        required
      />
      <button class="btn" type="submit">Sign in</button>
      <router-link :to="{ name: 'register' }">
        <button class="btn">Create Account</button>
      </router-link>
    </form>
  </div>
</template>

<script>
import authService from "../services/AuthService";

export default {
  name: "login",
  components: {},
  data() {
    return {
      user: {
        username: "",
        password: ""
      },
      invalidCredentials: false
    };
  },
  methods: {
    login() {
      authService
        .login(this.user)
        .then(response => {
          if (response.status == 200) {
            this.$store.commit("SET_AUTH_TOKEN", response.data.token);
            this.$store.commit("SET_USER", response.data.user);
            this.$router.push("/");
          }
        })
        .catch(error => {
          const response = error.response;

          if (response.status === 401) {
            this.invalidCredentials = true;
          }
        });
    }
  }
};
</script>

<style scoped>
<<<<<<< HEAD
  #login{
    display: flex;
    flex-direction: column;
    /* align-content: center; */
    text-align: center;
    justify-content: center;
  }
=======
@import url('https://fonts.googleapis.com/css2?family=Schoolbell&display=swap');

* {
  font-family: 'Schoolbell', cursive;
  /* border: 1px solid red; */
  /* text-align: center; */
}

#login {
  height: 100vh;
  display: flex;
  justify-content: center;
  align-items: center;
  /* position: absolute;
  left: 50%;
  top: 50%;
  transform: translate(-50%, -50%);
  padding: 10px; */
}

.form-signin {
 width: 30vw;
 padding: 1.9rem 1.2rem;
 text-align: center;
 background: #f4ff57;
 border-radius: 4px;
 box-shadow: 10px 10px #5e6681;
}



input {
 margin-top: .5rem;
 margin-left: auto;
 margin-right: auto;
 display: flex;
 align-items: center;
 justify-content: center;
 gap: .5em;
 background-color: #d8ffcf;
 border-radius: 4px;
 padding: .5em 1em;
}

.btn {
 margin: 1rem;
 border: none;
 border-radius: 4px;
 font-weight: bold;
 font-size: .8em;
 text-transform: uppercase;
 padding: 0.6em 1.2em;
 background-color: #57ffcb;
 color: #5e6681;
 box-shadow: 0 8px 24px 0 rgb(255 235 167 / 20%);
 transition: all .3s ease-in-out;
}

.btn:hover {
 background-color: #5e6681;
 color: #ffeba7;
 box-shadow: 0 8px 24px 0 rgb(16 39 112 / 20%);
}



.app-title, .msg {
 margin-bottom: 1rem;
 font-size: 2em;
 font-weight: 500;
 color: #5e6681;
}

.app-title {
  font-size: 4em;
}

>>>>>>> main
</style>
