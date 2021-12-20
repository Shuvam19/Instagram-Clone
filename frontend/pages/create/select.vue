<template>
  <div class="main">
    <div class="header">
      Create New Post
    </div>
    <div class="body">
      <label for="file-upload" class="upload-file-button">
        Select From Computer
      </label>
      <input id="file-upload" type="file" accept="image/*" @change="uploadFile">
    </div>
  </div>
</template>

<script>
export default {
  methods: {
    uploadFile(event) {
      this.$api.storage.uploadImage(event.target.files[0]).then((fileUrl) => {
        this.$router.replace({name: "create-details", params: {url: fileUrl.url}})
      })
    }
  }
}
</script>

<style scoped>
.main {
  width: 400px;
  height: 400px;
  display: flex;
  flex-direction: column;
}

.header {
  padding: 10px;
  display: flex;
  justify-content: center;
  font-size: 1.1rem;
  border-bottom: 1px solid rgb(219, 219, 219);
}

.body {
  height: 100%;
  display: flex;
  justify-content: center;
  align-items: center;
  flex-direction: column;
}

#file-upload {
  display: none;
}

.upload-file-button {
  border-radius: 5px;
  background: #0095f6;
  padding: 7px;
  color: white;
  font-size: 0.8rem;
}
</style>
