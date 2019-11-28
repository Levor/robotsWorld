<template>
    <div>
        <div style="margin-bottom: 20px">
            <robots-form :robots ="robots" />
        </div>
        <div style="margin-bottom: 20px">
            <h1>Лист роботов</h1>
        </div>
        <div style="margin-bottom: 20px">
            <robot-row v-for="robot in robots" :key="robot.id" :robot="robot" :robots ="robots" />
        </div>
        <div>
            <input style="margin-left: 10px " type="button" value="Отправить всех" @click ="sentall">
            <input type="button" style="margin-left: 10px " value="Освободить всех" @click ="sentall2">
        </div>
    </div>

</template>

<script>
    import RobotRow from './RobotRow.vue'
    import RobotsForm from "./RobotsForm.vue";

    export default {
        props: ['robots'],
        components:{
            RobotRow,
            RobotsForm
        },
        methods: {

            sentall() {},
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