<script>

import eduPlansController from "@/controllers/EduPlansController";
import ItemViewer from "@/components/ItemViewer.vue";
import MySnackbar from "@/components/MySnackbar.vue";

export default {
  components: {MySnackbar, ItemViewer},

  data() {
    return {

      plans : [],

      snackbar: false,
      snackbarText: '',

    }
  },

  mounted() {

    eduPlansController.getAll()
        .then(response => this.plans = response.data)
        .catch(error => alert("Произошла ошибка при загрузке планов: " + error.message))

  },

  methods : {


    deletePlan(id){

      eduPlansController.deletePlan(id)
          .then(response => {
            this.plans = this.plans.filter( plan => plan.planId !== id)
            this.snackbarText = response.data
            this.snackbar = true
          })
          .catch(error => alert("Произошла ошибка при удалении плана: " + error.message))

    },

    closeSnackBar(){
      this.snackbar = false
    }


  }


}
</script>

<template>

  <item-viewer
    :item = "item"
    :id = "item.planId"
    v-on:item_delete = "deletePlan($event)"
    v-for="item in plans" />


  <my-snackbar
      :text=snackbarText
      :is-show=snackbar
      v-on:snackbar-close=closeSnackBar()></my-snackbar>

</template>

<style>

</style>