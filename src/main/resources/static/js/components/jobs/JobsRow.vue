<template>
        <li>
            <p class="font-weight-black mr-10">Название работы:<i class="font-weight-regular">  {{job.name}}</i>  <b class="font-weight-black ml-10">Время выполнения работы:<i class="font-weight-regular">  {{job.time}} минут</i></b></p>
        </li>
</template>

<script>
    export default {
        props: ['job'],
    }

</script>

<style scoped>

</style>