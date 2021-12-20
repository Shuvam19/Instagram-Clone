<template>
  <div class="post-description">
    <div class="like-share-save">
      <div class="like-comment">
        <v-icon size="28">{{ heartOutline }}</v-icon>
        <v-icon size="28">{{ commentOutline }}</v-icon>
        <v-icon size="28" class="sendOutline">{{ sendOutline }}</v-icon>
      </div>
      <div class="save">
        <v-icon size="28">{{ bookmarkOutline }}</v-icon>
      </div>
    </div>
    <div class="likes-comments">
      <p>21000 Likes</p>

    </div>
    <div class="comment">

    </div>
  </div>
</template>

<script>
import {
  mdiBookmarkOutline,
  mdiHeartOutline,
  mdiMessageReplyOutline,
  mdiSendOutline,
} from '@mdi/js'

export default {
  data() {
    return {
      heartOutline: mdiHeartOutline,
      commentOutline: mdiMessageReplyOutline,
      sendOutline: mdiSendOutline,
      bookmarkOutline: mdiBookmarkOutline,
    }
  },
}
</script>

<style scoped>
.like-share-save {
  display: flex;
  justify-content: space-between;
  padding: 10px;
}

.like-comment {
  display: flex;
  justify-content: space-evenly;
  gap: 15px;
}

.sendOutline {
  transform: rotate(-50deg) translateX(5px) translateY(1px) !important;
}

.likes-comments {
  padding: 0 10px;
}
</style>
