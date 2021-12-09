<template>
  <input
    :type="type"
    :name="name"
    class="user-input"
    @input="$emit('update:modelValue', $event.target.value)"
    :placeholder="placeholder"
  />
</template>

<script>
export default {
  props: {
    type: String,
    name: String,
    placeholder: String,
    modelValue: String,
  },
}
</script>

<style>
.user-input {
  width: 100%;
  height: 35px;
  background: rgb(250, 250, 250);
  padding: 5px;
  border: 1px solid rgb(219, 219, 219);
  border-radius: 5px;
  font-size: 13px;
}
.user-input:focus {
  outline: none;
}
</style>