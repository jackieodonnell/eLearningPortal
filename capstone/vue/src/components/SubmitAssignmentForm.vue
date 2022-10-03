<template>
  <div class="submit-assignment-container">
      <form action="submit-assignment" id="submit-assignment-form" v-on:submit.prevent="submitAssignment">
          <textarea name="submit-assignment-textarea" id="submit-assignment-textarea" cols="100" rows="25"></textarea>
          <br>
          <button id="submit-assignment-button">
              Submit
          </button>
          <button id="cancel-submission-button">
              Cancel
          </button>
      </form>
  </div>
</template>

<script>
export default {
    name: "submit-assignment-form",
    // props: ['displaySubmitForm'],
    data() {
        return {
            submission: ''
        }
    },
    methods: {
        submitAssignment() {
            // need to update grade status
            this.$emit('displaySubmitForm', false)
        }
    }

}
</script>

<style>
#submit-assignment-container button {
    text-align: right;
}

#submit-assignment-button, #cancel-submission-button {
    border: none;
    margin-right: 1%;
    box-shadow: 0 0 0 1px rgba(107, 107, 107, 0.185);
    border-radius: 4px;
    font-weight: bold;
    font-size: .8em;
    text-transform: uppercase;
    padding: 10px;
    padding-inline: 3%;
    background-color: #6ddf99;
    color: #040f31de;
    box-shadow: 0 8px 24px 0 rgb(255 235 167 / 20%);
    transition: all .3s ease-in-out;
}
#cancel-submission-button {
    background-color: #d66c6c;
    color: #040f31de;
}
#submit-assignment-button:hover{
    background-color: #18a04c;
    color: #fff8e2;
    box-shadow: 0 8px 24px 0 rgb(16 39 112 / 20%);
}
#cancel-submission-button:hover{
    background-color: #a71d1d;
    color: #fff8e2;
    box-shadow: 0 8px 24px 0 rgb(16 39 112 / 20%);
}


</style>