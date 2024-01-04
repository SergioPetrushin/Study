<script>
export default {

}

</script>

<template>
  <v-btn
      fab
      color="primary"
      position="fixed"
      location="right bottom"
      class="btn"
      size="x-large"
      @click ="$emit('fab_action')"
  >
    <v-icon>mdi-plus</v-icon>
  </v-btn>
</template>

<style>
.btn{
  margin: 50px;
}
</style>