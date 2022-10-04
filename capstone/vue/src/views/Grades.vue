<template>
    <div class="grades">
        <teacher-grade-list />
    </div>  
</template>

<script>
import TeacherGradeList from '../components/TeacherGradeList.vue'

export default {
    name: "grades",
    components: {
        TeacherGradeList
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