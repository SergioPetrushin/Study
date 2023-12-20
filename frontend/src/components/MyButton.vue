<template>

  <v-btn @click=showMessage() >Кнопка</v-btn>

</template>

<script>

export default {

  methods : {

    showMessage(){
      alert('Hello world!!!')
    }


  }

}

</script>

<style>

</style>