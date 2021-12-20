<template>
  <div class="explore-people">
    <user-posts :list-of-post="allPosts"/>
  </div>
</template>

<script>
import UserPosts from "~/components/userprofilecomponents/UserPosts";

export default {
  components: {UserPosts},
  async asyncData({$api}) {
    const allPosts = await $api.explore.getRandom20Posts();
    return {
      allPosts
    }
  }
}
</script>

<style scoped>
.explore-people {

}

@media screen and (min-width: 767px) {

}
</style>
