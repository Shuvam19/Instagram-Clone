<template>
  <div class="individual-story">
    <circular-image 
    :width="'80%'"
    :imgSrc="'https://picsum.photos/200'" />
    <p class="story-user-name">shuvam_kumar</p>
  </div>
</template>

<script>
import CircularImage from '../utils/CircularImage.vue'
export default {
  components: { CircularImage },
}
</script>

<style scoped>
.individual-story {
  height: 100%;
  display: flex;
  align-items: center;
  flex-direction: column;
  aspect-ratio: 1 / 1;
}

.story-user-name {
  width: 100%;
  overflow: hidden;
  white-space: nowrap;
  text-overflow: ellipsis;
  text-align: center;
}
</style>