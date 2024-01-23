<template>
  <v-card>
    <v-layout>
      <v-navigation-drawer
          expand-on-hover
          rail
      >
        <v-list density="compact" nav>
          <v-list-item

              prepend-icon="mdi-clipboard-list-outline"
              title="Задания"
              value="1"
              @click="routeTasks()"
          />
          <v-list-item
              prepend-icon="mdi-bookshelf"
              title="Учебные планы"
              value="2"
              @click="routeEducationPlans()"
          />

          <v-list-item
              prepend-icon="mdi-text-box-edit-outline"
              title="Журнал успеваемости"
              value="3"
              @click="routeGradebook()"
          />

          <v-list-item
              prepend-icon="mdi-email-outline"
              title="Сообщения"
              value="4"
              @click="routeMessages()"
          />

            <v-list-item
                prepend-icon="mdi-account-group"
                title="Пользователи"
                value="5"
                @click="routeUsers()"/>

        </v-list>
      </v-navigation-drawer>

      <v-main class="mainContainer">
        <router-view></router-view>
      </v-main>
    </v-layout>
  </v-card>

</template>

<style>
.mainContainer{
  margin: 25px;
}
</style>

<script>

import MyButton from "@/components/MyButton.vue";

export default {
  components: {MyButton},

  data() {
    return {
      x : false
    }
  },

  mounted() {
  },

  methods : {

    routeTasks(){this.$router.push('/tasks')},
    routeEducationPlans(){this.$router.push('/education-plans')},
    routeGradebook(){this.$router.push('/gradebook')},
    routeMessages(){this.$router.push('/messages')},
    routeUsers(){this.$router.push('/admin/users')},


}



}
</script>