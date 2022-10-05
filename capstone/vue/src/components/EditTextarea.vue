<template>
  <div class="edit-textarea-container">
    <textarea
      v-model="inputText"
      id="edit-textarea"
      cols="100"
      rows="10"
      v-bind:placeholder="currentText"
    ></textarea>
    <button id="save-edit-textarea" v-on:click="saveInput">Save</button>
    <button id="cancel-edit-textarea" v-on:click.prevent="cancelInput">
      Cancel
    </button>
  </div>
</template>

<script>
export default {
  name: "edit-textarea",
  props: ["currentText"],
  data() {
    return {
      inputText: "",
    };
  },
  created() {
    this.inputText = this.currentText;
  },
  methods: {
    saveInput() {
      console.log("SAVE TEST");
      // this.$store.commit("SET_EDIT_DESCRIPTION", this.inputText);
      this.$emit("save-input-text", this.inputText);
    },
    cancelInput() {
      this.$emit("save-input-text", this.currentText);
    },
  },
};
</script>

<style>
#edit-textarea {
  width: 100%;
  height: 150px;
  padding: 12px 20px;
  box-sizing: border-box;
  border: 2px solid #ccc;
  border-radius: 4px;
  background-color: #f8f8f8;
  font-size: 16px;
  font-family: "Segoe UI", Tahoma, Geneva, Verdana, sans-serif;
  resize: none;
}

#save-edit-textarea,
#cancel-edit-textarea {
  width: 10%;
  height: fit-content;
  font-size: 1rem;
  border-radius: 8px;
  background-color: rgb(73, 109, 226);
  border: none;
  color: white;
  padding: 1%;
  text-decoration: none;
  margin: 4px 4px;
  cursor: pointer;
}

#save-edit-textarea:hover {
  background-color: #04aa6d;
}
#cancel-edit-textarea:hover {
  background-color: #eb453f;
}
</style>