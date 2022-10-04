<template>
<nav class="nav-top">
    <router-link :to="{name: 'home'}"><div class="title-div">
        <img src="../../public/images/backpack.png" alt="backpack"/>
        <h2>Incrementum</h2>
        <!-- <img src="data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAEAAAABACAYAAACqaXHeAAAABmJLR0QA/wD/AP+gvaeTAAAJ4ElEQVR4nO2bf4xcVRXHP+fO0u7Om90FNG0UUijQlkIqCIqmgIiUALE/+DXdaZG4QkKhVqIpFREVFIJYpYmJopSiVLDd6RSxVtLW1PBTDbXEaIrbSlu1oIWSQjszb7fddt7xj/dj3s7uzLzdeVtK4zfZ5N17z/3e887e++6559wRRgiqN1o99E1TOB3kuGHS9AnsSGJvFFnbE6uCHiRuQlXEpuMO4G6gPSbafaD3W6xaIoLGxAnEbADVe43N1idB58TJG8IKi+zn4jRCrAYoasciYHGIfIcDvxf03eHwKXKCgcvcZRRgYUqySxrV1UdsBlC90bLp+w/etFdYliK/QGTdwcZ4rxpt0/4w6E1e1T6LnpPi+iaYOEgAejh0Gd7LC2yP4+UBRNYdtNg/X2GnV3V8D8nPNMrrIzYDKEz0nx1kYxwv78Pj2jjYWI0iTgOkQsW34uItQ3aXx5K2uFhjM8D7FbEZQHAK5WdN1ZIdHr+2hp7zcfHGOAPM7lDhQ/HxBviw/6Dw37hIm4Yi/I6m20djHnDQfSn02yK5vrJSzhtS3lXPiUvBEAJOxXkj3LBf0yc2Ye5XKFi0f0Nk6aGopEOaAcdhFivMF+TrRRIzw20pkpsEil7x7P2aPmMo3LWQ146JwGSvWGil+OdwuyFxu8JtwFdt9t0+FO7IBujV9HiBL5Q7lv4Zbhd5/ACwwS8nkHlDUaQWDHprMA6sr9xiBWd7qLRIdUYyOndElDB3A96pTtdbkntlELHHQ4os6NW5p0Tlr4ZeTY8HmR+q+nmljMWeLuA1rzjWpuW2qPyRDPC2zmwF5pY7mXsHk7Mk+1vgWa/YXMJ5SjXdElWZSqh2NpcwK4HRbo08b0l2XaWcyHOHQe4LysitlTLVEMkALTTPAloAFPlTUrperk7ofA3wPkJ6fg/yC9XO5qgK+VDtbO6h90ngE15Vn1BaWE3e4s2VoHtcHTnD1o7zoowTcQlIR0i1lbUkk5LbJPClQBq5vkjvs72aOTXaWO60tznwvMJ1gQbogirLzm2X5w4L5Mrj0lFNNoy6BlC91wCf8ouCk6slD2BJ9hH6H4s/WUK3FrXjoVq7w36dO6Gos5eUMN2gF4SaHrRk1aP1xi1hsuWSfLqevKdbbeR1zpkGp9sT3m5JdkIUYgBbM7co+iOCj2eAbuAvoN6ZQcYCH6W81fnoE/iiJdllUcZzj85teWAUcNCivbWeT1B3Bhic84MBYHMURXxY0rVUkKnACxVNk4G5IF9x/5jLwJd/TnCmRn15CE6NW7zi6B72T6nXp64BBDml/ByQR4YlXZtTkr1EkOmCrg45S4OhIJAT9LMpyV5aa83XQKCjA3W/O3VdYcU5obxSdO8wFALAkq5ngGdUO5sL2B8zJMYBYz1V33RgVyuFzY3HEXSvr69BTqgnHeEsYE7Ei0E68E5jygUe40uN8lTlx7yrnr6KnlhPPsI2qMEebqC3Ad2OCBQniBUKWtclPqYDIg6m7i53TBsgCoYUD4gDvZoe55CY4qDjBbEAFLUNutOgW1okt+tI6nNEDFDQ9FmCuQm4tgTjQb3vtPuxEtyaEkJBO3YK+itFftYq2e6R1m1El0Be05MK2vFrwWwBFgLj6/UROA3kDoFXC9rxtBcMGTGMyAxwc4R/vxPkHoKjbIADwCbgdf/0BjIGGAd8HPB3HRG4WuCqombusehaHHdiFEbAAKozkjbdWZDpFU1rFV2eYvR6kSfswfru0XSqhcSVgn4e8PuPBn2wyOypqr1z4k6Tx2oA1RnJHqwNoBeFql920IVtsuoP9fqPkVwRWA2szmvmYoM+hDsrEGSmTXK96owr4zRCzW9Aj6YvAL00CpE77ZNZDb28wE8s3rooystXok26XrRov1DhkVD1xUVaVnpH9LoQdEaPpk+qJVOVqKiZTgfzAkikGL+75glNe1lkSXa+G64aHkSWHmqV7K2gdwZ1yEybrYsiUpznYF7Ja2ZqNYFBDWDr7JtAH2PgB2xQ7Ne5E7wPno/HUtL1g4hK1kVKVi1W5KflGv1OXtOTInYfa9DfFXT2oDN5gAFs7ZilyKODtVWDofR9ysZ62aI9clQ2KlK03U45HjEqgXlgCN0tQdYUdM7ZlQ39XjKvHRMVlofqNwMv1mJ2nRyCJImDc8dQMjNRIbL0kKJBUFTh6rzOObNOr+WA71m2Cs5Te/WGfpnlwACqiIFllC857CjhXAHsqzmE6+H5h461bZIbsaNuq6x6AfQZr2gMpc5a8gr/cjBXAH4ydVIzh78blgkMYDP7BuBir9incF275KKc/68NDfh4LcE4oJhw8uXa6pIu2mTlVkVuLvdnnq3pIMzXBP4W1v3NkNCDrZL9az3yXk2PK5Xd2wMpRm0It+e1Y6KBWSDDdLnVcWBNm2T/EYxJaX0ScwDXY5zQozecnJRfvlGdA1qla7XrknM1kHCQbwGzwDNAD90zKF87eTvFqMWDU/WHQ2IKZe90U6WHJ7AOOI0GPNgEzAOCUPoYyRVtzWz2/Q3l8BSgpgFcOXOX4MwAEoJMz2t6Upvkthm3UYK0l6A/ruaqVsJBw4ebukrEBYXXyzrUP2CBvxT0N17RCGYuQJMbS9erfG5DU+R17N7aCIIuuyvbHRJXNuFkFMeKytmf39iHMV0DW3R3WUYj30Y1yHKFa9x+XAPc09RL+7mUr59saZEV/45KqJjREgQgZUC4u11WvAbcV1nfKBQplMc1kZw1gCSjNtr0HcT1Wabkdc4HjeJ8pEzMH+NW9miCt7T/5pcNeo4JX0MVN2V1rGOr/6DoRKOh5IGOyP2+ow57/AeDfsAIWOUKGZE7+UcTFOzQc7uhX4bYiT3kdPRBQu8ow/XQjh383wCKhLw+M+a9U+VIQYMIl6AF0/+OnV7xXqh0pKDa2SxwuV92kG3GQdcADoBC2tbMzVUZ3sdQ7Wy26X2Y8tnBLpHY0NQmuW1FzTyBG4tH0WVFzdyo6EuCFEBju/J6pCHohUXN3Klwuk3vNEIHJ0G+d7yseNc7DpcWJElMLt/M0ksELmnkGHuUYBrotMocuaJPWzgPgLcLjJFc0cK+FPgh0MfgcBwSO6u0HTUQ2FGjuQDcleKs60VyJQhlhrxsy5fzes19wqjLBU4FPR5AoSTI862y8tUR1T4GJFm1pkgmI+i5oP4//21BticZtbEy1jEgNdYmT+8FBjmDD4TBOewnusW9m3dEIGhwBDY4/RIvbgK1KwtkB3QcBA3lBrXfdNN5Bc2U6lyDaxjuj7P0Fr/sYF6rJV8PDf1w0v2x5MGtICc3wtMAdln0TG4kWdqQK+yuJ5kObGuEZ5jYBcxsNFMcy09nVdMtRcwskDMFZ8hX44c0lhsS705hr40jTf4/peF859a3BhcAAAAASUVORK5CYII=" alt="backpack logo"/> -->
        
    </div>
    </router-link>

    <ul>
        <li><router-link :to="{name: 'home'}">Home</router-link></li>
        <!-- li><router-link :to="{name: 'grades'}">Grades</router-link></li -->
        <li><router-link :to="{name: 'account'}">Account</router-link></li>
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

body {
  margin: 0;
}
.nav-top {
  grid-area: navbar;
  padding: 0;
  margin: 0;
  width: auto;
}

.title-div {
    /* border: 1px solid red; */
    display: flex;
    align-items: center;
}

.title-div h2 {
    font-family: 'Schoolbell', cursive;
    /* color: #f4ff57; */
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
    /* background: #000b6c; */
    background-color: #04469e;
}
.nav-top ul {
  display: flex; /* 5 */
  list-style: none; /* 6 */
}

.nav-top li {
  padding-left: 1rem; /* 7! */
  font-size: 1.2rem;
}
.nav-top a {
  text-decoration: none;
  /* color: #f4ff57; */
  color: #f9dc59;
  font-family: Verdana, Geneva, Tahoma, sans-serif;
}

.nav-top li a:hover, .title-div h2:hover {
  /* box-shadow: inset 100px 0 0 0 #54b3d6; */
  /* color: white; */
  box-shadow: 0 8px 24px 0 rgb(16 39 112 / 20%);
  color: #f6f4f7;
}


</style>