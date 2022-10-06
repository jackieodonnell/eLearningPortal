<template>
  <nav class="nav-top">
    <router-link :to="{ name: 'home' }"
      ><div class="title-div">
        <img src="../../public/images/backpack.png" alt="backpack" />
        <h2>Incrementum</h2>
      </div>
    </router-link>

    <ul>
      <li>
        <div class="notification" v-on:click.prevent="goToGradePage">
          <img
            v-if="teacher"
            src="data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAABgAAAAYCAYAAADgdz34AAAABmJLR0QA/wD/AP+gvaeTAAABMUlEQVRIie2Vu0oDQRSGv5OVbIxF8gDBJisWoilFn8BgbWGiYJWQxnfR0jaChbVo5QPYWWfBYrFPE8mEzB4LoyzGJbOLIAFPNZfz/9+ZGwPLHuKaOA5PAsE+ACjeQSm4Dl10BedK1B4BdaA+a7vpFiXooOkbqXQFOZ8BAA0VufR1eCUb9yY34G3QrnkS3wE7P9N5tvH0sLx5+5oZoIOmP5HqU6p5AlJkuJu2ktQzMIVqb6H5R4kNI5Vu2nQqQJT2QvPPXJFWZgCw5QpAZTsPYNUZgJbzAH4l/gF/D5h7yfpyVjJ2fCFIJ6NVvzjyetLoj5KjK9/TJtY8CrKXtVLQ08naNAD2k6NzW6Rgs5t/aad5tbnD+Ucz4XEE1GbdyA9u1l10zrdIiTtABEQKGS/AMsc7thJTmvVn6PsAAAAASUVORK5CYII="
          />
          <div
            class="notificationcount"
            v-if="submittedGrades.length > 0 && teacher"
          >
            {{ submittedGrades.length }}
          </div>
        </div>
      </li>

      <li><router-link :to="{ name: 'home' }">Home</router-link></li>
      <li><router-link :to="{ name: 'account' }">Account</router-link></li>
      <li>
        <router-link :to="{ name: 'logout' }" v-if="$store.state.token != ''"
          >Logout</router-link
        >
      </li>
    </ul>
  </nav>
</template>

<script>
import gradesService from "../services/GradesService";

export default {
  name: "nav-bar",
  components: {},
  created() {
    gradesService.getAllGrades().then((response) => {
      if (response.status == 200) {
        const grades = response.data;
        this.submittedGrades = grades.filter((grade) => {
          return grade.status == "Submitted";
        });
      }
    });
  },

  data() {
    return {
      submittedGrades: [],
      teacher: this.$store.state.user.authorities.some(
        (e) => e["name"] === "ROLE_TEACHER"
      ),
    };
  },
  methods: {
    goToGradePage() {
      this.$router.push(`/course/${this.submittedGrades[0].courseId}`);
    },
  },
};
</script>

<style>
@import url("https://fonts.googleapis.com/css2?family=Schoolbell&display=swap");

body {
  margin: 0;
}
.nav-top {
  grid-area: navbar;
  padding: 0;
  margin: 0;
  width: auto;
}

.notification {
  position: relative;
  display: flex;
  align-items: center;
  justify-content: center;
  cursor: pointer;
}

.notificationcount {
  font-family: Arial, Helvetica, sans-serif;
}

.notification > .notificationcount {
  top: 8px;
  right: 22px;
  color: #fff;
  background-color: #dc3549;
  height: 14px;
  min-width: 5px;
  font-size: 12px;
  font-weight: 500;
  position: absolute;
  border-radius: 14px;
  padding: 0 6px;
  display: flex;
  align-items: center;
  justify-content: center;
}

.title-div {
  display: flex;
  align-items: center;
}

.title-div h2 {
  font-family: "Schoolbell", cursive;
  color: #f9dc59;
}

.title-div img {
  height: 30px;
  margin-right: 5%;
}

.nav-top {
  display: flex;
  justify-content: space-between;
  padding: 1rem 2rem;
  background-color: #04469e;
}
.nav-top ul {
  display: flex; /* 5 */
  list-style: none; /* 6 */
}

.nav-top img {
  width: 25px;
  height: 25px;
}

.nav-top li {
  padding-left: 1rem; /* 7! */
  font-size: 1.2rem;
}
.nav-top a {
  text-decoration: none;
  color: #f9dc59;
  font-family: Verdana, Geneva, Tahoma, sans-serif;
}

.nav-top li a:hover,
.title-div h2:hover {
  box-shadow: 0 8px 24px 0 rgb(16 39 112 / 20%);
  color: #f6f4f7;
}
</style>