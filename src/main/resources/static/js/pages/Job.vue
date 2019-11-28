<template>
    <div>
        <div style="margin-top: 60px"><jobs-list :jobs="jobs"/></div>
    </div>
</template>

<script>
    import JobsList from "../components/jobs/JobsList.vue";
    export default {
        components:{
            JobsList
        },
        data() {
            return {
                jobs:[]
            }
        }
    }
</script>

<style scoped>

</style>


