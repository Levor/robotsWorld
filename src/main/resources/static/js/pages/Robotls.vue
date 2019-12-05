<template>
        <v-app>
                <v-toolbar app height="60" color="blue">
                    <v-spacer></v-spacer>
                    <v-toolbar-title style="color: #ff0b00; font-size: 40px">Добро пожаловать в мир роботов</v-toolbar-title>
                    <v-spacer></v-spacer>
                </v-toolbar>
                <v-content class="mt-12">
                        <v-cols>
                            <v-row
                                    align="start"
                                    justify="space-around"
                            >
                                <robots-list :robots="robots"/>
                                <jobs-list :jobs="jobs"/>
                            </v-row>
                        </v-cols>
                        <v-container>
                            <div style="height: 200px"></div>
                        </v-container>
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