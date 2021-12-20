export default axios => ({
  async getUser(userId) {
    const response = await axios.get(`/user/${userId}`)
    return response.data
  },
  async followUser(userId) {
    await axios.get(`/user/follow/${userId}`)
  },
  async unfollowUser(userId) {
    await axios.get(`/user/unfollow/${userId}`)
  },
  async getAllFollowers(userId) {
    await axios.get(`/user/followers`)
  },
  async createPost(productUrl) {
    await axios.post('/create/post', {
      productUrl
    })
  },
  async getAllFollowingPost() {
    const response = await axios.get('/user/followingPosts');
    return response.data
  }
})
