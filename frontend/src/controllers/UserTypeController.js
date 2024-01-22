import axios from "axios"

const HOST = "http://localhost:8080"
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
    },

    deleteUserType(id) {

        return axios.post(
            HOST + API + 'delete',
            {
                typeId : id
            },
            {
                headers: {
                    'Content-Type': "application/json;charset=utf-8"
                }
            }
        )
    },

    edit(userType) {

        return axios.post(
            HOST + API + 'edit',
            {
                typeId : userType.id,
                name : userType.name,
                description : userType.description
            },
            {
                headers: {
                    'Content-Type': "application/json;charset=utf-8"
                }
            }
        )
    },

    add(userType) {

        return axios.post(
            HOST + API + 'add',
            {
                name : userType.name,
                description : userType.description
            },
            {
                headers: {
                    'Content-Type': "application/json;charset=utf-8"
                }
            }
        )
    }

}
