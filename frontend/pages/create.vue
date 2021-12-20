<template>
  <custom-dialog v-show="dialogVisibility" @close="closeDialog">
    <NuxtChild/>
  </custom-dialog>
</template>

<script>
import CustomDialog from "~/components/utils/CustomDialog";

export default {
  components: {CustomDialog},
  data() {
    return {
      dialogVisibility: true,
    }
  },
  methods: {
    closeDialog() {
      this.$router.back()
    }
  }
}
</script>
