<template>
<<<<<<< HEAD
    <div class="class-container">
        <div class="grade-card">
            <table>
                <tr>
                    <td> {{grade.earnedPoints}} / {{grade.totalPoints}}</td>
                    <td> {{grade.status}}</td>
                    <td> {{grade.submissionContent}}</td>
                </tr>
            </table>
        </div>
=======
    <div class="grade-card">
        <p> {{ grade.studentId }}</p>
        <p>{{ grade.earnedPoints }}</p>
        <p> {{ grade.totalPoints }}</p>
        <p> {{ grade.status }}</p>
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
<<<<<<< HEAD

<style>
th, td {
  padding-top: 10px;
  padding-bottom: 20px;
  padding-left: 30px;
  padding-right: 30px;
  text-align: left;
}
=======
<style scoped>
* {
    display: flex;
    flex-direction: row;
    margin: 20px;
    width: 100px;
}

>>>>>>> main
</style>
