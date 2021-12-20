<template>
  <div class="post-and-stories">
    <!--    <Stories class="stories" />-->
    <Posts/>
  </div>
</template>

<script>
import Posts from './Posts.vue'
// import Stories from './Stories.vue'
export default {
  components: {
    Posts,
    // Stories
  },
}
</script>

<style scoped>


.post-and-stories {
  height: fit-content;
  width: 614px;
  display: flex;
  flex-direction: column;
  gap: 24px;
}

.stories {
  width: 100%;
  height: 118px;
  padding: 16px 20px;
  border: 1px solid rgb(219, 219, 219);
  display: flex;
  box-sizing: border-box;
  flex-direction: row;
  background-color: #fff;
  border-radius: 3px;
  overflow-x: auto;
  -ms-overflow-style: none;
  scrollbar-width: none;
}

.stories::-webkit-scrollbar {
  display: none;
}
</style>
