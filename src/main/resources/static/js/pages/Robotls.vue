<template>
        <v-app>
                <v-toolbar robotls height="60" color="blue">
                    <v-spacer></v-spacer>
                    <v-toolbar-title style="color: #ff0b00; font-size: 40px">Добро пожаловать в "Мир роботов"</v-toolbar-title>
                    <v-spacer></v-spacer>
                </v-toolbar>
                <v-content>
                    <robots-list :robots="robots"/>
                    <jobs-list :jobs="jobs"/>
                </v-content>
        </v-app>
</template>

<script>
    import RobotsList from "../components/robots/RobotsList.vue";
    import JobsList from "../components/jobs/JobsList.vue";
    export default {
        components:{
            RobotsList,
            JobsList
        },
        data() {
            return {
                robots: [],
                jobs: []

            }
        }
    }
</script>

<style scoped>

</style>