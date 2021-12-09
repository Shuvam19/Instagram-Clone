export const state = () => ({
    isAuthenticated: false
});

export const getters = {
    isAuthenticated(state) {
        return state.isAuthenticated;
    }
};

export const mutations = {
    changeAuthenticatedUserStatus(state, status) {
        state.isAuthenticated = status
    }
}