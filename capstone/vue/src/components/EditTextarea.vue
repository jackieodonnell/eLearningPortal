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
  border: none;
  margin-right: 1%;
  border-radius: 4px;
  font-weight: bold;
  font-size: 0.8em;
  text-transform: uppercase;
  padding: 10px;
  padding-inline: 3%;
  background-color: #6ddf99;
  color: #040f31de;
  box-shadow: 0 1px 4px 1px rgba(39, 39, 39, 0.171);
  transition: all 0.3s ease-in-out;
  margin-bottom: 20px;
}
#cancel-edit-textarea {
  background-color: #d66c6c;
  color: #040f31de;
}

#save-edit-textarea:hover {
  background-color: #18a04c;
  color: #fff8e2;
  box-shadow: 0 8px 24px 0 rgb(16 39 112 / 20%);
}
#cancel-edit-textarea:hover {
  background-color: #a71d1d;
  color: #fff8e2;
  box-shadow: 0 8px 24px 0 rgb(16 39 112 / 20%);
}
</style>