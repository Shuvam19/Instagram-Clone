<template>
  <div class="main">
    <div class="user-profile">
      <header class="user-profile-info">
        <div class="user-profile-image">
          <button class="profile-image">
            <img class="image-src" :src="profileInfo.imageUrl">
          </button>
        </div>
        <div class="user-profile-information">
          <div class="username-section">
            <p class="username">{{ profileInfo.username }}</p>
            <template v-if="profileInfo.username != $auth.user.username">
              <button class="follow-button" type="button"
                      @click.prevent="profileInfo.isFollowing ? unfollowUser() : followUser()">
                {{ profileInfo.isFollowing ? 'Unfollow' : 'Follow' }}
              </button>
            </template>
          </div>
          <div class="follower-following">
            <p>{{ profileInfo.noOfPost }} Posts</p>
            <p>{{ profileInfo.noOfFollowers }} Followers</p>
            <p>{{ profileInfo.noOfFollowing }} Following</p>
          </div>
          <!--          TODO Description-->
          <!--          <div class="user-profile-desc">-->
          <!--            &lt;!&ndash;            {{ this.$route.params.userId }}&ndash;&gt;-->
          <!--          </div>-->
        </div>
      </header>
      <div class="user-posts">
        <user-posts :list-of-post="profileInfo.postList"/>
      </div>
    </div>
  </div>
</template>

<script>
import UserPosts from "~/components/userprofilecomponents/UserPosts";

export default {
  components: {UserPosts},
  async asyncData({params, $api}) {
    const profileInfo = await $api.user.getUser(params.userId)
    return {
      profileInfo,
    }
  },
  methods: {
    async followUser() {
      const response = await this.$api.user.followUser(this.$route.params.userId)
      console.log(response)
      this.$nuxt.refresh()
    },
    async unfollowUser() {
      await this.$api.user.unfollowUser(this.$route.params.userId)
      this.$nuxt.refresh()
    }
  },
}
</script>

<style scoped>
.main {
  padding: 30px 20px 0;
}

.user-profile {
  max-width: 935px;
  margin: auto;
  display: flex;
  flex-direction: column;
}

.user-profile-info {
  margin-bottom: 40px;
  display: flex;
  flex-direction: row;
  justify-content: space-evenly;
}

.user-profile-image {
  flex-basis: 0;
  flex-grow: 1;
  margin-right: 40px;
}

.profile-image {
  width: 150px;
  height: 150px;
  margin: 0 auto;
}

.image-src {
  width: 100%;
  border-radius: 50%;
}

.user-profile-information {
  flex-basis: 30px;
  flex-grow: 2;
}

.follower-following {
  margin-top: 15px;
  display: flex;
  flex-direction: row;
  gap: 30px;
}

.username-section {
  display: flex;
  align-content: center;
  gap: 20px
}

.username {
  font-size: 2rem;
}

.follow-button {
  border-radius: 10px;
  background-color: #0095f6;
  color: #ffffff;
  padding: 0 15px;
  margin: 5px 0;
}
</style>
