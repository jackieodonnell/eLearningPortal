<template>
    <div class="grade-card">
<<<<<<< HEAD
        <h1> {{ grade.totalPoints }}</h1>
=======
        <div> {{grade.earnedPoints}}</div>
        <div> {{grade.status}}</div>
        <div> {{grade.feedback}}</div>
>>>>>>> main
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
