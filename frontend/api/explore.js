export default axios => ({
  async getRandom20Posts() {
    const response = await axios.get("/explore/posts")
    return response.data
  }
})
