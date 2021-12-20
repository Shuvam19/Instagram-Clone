<template>
  <div class="signup-page">
    <div class="logo">
      <img class="instagram-image" src="~/assets/img/instagram.png" />
    </div>
    <form class="signup-form" @submit.prevent="userSignUp">
      <div class="signup-input">
        <cumstom-input
          v-model="email"
          type="text"
          name="emailOrPhone"
          placeholder="Mobile Number or Email"
        />
        <cumstom-input
          v-model="fullName"
          type="text"
          name="fullName"
          placeholder="Full Name"
        />
        <cumstom-input
          v-model="username"
          type="text"
          name="username"
          placeholder="UserName"
        />
        <cumstom-input
          v-model="password"
          type="password"
          name="password"
          placeholder="Password"
        />
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
  auth: false,
  components: { CumstomInput },
  layout(context) {
    return 'empty'
  },
  data() {
    return {
      email: '',
      fullName: '',
      username: '',
      password: '',
    }
  },
  methods: {
    isEmail(email) {
      return String(email)
        .toLowerCase()
        .match(
          /^(([^<>()[\]\\.,;:\s@"]+(\.[^<>()[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/
        )
    },
    async userSignUp() {
      let emailId = ''
      let mobileNo = 0
      const firstName = this.fullName.split(' ')[0]
      const lastName = this.fullName.split(' ')[1]
      if (this.email.length === 10 && !isNaN(this.email)) {
        mobileNo = parseInt(this.email)
      } else if (this.isEmail(this.email)) {
        emailId = this.email
      } else {
        console.log('Email Or Phone Entered Is Wrong')
      }
      await this.$axios.post('/auth/sign-up', {
        username: this.username,
        password: this.password,
        firstName,
        lastName,
        mobileNo,
        email: emailId,
      })
      await this.$auth.loginWith('local', {
        data: {
          username: this.username,
          password: this.password,
        },
      })
      this.$router.getRoutes().pop()
      await this.$router.push('/')
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
