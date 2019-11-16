var robotApi = Vue.resource('/robot{/id}')

Vue.component('robots-form', {
    props: ['robots'],
    data: function () {
        return {
            name: ''
        }
    },
    template:
        '<div>' +
            '<input type="text" placeholder="Напишите имя робота" v-model = "name">' +
            '<input type="button" value="Save" @click ="save">' +
        '</div>',
    methods: {
        save: function () {
            var robotname = {name: this.name}

            robotApi.save({}, robotname).then(result =>
            result.json().then(data => {
                this.robots.push(data);
                this.name =''
                })
            )
        }
    }
})

Vue.component('robot-row',{
    props: ['robot'],
    template: '<div><i>({{robot.id}})</i> {{robot.name}}</div>'
    }

)

Vue.component('robots-list', {
    props: ['robots'],
    template: '<div>' +
        '<robots-form :robots ="robots" />' +
        '<h1>Лист роботов</h1>' +
        '<robot-row v-for="robot in robots" :key="robot.id" :robot="robot" /></div>',
    created: function () {
        robotApi.get().then(result =>
            result.json().then(data =>
                data.forEach(robot => this.robots.push(robot))
            )
        )
    }
});

var app = new Vue({
    el: '#app',
    template: '<robots-list :robots="robots"/>',
    data: {
        robots: []
    }
});