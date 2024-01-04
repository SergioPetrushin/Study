<script>
import userTypeController from "@/controllers/UserTypeController";
import ItemViewer from "@/components/ItemViewer.vue";
import MySnackbar from "@/components/MySnackbar.vue";
import Fab from "@/components/Fab.vue";

export default {
  components: {Fab, MySnackbar, ItemViewer},

  data() {
    return {

      types : [],
      snackbar : false,
      snackbarText : '',
      isEditDialog : false,

      type : {
        id : '',
        name : '',
        description : ''
      }

    }

  },


  mounted() {

    userTypeController.getAll()
        .then(response => this.types = response.data)
        .catch(error => alert("Произошла ошибка! " + error ))
  },

  methods : {

    deleteUserType(id){

      userTypeController.deleteUserType(id)
          .then(response => {
            this.snackbarText = response.data
            this.types = this.types.filter( t => t.id !== id)
            this.snackbar = true
          })
          .catch(error => {
            this.snackbarText = error.data.message
            this.snackbar = true
          })

    },

    closeSnackBar(){
      this.snackbar = false
    },

    startEditDialog(type){

      this.type.id = type.id
      this.type.name = type.name
      this.type.description = type.description

      this.isEditDialog = true

    },

    finishEditDialog(){

      userTypeController.edit(this.type)
          .then(response => {

            this.types = this.types.filter(t => t.id !== this.type.id)
            this.types.push(response.data)

          })
      this.isEditDialog = false

    }


  }


}
</script>

<template>


<item-viewer
    :item = "item"
    v-on:item_edit=startEditDialog($event)
    v-on:item_delete=deleteUserType($event)
    v-for = "item in types"></item-viewer>


<my-snackbar :text = snackbarText :is-show = snackbar v-on:snackbar_close = closeSnackBar()></my-snackbar>




  <v-row justify="center">
    <v-dialog
        v-model="isEditDialog"
        persistent
        width="1024"
    >
      <v-card>
        <v-card-title>
          <span class="text-h5">Редактирование типа пользователя</span>
        </v-card-title>
        <v-card-text>
          <v-container>
            <v-row>

              <v-col cols="12">
                <v-text-field
                    label="Название*"
                    v-model = this.type.name
                    required
                ></v-text-field>
              </v-col>
              <v-col cols="12">
                <v-text-field
                    label="Описание"
                    type="text"
                    v-model = this.type.description
                    required
                ></v-text-field>
              </v-col>

            </v-row>
          </v-container>
          <small>* Поля обязательны для заполнения</small>
        </v-card-text>
        <v-card-actions>
          <v-spacer></v-spacer>
          <v-btn
              color="blue-darken-1"
              variant="text"
              @click="isEditDialog = false"
          >
            Отмена
          </v-btn>
          <v-btn
              color="blue-darken-1"
              variant="text"
              @click="finishEditDialog"
          >
            Сохранить
          </v-btn>
        </v-card-actions>
      </v-card>
    </v-dialog>
  </v-row>


<fab v-on:fab_action="" ></fab>

</template>

<style>
.card{
  margin: 15px;
}
</style>