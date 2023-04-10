import axios from 'axios';
import backendURL from './backendURL';

export default {
    LightingAPI:{
        GetFullList: async () =>{
        let response = await axios.get(backendURL + '/api/main')
            return response.data;
        },
        CreateNew: async () =>{
            let response = await axios.post(backendURL + '/api/create')
        },
        GetForEdit: async (id) => {
            let response = await axios.get(backendURL + `/api/edit/${id}`)
            return response.data;
        },
        SaveEdit: async (id, data) => {
            let response = axios.post(backendURL + `/api/edit/${id}`,data, {
            })
        },
        Delete: async (id) => {
            axios.delete(backendURL + `/api/delete/${id}`)
        },
        SwitchLight: async (id) => {
            axios.get(backendURL + `/api/info/switchLight/${id}`)
        }
    }
}