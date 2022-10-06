<template>
  <div id="register" class="text-center">
    <div id="app-title-div">
      <img src="../../public/images/backpack.png" alt="backpack-logo" />
      <h1 class="app-title">Incrementum</h1>
    </div>
    <form class="form-register" @submit.prevent="register">
      <h1 class="create-account-header">Create Account</h1>
      <div class="alert alert-danger" role="alert" v-if="registrationErrors">
        <h3 id="error-message">{{ registrationErrorMsg }}</h3>
      </div>
      <!-- <label for="username" class="sr-only">Username</label> -->
      <div id="text">
        <input
          type="firstName"
          id="firstName"
          class="form-control"
          placeholder="First Name"
          v-model="user.firstName"
          required
        />
        <input
          type="lastName"
          id="lastName"
          class="form-control"
          placeholder="Last Name"
          v-model="user.lastName"
          required
        />
        <input
          type="text"
          id="username"
          class="form-control"
          placeholder="Username"
          v-model="user.username"
          required
          autofocus
        />
        <input
          type="password"
          id="password"
          class="form-control"
          placeholder="Password"
          v-model="user.password"
          required
        />
        <label id="password-label" for="password"
          >Password must contain at least 8 characters, one capital letter, and
          one number.</label
        >
        <input
          type="password"
          id="confirmPassword"
          class="form-control"
          placeholder="Confirm Password"
          v-model="user.confirmPassword"
          required
        />
      </div>

      <div id="checks">
        <input
          type="radio"
          id="role_teacher"
          value="Teacher"
          v-model="user.role"
        />
        <label for="role_teacher">Teacher</label>
        <input
          type="radio"
          id="role_student"
          value="Student"
          v-model="user.role"
        />
        <label for="role_student">Student</label>
      </div>

      <router-link :to="{ name: 'login' }">Have an account?</router-link>
      <button class="btn btn-lg btn-primary btn-block" type="submit">
        Create Account
      </button>
    </form>
  </div>
</template>

<script>
import authService from "../services/AuthService";

export default {
  name: "register",
  data() {
    return {
      user: {
        username: "",
        password: "",
        confirmPassword: "",
        role: "",
        firstName: "",
        lastName: "",
      },
      registrationErrors: false,
      registrationErrorMsg: "There were problems registering this user.",
    };
  },
  methods: {
    register() {
      // Password validation
      if (this.user.password != this.user.confirmPassword) {
        this.registrationErrors = true;
        this.registrationErrorMsg = "Password & Confirm Password do not match.";
      } else if (
        this.user.password.search(/[A-Z]/) < 0 ||
        this.user.password.search(/[0-9]/) < 0 ||
        this.user.password.length < 8
      ) {
        this.registrationErrors = true;
        this.registrationErrorMsg =
          "Password must be at least 8 characters, " +
          "and must include at least one uppercase letter " +
          "and at least one number.";
      } else {
        authService
          .register(this.user)
          .then((response) => {
            if (response.status == 201) {
              this.$router.push({
                path: "/login",
                query: { registration: "success" },
              });
            }
          })
          .catch((error) => {
            const response = error.response;
            this.registrationErrors = true;
            if (response.status === 400) {
              this.registrationErrorMsg = "Bad Request: Validation Errors";
            }
          });
      }
    },
    clearErrors() {
      this.registrationErrors = false;
      this.registrationErrorMsg = "There were problems registering this user.";
    },
  },
};
</script>

<style>
@import url("https://fonts.googleapis.com/css2?family=Schoolbell&display=swap");

#register {
  font-family: "Segoe UI", Tahoma, Geneva, Verdana, sans-serif;
  background-color: #001a33;
  height: 100vh;
  display: flex;
  justify-content: center;
  align-items: center;
  flex-direction: column;
}

#error-message {
  font-family: Arial, Helvetica, sans-serif;
  color: red;
  font-weight: 700;
  font-size: 1rem;
}

#app-title-div {
  font-family: "Schoolbell", cursive;
  display: flex;
  justify-content: center;
  align-items: flex-end;
  gap: 15px;
}

#app-title-div img {
  height: 70px;
  margin-bottom: 10px;
}

.form-register {
  width: 30vw;
  height: fit-content;
  padding: 2rem 3rem;
  text-align: center;
  background-color: #ffe760;
  border-radius: 4px;
  box-shadow: 10px 10px #5e6681;
}

#text input {
  width: 70%;
  margin-top: 0.5rem;
  margin-left: auto;
  margin-right: auto;
  display: flex;
  align-items: center;
  justify-content: center;
  gap: 0.5em;
  background-color: #fff8e2;
  border-radius: 4px;
  padding: 0.5em 1em;
}

#password-label {
  font-size: 0.8rem;
  font-style: italic;
  font-weight: 500;
  color: #3e4352;
}

#checks {
  display: flex;
  justify-content: center;
  margin-top: 10px;
  gap: 10px;
}

.btn {
  margin: 1rem;
  border: none;
  border-radius: 4px;
  font-weight: bold;
  font-size: 0.8em;
  text-transform: uppercase;
  padding: 0.6em 1.2em;
  background-color: #57ffcb;
  color: #5e6681;
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

.create-account-header {
  font-family: "Segoe UI", Tahoma, Geneva, Verdana, sans-serif;
  font-weight: 500;
  text-transform: uppercase;
  font-size: 1.5rem;
  margin-top: 5%;
  margin-bottom: 5%;
  color: #001a33;
}
</style>