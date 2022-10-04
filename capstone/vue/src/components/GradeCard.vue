<template>
    <div class="grade-card">
        <div> {{grade.earnedPoints}}</div>
        <div> {{grade.status}}</div>
        <div> {{grade.feedback}}</div>
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
