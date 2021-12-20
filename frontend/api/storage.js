export default axios => ({
  async uploadImage(file) {
    const config = {
      headers: {
        'content-type': 'multipart/form-data'
      }
    }
    const formData = new FormData();
    formData.append('file', file)
    const response = await axios.post("/storage/upload", formData, config)
    return response.data
  }
})
