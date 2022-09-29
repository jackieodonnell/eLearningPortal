<template>
    <div class="account">
        <profile />
    </div>  
</template>

<script>
import Profile from '../components/Profile.vue'

export default {
    name: "account",
    components: {
        Profile
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
