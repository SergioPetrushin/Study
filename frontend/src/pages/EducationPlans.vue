<script>

import eduPlansController from "@/controllers/EduPlansController";
import ItemViewer from "@/components/ItemViewer.vue";

export default {
  components: {ItemViewer},

  data() {
    return {

      plans : []

    }
  },

  mounted() {

    eduPlansController.getAll()
        .then(response => this.plans = response.data)
        .catch(error => alert("Произошла ошибка при загрузке планов: " + error.message))

  }


}
</script>

<template>

  <item-viewer
    :item = "item"
    :id = "item.planId"
    v-for="item in plans" />

</template>

<style>

</style>