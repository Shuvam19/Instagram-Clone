<template>
  <div class="signup-page">
    <div class="logo">
      <img class="instagram-image" src="~/assets/img/instagram.png" />
    </div>
    <form @submit.prevent="userLogin" class="signup-form">
      <div class="signup-input">
        <cumstom-input
          type="email"
          name="emailOrPhone"
          placeholder="Mobile Number or Email"
        />
        <cumstom-input type="text" name="fullName" placeholder="Full Name" />
        <cumstom-input type="text" name="username" placeholder="UserName" />
        <cumstom-input type="password" name="password" placeholder="Password" />
      </div>
      <button class="signup-button" type="submit">Log In</button>
    </form>
    <div class="signup">
      Have Account <nuxt-link to="/login"> Log In </nuxt-link>
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
    userLogin() {
      // this.$axios.
    },
  },
}
</script>

<style scoped>
.signup-page {
  width: 350px;
  margin: auto;
  padding: 80px 40px;
  vertical-align: centre;
  /* height: 350px; */
  background-color: #fff;
  border: 1px solid rgb(219, 219, 219);
  display: flex;
  flex-direction: column;
  align-items: center;
}

.signup-form {
  width: 100%;
  margin-top: 40px;
}

.signup-input {
  width: 100%;
  display: flex;
  flex-direction: column;
  justify-content: center;
  gap: 5px;
}

.signup-button {
  width: 100%;
  height: 30px;
  margin-top: 20px;
  background-color: #0095f6;
  color: #fff;
}
</style>