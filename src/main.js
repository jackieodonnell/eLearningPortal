import Vue from 'vue'
import App from './App.vue'
import router from './router/index'
import store from './store/index'
import axios from 'axios'

Vue.config.productionTip = false

axios.defaults.baseURL = 'https://incrementum-server.fly.dev';

new Vue({
  router,
  store,
  render: h => h(App)
}).$mount('#app')
