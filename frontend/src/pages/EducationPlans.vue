<script>

import eduPlansController from "@/controllers/EduPlansController";
import ItemViewer from "@/components/ItemViewer.vue";
import MySnackbar from "@/components/MySnackbar.vue";
import Fab from "@/components/Fab.vue";

export default {
    components: {Fab, MySnackbar, ItemViewer},

    data() {
        return {

            plans: [],
            isShowEditDialog: false,
            plan: {
                planId: '',
                name: '',
                description: ''
            },

            isShowAddDialog: false,


            snackbar: false,
            snackbarText: '',
        }
    },

    mounted() {

        eduPlansController.getAll()
            .then(response => this.plans = response.data)
            .catch(error => alert("Произошла ошибка при загрузке планов: " + error.message))

    },

    methods: {


        openEditDialog(item) {
            this.plan.planId = item.planId
            this.plan.name = item.name
            this.plan.description = item.description
            this.isShowEditDialog = true
        },

        closeEditDialog() {

            eduPlansController.edit(this.plan)
                .then(response => {
                    this.plans = this.plans.filter(plan => plan.planId !== this.plan.planId)
                    this.plans.push(response.data)
                    this.plans.sort((a, b) => a.planId - b.planId)
                })
                .catch()

            this.isShowEditDialog = false
        },

        openAddDialog() {
            this.plan.planId = ''
            this.plan.name = ''
            this.plan.description = ''
            this.isShowAddDialog = true
        },

        closeAddDialog() {
            eduPlansController.add(this.plan)
                .then(response => {
                    this.plans.push(response.data)
                    this.plans.sort((a, b) => a.planId - b.planId)
                })
                .catch(error => alert("Произошла ошибка при добавлении плана: " + error.message))
            this.isShowAddDialog = false;
        },


        deletePlan(id) {

            eduPlansController.deletePlan(id)
                .then(response => {
                    this.plans = this.plans.filter(plan => plan.planId !== id)
                    this.snackbarText = response.data
                    this.snackbar = true
                })
                .catch(error => alert("Произошла ошибка при удалении плана: " + error.message))

        },

        closeSnackBar() {
            this.snackbar = false
        }

    }

}
</script>

<template>

    <item-viewer
            :item="item"
            :id="item.planId"
            v-on:item_edit="openEditDialog($event)"
            v-on:item_delete="deletePlan($event)"
            v-for="item in plans"
    />

    <v-dialog
            v-model="isShowEditDialog"
            persistent
            width="1024"
    >
        <v-card>
            <v-card-title>
                <span class="text-h5">Редактирование учебного плана</span>
            </v-card-title>
            <v-card-text>

                <v-text-field
                        v-model="plan.name"
                        label="Название"
                        required
                ></v-text-field>

                <v-text-field
                        label="Описание"
                        required
                        v-model="plan.description"
                ></v-text-field>


            </v-card-text>
            <v-card-actions>
                <v-spacer></v-spacer>
                <v-btn
                        color="blue-darken-1"
                        variant="text"
                        @click="closeEditDialog()"
                >
                    Сохранить
                </v-btn>
                <v-btn
                        color="blue-darken-1"
                        variant="text"
                        @click="isShowEditDialog = false"
                >
                    Отмена
                </v-btn>
            </v-card-actions>
        </v-card>
    </v-dialog>

    <v-dialog
            v-model="isShowAddDialog"
            persistent
            width="1024"
    >
        <v-card>
            <v-card-title>
                <span class="text-h5">Создание учебного плана</span>
            </v-card-title>
            <v-card-text>

                <v-text-field
                        v-model="plan.name"
                        label="Название"
                        required
                ></v-text-field>

                <v-text-field
                        label="Описание"
                        required
                        v-model="plan.description"
                ></v-text-field>


            </v-card-text>
            <v-card-actions>
                <v-spacer></v-spacer>
                <v-btn
                        color="blue-darken-1"
                        variant="text"
                        @click="closeAddDialog()"
                >
                    Сохранить
                </v-btn>
                <v-btn
                        color="blue-darken-1"
                        variant="text"
                        @click="isShowAddDialog = false"
                >
                    Отмена
                </v-btn>
            </v-card-actions>
        </v-card>
    </v-dialog>

    <my-snackbar
            :text=snackbarText
            :is-show=snackbar
            v-on:snackbar-close=closeSnackBar()></my-snackbar>

    <fab v-on:fab_action="openAddDialog"></fab>

</template>

<style>

</style>