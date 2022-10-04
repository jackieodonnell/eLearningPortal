<template>
    <div class="grades">
        <teacher-grade-view />
    </div>  
</template>

<script>
import TeacherGradeView from '../components/TeacherGradeView.vue'

export default {
    name: "grades",
    components: {
        TeacherGradeView
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