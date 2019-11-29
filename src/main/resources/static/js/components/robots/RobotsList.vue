<template>
        <v-container class="mt-12">
            <robots-form :robots ="robots" />

            <v-card elevation="10">
                <h1 style="text-align: center">Лист роботов</h1>
                <robot-row v-for="robot in robots" :key="robot.id" :robot="robot" :robots ="robots" />
                <p style="text-align: center"><v-btn depressed large color="primary" @click ="sentall" class="mt-8">Отправить всех</v-btn>
                <v-btn depressed large color="primary" @click ="sentall2" class="mt-8"> Освободить всех</v-btn></p>
            </v-card>
        <v-container class="mt-8">

        </v-container>
        </v-container>
</template>

<script>
    import RobotRow from './RobotRow.vue'
    import RobotsForm from "./RobotsForm.vue";
    function getIndex(list, id) {
        for (var i = 0; i < list.length; i++ ) {
            if (list[i].id === id) {
                return i
            }
        }
        return -1
    }
    export default {
        props: ['robots'],
        components:{
            RobotRow,
            RobotsForm
        },
        methods: {

            sentall() {
/*                for (var i = 0; i < this.robots.length; i++ ) {
                    this.robots[i].status="Работает",
                        this.$resource('/robot{/id}').update({id: this.robots[i].id}, this.robots[i]).then(result =>
                            result.json().then(data => {
                                const index = getIndex(this.robots[i], data.id)
                                this.robots.splice(index, 1, data)
                            })
                        )
                }*/
            },
            sentall2() {}
        },
        created() {
            this.$resource('/robot{/id}').get().then(result =>
                result.json().then(data =>
                    data.forEach(robot => this.robots.push(robot))
                )
            )
        }
    }

</script>

<style>


</style>