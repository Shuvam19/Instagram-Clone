<template>
  <div class="container">
    <post-and-stories />
    <div class="right-container"></div>
  </div>
</template>

<script>
import PostAndStories from '~/components/postsandstories/PostAndStories.vue'

export default {
  components: {PostAndStories},
  mounted() {
    this.$store.dispatch('addPostContent');
  },
}
</script>

<style scoped>
.container {
  max-width: 935px;
  height: auto;
  margin: 30px auto auto;
  display: flex;
  flex-direction: row;
  gap: 28px;
}

.right-container {
  width: 293px;
  height: 80vh;
  border: 1px solid black;
}

@media screen and (max-width: 767px) {
  .container {
    max-width: 90vw;
  }

  .left-container {
    width: 100%;
  }
}

@media screen and (max-width: 992px) {
  .container {
    justify-content: center;
  }

  .right-container {
    display: none;
  }
}
</style>
