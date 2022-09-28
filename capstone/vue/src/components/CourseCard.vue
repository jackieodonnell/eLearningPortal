<template>
  <div class="card">
    <h2 class="course-title">{{course.courseTitle}}</h2>
    <h3 class="course-description">{{course.courseDescription}}</h3>
    </div>
</template>

<script>
export default {
    name: 'course-card',
    props: ['course'],
    methods: {

        }
    }
</script>

<style>
.card{
    border: 2px solid black;
    border-radius: 10px;
    width: 250px;
    height: 150px;
    margin: 20px;
}

/* .card.read {
    background-color: lightgray;
} */

.card .course-title {
    font-size: 1.5rem;
}

.card .course-descriptionI{
    font-style: normal;
}

/* .card .book-author {
    font-size: 1rem;
} */
</style>