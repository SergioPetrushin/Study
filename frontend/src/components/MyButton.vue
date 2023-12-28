<template>

  <v-btn
      class = "btn"
      rounded="xl"
      variant="outlined"
      icon="mdi-twitter"
      size="x-large"
      @click=showMessage() >
    <v-icon>mdi-twitter</v-icon>
  </v-btn>

</template>

<script>

export default {

  methods : {

    showMessage(){
      alert('Hello world!!!!')
    }


  }

}

</script>

<style>
.btn{

  margin: 50px;

}
</style>