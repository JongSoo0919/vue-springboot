<template>
  <div class="home">
    <a href="/user">사용자 목록</a>
    <br />
    <button @click="getData">데이터 호출</button>
  </div>
</template>

<script>
// @ is an alias to /src
import axios from "axios";
const uForm = {no: 1, name : 'vue-name', email: 'vue-email', gender: true, pwd: '1234'}
export default {
  name: 'HomeView',
  methods: {
    getData() {
      axios.put("http://localhost:8080/editById",uForm)
          .then((res) => {
            console.log(res);
          }).catch((error) => {
            alert("error!!!");
            console.log(error);
          })
      },
  }
}
</script>
<style scoped>

a {
  color: black;
  text-decoration: none;
  font-weight: bold;
  font-size: 1.5rem;
}

</style>
