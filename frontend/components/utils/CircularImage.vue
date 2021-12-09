<template>
  <img
    class="circular-image"
    :style="{
      width: width,
      height: height,
    }"
    :src="imgSrc"
  />
</template>
 
<script>
export default {
  props: {
    imgSrc: { type: String, default: '' },
    width: { type: String, default: '' },
    height: { type: String, default: '' },
  },
}
</script>

<style scoped>
.circular-image {
  border-radius: 50%;
}
</style>