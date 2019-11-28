import Vue from 'vue'
import VueResource from 'vue-resource'
import App from 'pages/App.vue'
import Job from 'pages/Job.vue'

Vue.use(VueResource)

new Vue({
    el: '#app',
    render: a => a(App)
})
new Vue({
    el: '#job',
    render: a => a(Job)
})

