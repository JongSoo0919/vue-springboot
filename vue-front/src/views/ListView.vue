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
      <tr class="cursor-pointer" v-for="row in result" v-bind:key="row.no" onclick="location.href = '/user/findById';">
        <td>{{ row.name }}</td>
        <td>{{ row.email}}</td>
        <td>{{row.regDate}}</td>
      </tr>
      </tbody>
    </table>
  </div>
</template>

<script>
export default {
  name : "ListView",
  data() {
    return {
      result: [
        {no: 1, name: '사용자1', email:'test1@aaaa.com', regDate: '2024-10-24'},
        {no: 2, name: '사용자2', email:'test1@bbbb.com', regDate: '2024-10-25'},
        {no: 3, name: '사용자3', email:'test1@cccc.com', regDate: '2024-10-27'}
      ]
    }
  }
}

</script>