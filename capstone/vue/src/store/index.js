import Vue from 'vue'
import Vuex from 'vuex'
import axios from 'axios'

Vue.use(Vuex)

/*
 * The authorization header is set for axios when you login but what happens when you come back or
 * the page is refreshed. When that happens you need to check for the token in local storage and if it
 * exists you should set the header so that it will be attached to each request
 */
const currentToken = localStorage.getItem('token')
const currentUser = JSON.parse(localStorage.getItem('user'));

if(currentToken != null) {
  axios.defaults.headers.common['Authorization'] = `Bearer ${currentToken}`;
}

export default new Vuex.Store({
  state: {
    token: currentToken || '',
    user: currentUser || {},
    courses: [
      {
        course_id: 1,
        teacher_id: 1,
        course_title: "Algebra 1",
        course_description: "algebra, etc.",
        difficulty_level: 7,
        cost: 250
      },
      {
        course_id: 2,
        teacher_id: 2,
        course_title: "Biology",
        course_description: "biology, etc.",
        difficulty_level: 9,
        cost: 100
      },
      {
        course_id: 3,
        teacher_id: 3,
        course_title: "English 1",
        course_description: "english, etc.",
        difficulty_level: 9,
        cost: 200
      },
      {
        course_id: 4,
        teacher_id: 4,
        course_title: "US History",
        course_description: "us history, etc.",
        difficulty_level: 9,
        cost: 200
      },
      {
        course_id: 5,
        teacher_id: 4,
        course_title: "Band",
        course_description: "band, etc.",
        difficulty_level: 8,
        cost: 200
      },
    ]
  },
  mutations: {
    SET_AUTH_TOKEN(state, token) {
      state.token = token;
      localStorage.setItem('token', token);
      axios.defaults.headers.common['Authorization'] = `Bearer ${token}`
    },
    SET_USER(state, user) {
      state.user = user;
      localStorage.setItem('user',JSON.stringify(user));
    },
    LOGOUT(state) {
      localStorage.removeItem('token');
      localStorage.removeItem('user');
      state.token = '';
      state.user = {};
      axios.defaults.headers.common = {};
    }
  }
})
