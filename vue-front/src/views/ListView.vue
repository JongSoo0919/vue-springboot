<template>
  <div class="container mt-3">
    <h1 class="display-1 text-center">사용자 목록</h1>
    <div class="btn-group">
      <a href="/user/save" class="btn btn-primary">사용자 추가</a>
    </div>
    <table class="table table-hover mt-3">
      <thead class="table-dark">
      <tr>
        <th>이름</th>
        <th>이메일</th>
        <th>가입날짜</th>
      </tr>
      </thead>
      <tbody>
      <tr class="cursor-pointer" v-for="row in result" v-bind:key="row.no" v-on:click="$event => href(row)">
        <td>{{ row.name }}</td>
        <td>{{ row.email}}</td>
        <td>{{row.regDate}}</td>
      </tr>
      </tbody>
    </table>
  </div>
</template>

<script>
import axios from "axios";

export default {
  name: "ListView",
  data() {
    return {
      result: []
    }
  },
  created() {
    this.getData();
  },
  methods: {
    getData() {
      axios
          .get("http://localhost:8080/findAll")
          .then((response) => {
            console.log(response);
            this.result = response.data.data;
          })
          .catch((error) => {
            console.log(error);
          })
    },
    href(row) {
      console.log(row);
      this.$router.push({name: "SelectView"});
    }
  }
}
</script>