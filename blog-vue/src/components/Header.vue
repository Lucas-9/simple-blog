<template>
  <div class="m-content">
    <h3>欢迎来到Lucas的博客</h3>
    <div class="block">
      <el-avatar :size="50" :src="user.avatar"></el-avatar>
      <div>{{ user.username }}</div>
    </div>
    <div>
      <el-link href="/blogs">主页</el-link>
      <el-divider direction="vertical"></el-divider>
      <span>
          <el-link type="success" href="/edit" :disabled="!hasLogin">发表文章</el-link>
        </span>
      <el-divider direction="vertical"></el-divider>
      <span v-show="!hasLogin">
          <el-link type="primary" href="login">登录</el-link>
        </span>
      <span v-show="hasLogin">
          <el-link type="danger" @click="logout">退出</el-link>
        </span>
    </div>
  </div>
</template>
<script>
export default {
  name: 'Header',
  data () {
    return {
      hasLogin: false,
      user: {
        username: '请先登录',
        avatar: ''
      },
      blogs: {},
      currentPage: 1,
      total: 0
    }
  },
  methods: {
    logout () {
      const _this = this
      this.$axios.post('/user/logout').then((res) => {
        _this.$store.commit('REMOVE_INFO')
        location.reload()
      })
    }
  },
  created () {
    if (this.$store.getters.getUser.username) {
      this.user.username = this.$store.getters.getUser.username
      this.user.avatar = this.$store.getters.getUser.avatar
      this.hasLogin = true
    }
  }
}
</script>
<style>
  .m-content {
    width: 900px;
    margin: 0 auto;
    text-align: center;
  }
</style>
