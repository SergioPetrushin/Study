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


          <v-list-group value="5">
            <template v-slot:activator="{props}">
              <v-list-item
              v-bind="props"
              prepend-icon="mdi-crown"
              title="Админстрирование"
              />
            </template>

            <v-list-item
                prepend-icon="mdi-list-status"
                title="Статус задач"
                value="5.1"
                @click="routeTaskStatus()"
            />

            <v-list-item
                prepend-icon="mdi-account-check-outline"
                title="Статус пользователя"
                value="5.2"
                @click="routeUserStatus()"
            />

            <v-list-item
                prepend-icon="mdi-account-supervisor"
                title="Тип пользователя"
                value="5.3"
                @click="routeUserType()"
            />

            <v-list-item
                prepend-icon="mdi-account-school"
                title="Студенты"
                value="5.4"
                @click="routeStudents()"
            />

            <v-list-item
                prepend-icon="mdi-human-male-board-poll"
                title="Преподаватели"
                value="5.5"
                @click="routeTeachers()"
            />

            <v-list-item
                prepend-icon="mdi-account-group"
                title="Все пользователи"
                value="5.6"
                @click="routeAllUsers()"/>
          </v-list-group>
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
    routeTaskStatus(){this.$router.push('/admin/task-status')},
    routeUserType(){this.$router.push('/admin/user-type')},
      routeGradebook(){this.$router.push('/gradebook')},
      routeMessages(){this.$router.push('/messages')},
      routeUserStatus(){this.$router.push('/admin/user-status')},
      routeStudents(){this.$router.push('/admin/students')},
      routeTeachers(){this.$router.push('/admin/teachers')},
      routeAllUsers(){this.$router.push('/admin/all-users')},


}



}
</script>