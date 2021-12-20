<template>
  <div class="app">
    <Header/>
    <Nuxt/>
  </div>
</template>

<script>
import Header from '~/components/header/Header.vue'

export default {
  components: {Header},
}
</script>

<style>
* {
  margin: 0;
  padding: 0;
}

.app {
  background-color: rgb(250, 250, 250);
}

html {
  font-family: "Segoe UI", sans-serif;
}
</style>
