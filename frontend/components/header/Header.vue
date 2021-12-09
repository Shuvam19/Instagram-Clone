<template>
  <div class="header-section">
    <!-- Left Header  -->
    <header-left />
    <!-- Middle Header -->
    <header-middle />
    <!-- Right Header -->
    <header-right />
  </div>
</template>

<script>
import HeaderLeft from './HeaderLeft.vue'
import HeaderMiddle from './HeaderMiddle.vue'
import HeaderRight from './HeaderRight.vue'
export default {
  components: { HeaderLeft, HeaderMiddle, HeaderRight },
}
</script>

<style scoped>
.header-section {
  height: 54px;
  background-color: #fff;
  border-bottom: 0.5px solid rgb(219, 219, 219);
  display: flex;
  flex-direction: row;
  justify-content: space-evenly;
  align-items: center;
}
</style>
