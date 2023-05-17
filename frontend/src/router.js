
import Vue from 'vue'
import Router from 'vue-router'

Vue.use(Router);


import MachineManager from "./components/listers/MachineCards"
import MachineDetail from "./components/listers/MachineDetail"


export default new Router({
    // mode: 'history',
    base: process.env.BASE_URL,
    routes: [
            {
                path: '/machines',
                name: 'MachineManager',
                component: MachineManager
            },
            {
                path: '/machines/:id',
                name: 'MachineDetail',
                component: MachineDetail
            },



    ]
})
