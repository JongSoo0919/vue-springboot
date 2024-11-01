<template>
  <router-view/>
</template>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
}

nav {
  padding: 30px;
}

nav a {
  font-weight: bold;
  color: #2c3e50;
}

nav a.router-link-exact-active {
  color: #42b983;
}
</style>
<script>
export default {
  created() {
    const user = sessionStorage.getItem('setUser');
    if(user) {
      console.log(this.base64(user));
      this.$store.commit('setUser', this.base64(user));
    }
  },
  methods: {
    base64(user){
      return JSON.parse(decodeURIComponent(window.atob(user)));
    }
  }
}
</script>