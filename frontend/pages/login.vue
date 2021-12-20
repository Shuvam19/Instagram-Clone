<template>
  <div class="login-page">
    <div class="logo">
      <img class="instagram-image" src="~/assets/img/instagram.png" />
    </div>
    <form class="login-form" @submit.prevent="userLogin">
      <div class="login-input">
        <cumstom-input
          v-model="username"
          type="text"
          name="username"
          placeholder="User Name"
        />
        <cumstom-input
          v-model="password"
          type="password"
          name="password"
          placeholder="Password"
        />
      </div>
      <button class="login-button" type="submit">Log In</button>
    </form>
    <div class="signup">
      Don't Have Account <nuxt-link to="/signup"> Sign Up </nuxt-link>
    </div>
  </div>
</template>

<script>
import CumstomInput from '~/components/utils/CumstomInput.vue'
export default {
  components: { CumstomInput },
  layout(context) {
    return 'empty'
  },
  data() {
    return {
      username: '',
      password: '',
    }
  },
  methods: {
    async userLogin() {
      try {
        await this.$auth.loginWith('local', {
          data: {
            username: this.username,
            password: this.password,
          },
        })
      } catch (err) {
      }
    },
  },
}
</script>

<style scoped>
.login-page {
  width: 350px;
  margin: auto;
  padding: 80px 40px;
  vertical-align: center;
  /* height: 350px; */
  background-color: #fff;
  border: 1px solid rgb(219, 219, 219);
  display: flex;
  flex-direction: column;
  align-items: center;
}

.login-form {
  width: 100%;
  margin-top: 40px;
}

.login-input {
  width: 100%;
  display: flex;
  flex-direction: column;
  justify-content: center;
  gap: 5px;
}

.user-input {
  width: 100%;
  height: 35px;
  background: rgb(250, 250, 250);
  padding: 5px;
  border: 1px solid rgb(219, 219, 219);
  border-radius: 5px;
  font-size: 13px;
}

.login-button {
  width: 100%;
  height: 30px;
  margin-top: 20px;
  background-color: #0095f6;
  color: #fff;
}
</style>
