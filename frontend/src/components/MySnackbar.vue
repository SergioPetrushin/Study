<script>

export default {

  props : {

    text : {
      type : String,
      require : true
    },

    isShow : {

      type : Boolean,
      require : true

    }


  },

    computed:{
      show(){
          return this.isShow
      }},

  data(){
    return{


    }
  }


}

</script>

<template>
  <v-snackbar
      v-model=show
  >
    {{text}}

    <template v-slot:actions>
      <v-btn
          color="pink"
          variant="text"
          @click="$emit('snackbar-close')"
      >
        Close
      </v-btn>
    </template>
  </v-snackbar>
</template>

<style scoped>

</style>