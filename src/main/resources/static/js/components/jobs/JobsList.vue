<template>
    <v-container>
        <jobs-form :jobs ="jobs" />
        <v-card>
            <v-container>
                <h1>Список работ:</h1>
                <ol><jobs-row v-for="job in jobs" :key="job.id" :job="job" /></ol>
            </v-container>
        </v-card>
    </v-container>
</template>

<script>
    import JobsRow from './JobsRow.vue'
    import JobsForm from "./JobsForm.vue";

    export default {
        props: ['jobs'],
        components:{
            JobsRow,
            JobsForm
        },
        created() {
            this.$resource('/job{/id}').get().then(result =>
                result.json().then(data =>
                    data.forEach(job => this.jobs.push(job))
                )
            )
        }
    }

</script>

<style>


</style>