<template>
  <div class="modal-backdrop">
    <div class="modal">
      <slot/>
    </div>
    <div class="close" @click="close">
      <v-icon class="v-icon" size="30">{{ closeIcon }}</v-icon>
    </div>
  </div>
</template>

<script>
import {mdiClose} from '@mdi/js'

export default {
  data() {
    return {
      closeIcon: mdiClose
    }
  },
  methods: {
    close() {
      this.$emit('close');
    },
  },
};
</script>

<style scoped>
.modal-backdrop {
  position: fixed;
  top: 0;
  bottom: 0;
  left: 0;
  right: 0;
  background-color: rgba(0, 0, 0, 0.8);
  display: flex;
  justify-content: center;
  align-items: center;
}

.modal {
  background: #FFFFFF;
  overflow-x: auto;
  display: flex;
  flex-direction: column;
  border-radius: 25px;
}

.close {
  position: fixed;
  top: 10px;
  right: 10px;
}

.v-icon {
  color: #ffffff;
}
</style>
