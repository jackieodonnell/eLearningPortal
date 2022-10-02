<template>
  <div class="footer">
      <h3 id="company-name">Incrementum</h3>
      <img id="backpack-logo" src="../../public/images/backpack.png" alt="backpack-logo" />
      <p id="copyright-info">Copyright © 2022 Incrementum, Inc.</p> 
      <p id="privacy-link">Privacy Policy</p>
  </div>
</template>

<script>
export default {
    name: "footer-section",

}
</script>

<style>
@import url('https://fonts.googleapis.com/css2?family=Schoolbell&display=swap');

.footer {
  padding-top: 15px;
  font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
  color: #f6f4f7;
  background-color: #001a33;
  text-align: center;
  padding-bottom: 10px;
}

#company-name {

  font-family: 'Schoolbell', cursive;
  margin-top: 0px;
  margin-bottom: 0px;
}

#backpack-logo {
  max-height: 25px;
}

#copyright-info {
  margin-top: 0px;  
  border-bottom: 1px solid gray;
  padding-bottom: 5px;
  margin-left: 30%;
  margin-right: 30%;
  font-size: 0.8rem;
  color: rgb(182, 182, 182);
}

#privacy-link {
  margin-top: 0px;
  text-decoration: underline;
  font-size: 0.9rem;
  font-weight: 400;
  color: rgb(182, 182, 182);
}
</style>