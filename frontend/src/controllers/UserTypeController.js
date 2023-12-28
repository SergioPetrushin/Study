import axios from "axios"

const HOST = "http://localhost:9000"
const API = "/api/v1/user-type/"

export default {


    getAll(){
        return axios.post(
            HOST + API + 'get-all',
            {},
            {
                headers: {
                    'Content-Type': "application/json;charset=utf-8"
                }
            }
        )
    }



}
