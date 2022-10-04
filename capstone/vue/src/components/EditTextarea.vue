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
      this.$emit("displayEditDescription", false);
    },
  },
};
</script>

<style>
</style>