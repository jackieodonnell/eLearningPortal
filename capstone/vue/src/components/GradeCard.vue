<template>
    <div class="grade-card">
        <p> {{ grade.studentId }}</p>
        <p>{{ grade.earnedPoints }}</p>
        <p> {{ grade.totalPoints }}</p>
        <p> {{ grade.status }}</p>
    </div>
</template>

<script>

export default {
    name: 'grade-card',
    props: ['grade'],
    methods: {

        }
}   
</script>
<style scoped>
* {
    display: flex;
    flex-direction: row;
    margin: 20px;
    width: 100px;
}

</style>
