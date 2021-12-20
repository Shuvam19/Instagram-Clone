<template>
  <input
    :type="type"
    :name="name"
    class="user-input"
    :placeholder="placeholder"
    :value="modelValue"
    @input="$emit('input', $event.target.value)"
  />
</template>

<script>
export default {
  props: {
    type: {
      type: String,
      default: 'text',
    },
    name: {
      type : String,
      default: 'default',
    },
    placeholder: {
      type: String,
      default: 'Enter Anything',
    },
    modelValue: {
      type : String,
      default: '',
    },
  },
  // props : ['type','name','placeholder','modelValue']
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