<template>
  <div class="post-content">
    <img class="image-content" :src="imgUrl" alt="Image Not available">
  </div>
</template>

<script>
export default {
  props: {
    imgUrl: {
      type: String,
      default: "",
    }
  }
}
</script>

<style scoped>
.post-content {
  width: 614px;
  height: 614px;
}

.image-content {
  width: 100%;
  height: 100%;
  object-fit: contain;
}
</style>
