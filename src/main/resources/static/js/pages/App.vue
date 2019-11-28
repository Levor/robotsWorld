<template>
    <div>
        <div><robots-list :robots="robots"/></div>
    </div>
</template>

<script>
    import RobotsList from "../components/robots/RobotsList.vue";
    export default {
        components:{
            RobotsList,
        },
        data() {
            return {
                robots: []
            }
        }
    }
</script>

<style scoped>

</style>