<template>
  <div class="navigation-list">
    <v-icon size="30">{{ homeIcon }}</v-icon>
    <nuxt-link to="/direct/inbox">
      <v-icon size="30">{{ messageIcon }}</v-icon>
    </nuxt-link>
    <nuxt-link to="/create/select">
      <v-icon size="30">{{ plusIcon }}</v-icon>
    </nuxt-link>
    <nuxt-link to="/explore/people">
      <v-icon size="30">{{ compassIcon }}</v-icon>
    </nuxt-link>
    <v-icon size="30">{{ heartIcon }}</v-icon>
    <circular-image :height="'50%'" :imgSrc="'https://picsum.photos/200'" />
  </div>
</template>

<script>
import {
  mdiCompassOutline,
  mdiHeartOutline,
  mdiHomeOutline,
  mdiMessageTextOutline,
  mdiPlusCircleOutline,
} from '@mdi/js'
import CircularImage from '../utils/CircularImage.vue'
export default {
  components: { CircularImage },
  data() {
    return {
      homeIcon: mdiHomeOutline,
      messageIcon: mdiMessageTextOutline,
      plusIcon: mdiPlusCircleOutline,
      compassIcon: mdiCompassOutline,
      heartIcon: mdiHeartOutline,
    }
  },
}
</script>

<style>
.navigation-list {
  display: flex;
  height: 100%;
  align-items: center;
  gap: 20px;
}
</style>