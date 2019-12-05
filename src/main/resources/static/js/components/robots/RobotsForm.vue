<template>
    <v-layout>
        <v-text-field label="Добавьте робота"
                      :rounded="true"
                      :filled="true"
                      placeholder="Напишите имя робота"
                      v-model = "name"/>
        <v-btn class="mt-2 ml-3" @click ="save">Добавить</v-btn>
    </v-layout>
</template>

<script>
    export default {
        props: ['robots'],
        data() {
            return {
                name: '',
                id: ''
            }
        },
        methods: {
            save() {
                const robot = {name: this.name}
                this.$resource('/robot{/id}').save({}, robot).then(result =>
                    result.json().then(data => {
                        this.robots.push(data);
                        this.name =''
                    })
                )
            }
        }
    }
</script>

<style>

</style>