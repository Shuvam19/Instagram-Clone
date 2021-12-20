<template>
  <div class="posts">
    <template v-for="indPost in allPosts">
      <div class="individual-post" :key="indPost.productUrl">
        <post-user-details/>
        <post-content :img-url="indPost.productUrl"/>
        <post-description/>
      </div>
    </template>
  </div>
</template>

<script>
import {mapGetters} from 'vuex'
import PostContent from "~/components/postsandstories/post/PostContent";
import PostUserDetails from "~/components/postsandstories/post/PostUserDetails";
import PostDescription from "~/components/postsandstories/post/PostDescription";

export default {
  components: {PostContent, PostUserDetails, PostDescription},
  computed: {
    ...mapGetters(['allPosts']),
  }
}
</script>

<style scoped>
.posts {
  height: fit-content;
  display: flex;
  flex-direction: column;
  border-radius: 3px;
  gap: 24px;
}

.individual-post {
  width: 100%;
  /*height: 897px;*/
  padding-bottom: 14px;
  background-color: #fff;
  border: 1px solid rgb(219, 219, 219);
}
</style>
