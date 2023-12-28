import { createRouter, createWebHistory } from 'vue-router'
import Login from "@/pages/Login.vue";
import Tasks from "@/pages/Tasks.vue";
import EducationPlans from "@/pages/EducationPlans.vue";
import TaskStatus from "@/pages/TaskStatus.vue";
import UserTypes from "@/pages/UserTypes.vue";


const routes = [

  {
    path : '/login',
    component : Login
  },

  {
    path : '/tasks',
    component : Tasks
  },
  {
    path : '/education-plans',
    component : EducationPlans
  },

  {
    path : '/admin/task-status',
    component : TaskStatus
  },

  {
    path : '/admin/user-type',
    component : UserTypes
  },






]

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes
})

export default router
