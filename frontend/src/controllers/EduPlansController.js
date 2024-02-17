import axios from "axios"


const HOST = "http://localhost:8080"
const API = "/api/v1/education-plan/"


export default {



    getAll() {

        return axios.post(
            HOST + API + 'get-all',
            {},
            {
                headers: {
                    'Content-Type': "application/json;charset=utf-8"
                }
            }
        )

    },


    deletePlan(id) {

        return axios.post(
            HOST + API + 'delete',
            {
                planId : id
            },
            {
                headers: {
                    'Content-Type': "application/json;charset=utf-8"
                }
            }
        )
    },

    edit(plan) {

        return axios.post(
            HOST + API + 'edit',
            plan,
            {
                headers: {
                    'Content-Type': "application/json;charset=utf-8"
                }
            }
        )

    }


}


