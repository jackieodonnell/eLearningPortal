<template>
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

<style>
th, td {
  padding-top: 10px;
  padding-bottom: 20px;
  padding-left: 30px;
  padding-right: 30px;
  text-align: left;
}
</style>
