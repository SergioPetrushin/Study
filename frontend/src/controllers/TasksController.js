import axios from "axios"


const HOST = "http://localhost:8080"
const API = "/api/v1/task/"


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

}


