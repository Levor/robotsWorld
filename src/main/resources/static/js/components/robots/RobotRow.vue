<template>
    <div>
        <v-card-title><p>Робот: {{robot.name}}    Статус: <i style="color: darkblue">{{robot.status}}</i></p></v-card-title>
        <v-card-text>
            <v-btn @click ="sent">Отправить</v-btn>
            <v-btn @click ="getfree">Освободить</v-btn>
        </v-card-text>
    </div>
</template>

<script>
    function getIndex(list, id) {
        for (var i = 0; i < list.length; i++ ) {
            if (list[i].id === id) {
                return i
            }
        }
        return -1
    }
    export default {
        props: ['robot', 'robots'],
        methods: {
            sent() {
                this.robot.status = "Работает",
                    this.$resource('/robot{/id}').update({id: this.robot.id}, this.robot).then(result =>
                        result.json().then(data => {
                            const index = getIndex(this.robots, data.id)
                            this.robots.splice(index, 1, data)
                        })
                    )
            },
            getfree() {
                this.robot.status = "Свободен",
                    this.$resource('/robot{/id}').update({id: this.robot.id}, this.robot).then(result =>
                        result.json().then(data => {
                            const index = getIndex(this.robots, data.id)
                            this.robots.splice(index, 1, data)
                        })
                    )
            }
        }
    }

</script>

<style scoped>

</style>