import {createRouter, createWebHistory} from 'vue-router'
import Login from "@/pages/Login.vue";
import Tasks from "@/pages/Tasks.vue";
import EducationPlans from "@/pages/EducationPlans.vue";
import Gradebook from "@/pages/Gradebook.vue";
import Messages from "@/pages/Messages.vue";
import AllUsers from "@/pages/AllUsers.vue";
import Registration from "@/pages/Registration.vue";


const routes = [

    {
        path: '/login',
        component: Login
    },

    {
        path: '/registration',
        component: Registration
    },

    {
        path: '/task',
        component: Tasks
    },
    {
        path: '/education-plans',
        component: EducationPlans
    },

    {
        path: '/gradebook',
        component: Gradebook
    },

    {
        path: '/messages',
        component: Messages
    },


    {
        path: '/admin/users',
        component: AllUsers
    },


]

const router = createRouter({
    history: createWebHistory(process.env.BASE_URL),
    routes
})

export default router
