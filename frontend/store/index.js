// State
export const state = () => ({
  allPosts: []
})

// Getters
export const getters = {
  allPosts: state => state.allPosts
};

// actions
export const actions = {
  async addPostContent({commit}) {
    const postInfo = await this.$api.user.getAllFollowingPost();
    commit('addAllPost', postInfo)
  }
};

// mutations
export const mutations = {
  addAllPost(state, postInfo) {
    postInfo.map((el) => state.allPosts.push(el))
  },
  delete(state) {
    state.allPosts = []
  }
}
