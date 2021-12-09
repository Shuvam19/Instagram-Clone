<template>
  <div>
    <!-- <template v-for="(story, index) in storiesList">
      <h6 :key="index">{{ story }}</h6>
    </template> -->
    <Story />
    <Story />
    <Story />
    <Story />
    <Story />
    <Story />
    <Story />
    <Story />
    <Story />
    <Story />
    <Story />
    <Story />
    <Story />
    <Story />
    <Story />
    <Story />
  </div>
</template>

<script>
import Story from './Story.vue'
export default {
  components: { Story },
  data() {
    return {
      storiesList: [
        'Shuvam',
        'Shuvam',
        'Shuvam',
        'Shuvam',
        'Shuvam',
        'Shuvam',
        'Shuvam',
        'Shuvam',
        'Shuvam',
        'Shuvam',
        'Shuvam',
        'Shuvam',
        'Shuvam',
      ],
    }
  },
}
</script>

<style>
</style>