<script>
import userTypeController from "@/controllers/UserTypeController";

export default {

  data() {
    return {

      types : []

    }

  },


  mounted() {
    userTypeController.getAll()
        .then(response => this.types = response.data)
        .catch(error => alert("Произошла ошибка! " + error ))
  }


}
</script>

<template>


  <v-card
      class="card"
      variant="outlined"
      v-for="type in types"
  >

    <v-card-title>{{type.name}}</v-card-title>
    <div> Id : {{type.userTypeId}}</div>
    <v-card-actions>
      <v-btn>Редактировать</v-btn>
      <v-btn>Удалить</v-btn>

    </v-card-actions>

  </v-card>



</template>

<style>
.card{
  margin: 15px;
}
</style>