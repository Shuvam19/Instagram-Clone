<template>
  <div class="individual-post">
    <post-user-details />
    <post-content />
    <post-description />
  </div>
</template>

<script>
import PostContent from './PostContent.vue'
import PostDescription from './PostDescription.vue'
import PostUserDetails from './PostUserDetails.vue'
export default {
  components: { PostContent, PostUserDetails, PostDescription },
}
</script>

<style>
.individual-post {
  width: 100%;
  height: 897px;
  background-color: #fff;
  border: 1px solid rgb(219, 219, 219);
}
</style>