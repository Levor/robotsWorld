<template>
    <v-layout>
        <v-text-field label="Напишите название роботы"
                      placeholder="Название роботы"
                      class="red--text"
                      :rounded="true"
                      :filled="true"
                      v-model = "name" />
        <v-text-field label="Напишите время выполнения"
                      placeholder="Время выполнения работы в минутах"
                      :rounded="true"
                      :filled="true"
                      v-model = "time"/>
        <v-btn depressed large color="primary" @click ="save">Добавить</v-btn>
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