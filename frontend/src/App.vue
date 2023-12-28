<template>
  <v-card>
    <v-layout>
      <v-navigation-drawer
          expand-on-hover
          rail
      >
        <v-list density="compact" nav>
          <v-list-item
              prepend-icon="mdi-folder"
              title="Задания"
              value="1"
              @click="routeTasks()"
          />
          <v-list-item
              prepend-icon="mdi-account-multiple"
              title="Учебные планы"
              value="2"
              @click="routeEducationPlans()"
          />

          <v-list-item
              prepend-icon="mdi-star"
              title="Журнал успеваемости"
              value="3"/>

          <v-list-item
              prepend-icon="mdi-star"
              title="Сообщения"
              value="4"/>


          <v-list-group value="5">
            <template v-slot:activator="{props}">
              <v-list-item
              v-bind="props"
              prepend-icon="mdi-star"
              title="Админстрирование"
              />
            </template>

            <v-list-item
                prepend-icon="mdi-star"
                title="Статус задач"
                value="5.1"
                @click="routeTaskStatus()"
            />

            <v-list-item
                prepend-icon="mdi-star"
                title="Статус пользователя"
                value="5.2"/>

            <v-list-item
                prepend-icon="mdi-star"
                title="Тип пользователя"
                value="5.3"
                @click="routeUserType()"
            />

            <v-list-item
                prepend-icon="mdi-star"
                title="Студенты"
                value="5.4"/>

            <v-list-item
                prepend-icon="mdi-star"
                title="Преподаватели"
                value="5.5"/>

            <v-list-item
                prepend-icon="mdi-star"
                title="Все пользователи"
                value="5.6"/>
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
    routeUserType(){this.$router.push('/admin/user-type')}
}



}
</script>