<template>
  <div class="all-posts">
    <individual-post v-for="post in listOfPost" :key="post.productUrl">
      <img class="image-url" :src="post.productUrl">
    </individual-post>
  </div>
</template>

<script>
import IndividualPost from "~/components/userprofilecomponents/IndividualPost";

export default {
  components: {IndividualPost},
  props: {
    listOfPost: {
      type: Array,
      default: () => [],
    }
  },
}
</script>

<style scoped>
.all-posts {
  display: flex;
  gap: 15px;
  flex-wrap: wrap;
  justify-content: center;
}
.image-url {
  width: 100%;
  height: 100%;
  object-fit: contain;
}
</style>
