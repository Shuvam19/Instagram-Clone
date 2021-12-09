<template>
  <div class="user-details">
    <div class="user-profile-image">
      <circular-image
        class="user-image"
        :height="'60%'"
        :img-src="'https://picsum.photos/200'"
      />
      <p class="user-name">username</p>
    </div>
    <v-icon class="dots-horizontal">{{ dotsHorizontal }} </v-icon>
  </div>
</template>

<script>
import { mdiDotsHorizontal } from '@mdi/js'
import CircularImage from '~/components/utils/CircularImage.vue'
export default {
  components: { CircularImage },
  data() {
    return {
      dotsHorizontal: mdiDotsHorizontal,
    }
  },
}
</script>

<style>
.user-details {
  height: 60px;
  display: flex;
  justify-content: space-between;
  align-items: center;
  padding: 0px 14px;
  border-bottom: 0.5px solid rgb(219, 219, 219);
}

.user-profile-image {
  height: 100%;
  display: flex;
  align-items: center;
}

.user-name {
  margin-left: 14px;
}

.dots-horizontal {
  float: right;
}
</style>