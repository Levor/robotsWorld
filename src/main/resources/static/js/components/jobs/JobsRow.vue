<template>
    <li><i>Название работы:  {{job.name}}</i> <b>Время выполнения работы: {{job.time}}</b></li>
</template>

<script>
    export default {
        props: ['job'],
    }

</script>

<style scoped>

</style>