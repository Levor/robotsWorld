<template>
    <div>
        <input type="text" placeholder="Напишите название роботы" v-model = "name">
        <input type="text" placeholder="Напишите время выполнения" v-model = "time">
        <input type="button" value="Save" @click ="save">
    </div>
</template>

<script>
    export default {
        props: ['jobs'],
        data() {
            return {
                name: '',
                time: '',
                id: ''
            }
        },
        methods: {
            save() {
                const job = {name: this.name, time: this.time}
                this.$resource('/job{/id}').save({}, job).then(result =>
                    result.json().then(data => {
                        this.jobs.push(data);
                        this.name ='',
                            this.time =''
                    })
                )
            }
        }
    }
</script>

<style>

</style>