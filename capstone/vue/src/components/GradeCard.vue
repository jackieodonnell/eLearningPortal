<template>
    <div class="grade-card">
        <h1> {{ grade.totalPoints }}</h1>
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
