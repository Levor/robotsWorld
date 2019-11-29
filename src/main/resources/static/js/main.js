import Vue from 'vue'
import VueResource from 'vue-resource'
import Vuetify from 'vuetify'
import 'vuetify/dist/vuetify.min.css'
import Robotls from 'pages/Robotls.vue'



Vue.use(Vuetify)
Vue.use(VueResource)

new Vue({
    el: '#robotls',
    vuetify: new Vuetify(),
    render: a => a(Robotls)
})

