<template>
  <div id="login" class="text-center">
    <div id="app-title-div">
      <img src="../../public/images/backpack.png" alt="backpack-logo" />
      <h1 class="app-title">Incrementum</h1>
      <!-- <img
        src="data:image/png;base64,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"
      /> -->
    </div>
    <form class="form-signin" @submit.prevent="login">
      <h1 class="msg">Please Sign In</h1>
      <div class="alert alert-danger" role="alert" v-if="invalidCredentials">
        Invalid username and password!
      </div>
      <div
        class="alert alert-success"
        role="alert"
        v-if="this.$route.query.registration"
      >
        Thank you for registering, please sign in.
      </div>
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
        password: "",
      },
      invalidCredentials: false,
    };
  },
  methods: {
    login() {
      authService
        .login(this.user)
        .then((response) => {
          if (response.status == 200) {
            this.$store.commit("SET_AUTH_TOKEN", response.data.token);
            this.$store.commit("SET_USER", response.data.user);
            this.$router.push("/");
          }
        })
        .catch((error) => {
          const response = error.response;

          if (response.status === 401) {
            this.invalidCredentials = true;
          }
        });
    },
  },
};
</script>

<style scoped>
@import url("https://fonts.googleapis.com/css2?family=Schoolbell&display=swap");

#login {
  font-family: "Schoolbell", cursive;
  background-color: #001a33;
  height: 100vh;
  display: flex;
  justify-content: center;
  align-items: center;
  flex-direction: column;
}

#app-title-div {
  margin-right: 0px;
  display: flex;
  justify-content: center;
  align-items: flex-end;
  gap: 15px;
}

#app-title-div img {
  height: 70px;
  margin-bottom: 10px;
}

.form-signin {
  width: 30vw;
  height: 30vh;
  padding: 2rem 1rem;
  text-align: center;
  background-color: #ffe760;
  border-radius: 5px;
  box-shadow: 10px 10px #5e6681;
}

input {
  width: 60%;
  margin-top: 1rem;
  margin-left: auto;
  margin-right: auto;
  display: flex;
  align-items: center;
  justify-content: center;
  gap: 0.5em;
  background-color: #fff8e2;
  border-radius: 4px;
  padding: 0.7em 1em;
}

.btn {
  margin: 1rem;
  border: none;
  border-radius: 4px;
  font-weight: bold;
  font-size: 0.8em;
  text-transform: uppercase;
  padding: 0.6em 1.2em;
  background-color: #5e6681;
  color: #fff8e2;
  box-shadow: 0 8px 24px 0 rgb(16 39 112 / 20%);
  transition: all 0.3s ease-in-out;
}

.btn:hover {
  background-color: #0b60ce;
  color: #fcfbf7;
  box-shadow: 0 8px 24px 0 rgb(16 39 112 / 50%);
}

.app-title {
  margin-bottom: 0px;
  font-size: 4em;
  font-weight: 500;
  color: #ffe760;
}

.msg {
  font-family: "Segoe UI", Tahoma, Geneva, Verdana, sans-serif;
  font-weight: 500;
  text-transform: uppercase;
  font-size: 1.5rem;
  margin-top: 5%;
  margin-bottom: 5%;
  color: #001a33;
}
</style>
