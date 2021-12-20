<template>
  <div class="navigation-list">
    <v-icon size="30">{{ homeIcon }}</v-icon>
    <!--    <nuxt-link to="/direct/inbox">-->
    <!--      <v-icon size="30">{{ messageIcon }}</v-icon>-->
    <!--    </nuxt-link>-->
    <nuxt-link to="/create/select">
      <v-icon size="30">{{ plusIcon }}</v-icon>
    </nuxt-link>
    <nuxt-link to="/explore/">
      <v-icon size="30">{{ compassIcon }}</v-icon>
    </nuxt-link>
    <v-icon size="30" @click="logoutUser">{{ logoutIcon }}</v-icon>
    <nuxt-link style="height: 50%" :to="`/${$auth.user.username}`">
      <circular-image :height="'100%'" :img-src="'https://picsum.photos/200'"/>
    </nuxt-link>
  </div>
</template>

<script>
import {
  mdiCompassOutline,
  mdiHomeOutline,
  mdiMessageTextOutline,
  mdiPlusCircleOutline,
  mdiLogout,
} from '@mdi/js'
import CircularImage from '../utils/CircularImage.vue'

export default {
  components: {CircularImage},
  methods: {
    logoutUser() {
      this.$store.commit('delete')
      this.$auth.logout()
    }
  },
  data() {
    return {
      homeIcon: mdiHomeOutline,
      messageIcon: mdiMessageTextOutline,
      plusIcon: mdiPlusCircleOutline,
      compassIcon: mdiCompassOutline,
      logoutIcon: mdiLogout,
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
