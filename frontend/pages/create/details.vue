<template>
  <div class="main">
    <div class="header">
      <p>Back</p>
      <p>Add Details</p>
      <p @click="postContent">Share</p>
    </div>
    <div class="body">
      <img class="post-image" :src="$route.params.url">
      <!--      <div class="description">-->

      <!--      </div>-->
    </div>
  </div>
</template>

<script>
export default {
  beforeRouteEnter(to, from, next) {
    if (from.name !== 'create-select') {
      next("/")
    } else {
      next()
    }
  },
  methods: {
    postContent() {
      this.$api.user.createPost(this.$route.params.url).then(() => {
        this.$router.replace("/")
      })
    }
  }
}
</script>

<style scoped>
.main {
  width: fit-content;
  height: fit-content;
  display: flex;
  flex-direction: column;
}

.header {
  padding: 10px;
  display: flex;
  justify-content: space-between;
  font-size: 1.1rem;
  border-bottom: 1px solid rgb(219, 219, 219);
}

.body {
  display: flex;
  flex-direction: row;
}

.post-image {
  width: 406px;
  height: 406px;
  object-fit: contain;
}

.description {
  width: 100%;
  display: flex;
}
</style>
