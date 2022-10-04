<template>
    <div class="grades">
        <nav-bar />
        <grade-page-hero />
        <teacher-grade-view />
    </div>  
</template>

<script>
import GradePageHero from '../components/GradePageHero.vue';
import NavBar from '../components/NavBar.vue';
import TeacherGradeView from '../components/TeacherGradeView.vue'

export default {
    name: "grades",
    components: {
        TeacherGradeView,
        NavBar,
        GradePageHero
    },  
};
</script>

<style>
.account {
    display: flex;
    align-items: center;
    justify-content: center;
}
</style>