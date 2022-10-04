<template>
    <div class="grades">
        <nav-bar />
        <grade-page-hero />
        <teacher-grade-list />

        
    </div>  
</template>

<script>
import GradePageHero from '../components/GradePageHero.vue';
import NavBar from '../components/NavBar.vue';
import TeacherGradeList from '../components/TeacherGradeList.vue'

export default {
    name: "grades",
    components: {
        TeacherGradeList,
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