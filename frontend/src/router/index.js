import { createRouter, createWebHistory } from 'vue-router'
import Login from "@/pages/Login.vue";
import Tasks from "@/pages/Tasks.vue";
import EducationPlans from "@/pages/EducationPlans.vue";
import TaskStatus from "@/pages/TaskStatus.vue";
import UserTypes from "@/pages/UserTypes.vue";
import Gradebook from "@/pages/Gradebook.vue";
import Messages from "@/pages/Messages.vue";
import UserStatus from "@/pages/UserStatus.vue";
import Students from "@/pages/Students.vue";
import Teachers from "@/pages/Teachers.vue";
import AllUsers from "@/pages/AllUsers.vue";


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

  {
    path : '/gradebook',
    component : Gradebook
  },

  {
    path : '/messages',
    component : Messages
  },

  {
    path : '/admin/user-status',
    component : UserStatus
  },

  {
    path : '/admin/students',
    component : Students
  },

  {
    path : '/admin/teachers',
    component : Teachers
  },

  {
    path : '/admin/all-users',
    component : AllUsers
  },






]

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes
})

export default router
