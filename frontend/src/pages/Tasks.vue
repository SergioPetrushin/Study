<script>

import MySnackbar from "@/components/MySnackbar.vue";
import ItemViewer from "@/components/ItemViewer.vue";
import TasksController from "@/controllers/TasksController";

export default {
    components: {MySnackbar, ItemViewer},

    data() {
        return {

            tasks : [],

            snackbar: false,
            snackbarText: '',

        }
    },

    mounted() {
        TasksController.getAll()
            .then(response => this.tasks = response.data)
            .catch(error => alert("Произошла ошибка при загрузке планов: " + error.message))
    }

}
</script>

<template>
  <h1>Тут будет страничка заданий!</h1>

    <item-viewer
            :item = "item"
            :id="item.task.id"
            v-for="item in tasks" />
</template>

<style>

</style>