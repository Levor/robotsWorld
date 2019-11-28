<template>
    <div style="margin-bottom: 15px">
        <span style="left: 0px">
        <i>({{robot.id}})</i>
        </span>
        <span style="position: absolute; left: 60px">
        {{robot.name}}
        </span>
        <span style="position: absolute; left: 250px">
            {{robot.status}}
        </span>
        <span style="position: absolute; left: 350px">
        <input style="margin-left: 10px " type="button" value="Отправить" @click ="sent">
        <input type="button" style="margin-left: 10px " value="Освободить" @click ="sent2">
        </span>
    </div>
</template>

<script>
    function getIndex(list, id) {
        for (var i = 0; i < list.length; i++ ) {
            if (list[i].id === id) {
                return i
            }
        }
        return -1
    }
    export default {
        props: ['robot', 'robots'],
        methods: {
            sent() {
                this.robot.status = "Работает",
                    this.$resource('/robot{/id}').update({id: this.robot.id}, this.robot).then(result =>
                        result.json().then(data => {
                            const index = getIndex(this.robots, data.id)
                            this.robots.splice(index, 1, data)
                        })
                    )
            },
            sent2() {
                this.robot.status = "Свободен",
                    this.$resource('/robot{/id}').update({id: this.robot.id}, this.robot).then(result =>
                        result.json().then(data => {
                            const index = getIndex(this.robots, data.id)
                            this.robots.splice(index, 1, data)
                        })
                    )
            }
        }
    }

</script>

<style scoped>

</style>