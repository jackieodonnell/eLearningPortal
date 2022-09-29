<template>
  <div id="register" class="text-center">
    <form class="form-register" @submit.prevent="register">
      <h1 class="app-title">Incrementum</h1>
      <h1 class="h3 mb-3 font-weight-normal">Create Account</h1>
      <div class="alert alert-danger" role="alert" v-if="registrationErrors">
        {{ registrationErrorMsg }}
      </div>
      <!-- <label for="username" class="sr-only">Username</label> -->
      <div id="text">
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
      <input
        type="password"
        id="confirmPassword"
        class="form-control"
        placeholder="Confirm Password"
        v-model="user.confirmPassword"
        required
      />
      <input type="firstName"
      id="firstName"
      class="form-control"
      placeholder="First Name"
      v-model="user.firstName"
      required
      />
      <input type="lastName"
      id="lastName"
      class="form-control"
      placeholder="Last Name"
      v-model="user.lastName"
      required
      />

      </div>
      

      <div id="checks">
        <input type="radio" id="role_teacher" value="Teacher" v-model="user.role"> <label for="role_teacher">Teacher</label>
        <input type="radio" id="role_student" value="Student" v-model="user.role"> <label for="role_student">Student</label>
      </div>
      
      <router-link :to="{ name: 'login' }">Have an account?</router-link>
      <button class="btn btn-lg btn-primary btn-block" type="submit">
        Create Account
      </button>
    </form>
  </div>
</template>

<script>
import authService from '../services/AuthService';

export default {
  name: 'register',
  data() {
    return {
      user: {
        username: '',
        password: '',
        confirmPassword: '',
        role: '',
        firstName: '',
        lastName: ''
      },
      registrationErrors: false,
      registrationErrorMsg: 'There were problems registering this user.',
    };
  },
  methods: {
    register() {
      // Password validation
      if (this.user.password != this.user.confirmPassword) {
        this.registrationErrors = true;
        this.registrationErrorMsg = 'Password & Confirm Password do not match.';
      } else {
        authService
          .register(this.user)
          .then((response) => {
            if (response.status == 201) {
              this.$router.push({
                path: '/login',
                query: { registration: 'success' },
              });
            }
          })
          .catch((error) => {
            const response = error.response;
            this.registrationErrors = true;
            if (response.status === 400) {
              this.registrationErrorMsg = 'Bad Request: Validation Errors';
            }
          });
      }
    },
    clearErrors() {
      this.registrationErrors = false;
      this.registrationErrorMsg = 'There were problems registering this user.';
    },
  },
};
</script>

<style>
@import url('https://fonts.googleapis.com/css2?family=Schoolbell&display=swap');

* {
  font-family: 'Schoolbell', cursive;
  /* border: 1px solid red; */
  /* text-align: center; */
}

#register {
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

.form-register {
  width: 30vw;
 padding: 1.9rem 1.2rem;
 text-align: center;
 background: #f4ff57;
 border-radius: 4px;
 box-shadow: 10px 10px #5e6681;
}

#text input {
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
 width: 20rem;
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

</style>
