<template>
    <div class="profile">
        <h2> {{$store.state.user.firstname}}'s Profile</h2>
        <table>
            <tr>
                <td>First Name: </td>
                <td class="profile_text">
                    {{ $store.state.user.firstname }}
                </td>
            </tr>
            <tr>
                <td>Last Name: </td>
                <td class="profile_text">
                    {{ $store.state.user.lastname }}
                </td>
            </tr>
            <tr>
                <td>Username: </td>
                <td class="profile_text">
                    {{ $store.state.user.username }}
                </td>
            </tr>
            <tr>
                <td>Role: </td>
                <td class="profile_text" v-on="confirmRole()">
                    {{ role }}
                </td>
            </tr>
        </table>
    </div>
</template>

<script>

export default {
    name: "profile",
    data() {
        return {
            role: ''
        }
    },
    methods: {
        confirmRole(){
            if(this.$store.state.user.authorities.some(e => e ['name'] === "ROLE_TEACHER")){
                this.role = 'teacher';
            }
            else if(this.$store.state.user.authorities.some(e => e ['name'] === "ROLE_STUDENT")){
                this.role = 'student';
            }
            else if(this.$store.state.user.authorities.some(e => e ['name'] === "ROLE_ADMIN")){
                this.role = 'admin';
            }
            else if(this.$store.state.user.authorities.some(e => e ['name'] === "ROLE_USER")){
                this.role = 'user';
            }
        }
    } 
};
</script>

<style>
.profile {
    font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
    margin-bottom: 50vh;
    width: 30vw;
    padding: 1.9rem 1.2rem;
    text-align: center;
    background-color:#ffe760;
    border-radius: 4px;
    box-shadow: 10px 10px #5e6681;
    justify-content: center;
    margin-left: auto;
    margin-right: auto;
    margin-top: 20px;
}
.profile_text {
    margin-top: .5rem;
    margin-left: auto;
    margin-right: auto;
    display: flex;
    align-items: center;
    justify-content: center;
    gap: .5em;
    background-color: #d8ffcf;
    border-radius: 4px;
    padding: .5em 1em;
    width: 20rem;
}
</style>
