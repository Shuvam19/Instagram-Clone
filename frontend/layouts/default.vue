<template>
  <div class="app">
    <Header />
    <Nuxt />
  </div>
</template>

<script>
import Header from '~/components/header/Header.vue'
export default {
  components: { Header },
}
</script>

<style scoped>
* {
  margin: 0px;
  padding: 0px;
}
.app {
  background-color: rgb(250, 250, 250);
}
</style>