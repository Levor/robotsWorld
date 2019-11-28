<template>
    <div>
        <input type="text" placeholder="Напишите имя робота" v-model = "name">
        <input type="button" value="Save" @click ="save">
    </div>
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