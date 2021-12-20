export default {
  // Global page headers: https://go.nuxtjs.dev/config-head
  head: {
    title: 'Instagram Clone',
    htmlAttrs: {
      lang: 'en'
    },
    meta: [
      {charset: 'utf-8'},
      {name: 'viewport', content: 'width=device-width, initial-scale=1'},
      {hid: 'description', name: 'description', content: ''},
      {name: 'format-detection', content: 'telephone=no'}
    ],
    link: [
      {rel: 'icon', type: 'image/x-icon', href: '/favicon.ico'}
    ]
  },

  // Global CSS: https://go.nuxtjs.dev/config-css
  css: [],

  // Plugins to run before rendering page: https://go.nuxtjs.dev/config-plugins
  plugins: [
    {src: '~/plugins/persistedState.js', mode: 'client'},
    {src: "@/plugins/api.js"}
  ],

  // Auto import components: https://go.nuxtjs.dev/config-components
  components: true,

  // Modules for dev and build (recommended): https://go.nuxtjs.dev/config-modules
  buildModules: [
    // https://go.nuxtjs.dev/eslint
    '@nuxtjs/eslint-module',
    '@nuxtjs/vuetify',
  ],

  // Modules: https://go.nuxtjs.dev/config-modules
  modules: [
    // https://go.nuxtjs.dev/axios
    '@nuxtjs/axios',
    '@nuxtjs/auth-next',
  ],

  // Axios module configuration: https://go.nuxtjs.dev/config-axios
  axios: {
    baseURL: process.env.BASE_URL,
    common: {
      'Accept': 'application/json, text/plain, */*',
    },
  },

  // Build Configuration: https://go.nuxtjs.dev/config-build
  build: {},

  router: {
    middleware: ['auth']
  },

  auth: {
    redirect: {
      // login: '/login',
      logout: '/login',
      home: '/'
    },
    strategies: {
      local: {
        token: {
          property: 'token',
          global: true,
          // required: true,
          // type: 'Bearer'
        },
        user: {
          property: 'user',
          autoFetch: true
        },
        endpoints: {
          login: {url: '/auth/login', method: 'post'},
          user: {url: '/auth/user', method: 'post', propertyName: ''},
          logout: false
        }
      }
    }
  },
}
