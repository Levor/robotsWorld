<template>
    <v-layout>
        <v-text-field label="Напишите название роботы"
                      placeholder="Название роботы"
                      class="ml-5"
                      rounded="true"
                      filled="true"
                      v-model = "name" />
        <v-text-field class="ml-3"
                      label="Напишите время выполнения"
                      placeholder="Укажите время в минутах"
                      rounded="true"
                      filled="true"
                      v-model = "time"/>
        <v-btn class="mt-2 ml-3 mr-2" depressed large color="primary" @click ="save">Добавить</v-btn>
    </v-layout>
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