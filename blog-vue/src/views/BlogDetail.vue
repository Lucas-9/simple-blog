<template>
  <div class="m-container">
    <Header></Header>
    <div class="mblog">
      <h2>{{ blog.title }}</h2>
      <el-link icon="el-icon-edit" v-if="ownBlog">
        <router-link :to="{name: 'BlogEdit', params: {blogId: blog.id}}">编辑</router-link>
        {{'\u2003'}}
      </el-link>
      <el-link icon="el-icon-edit" v-if="ownBlog">
        <a @click="deleteBlog">删除</a>
      </el-link>
      <el-divider></el-divider>
      <div class="content markdown-body" v-html="blog.content"></div>
    </div>
  </div>
</template>
<script>
import 'github-markdown-css/github-markdown.css' // 然后添加样式markdown-body
import Header from '../components/Header'
export default {
  name: 'BlogDetail',
  components: { Header },
  data () {
    return {
      blog: {
        userId: null,
        title: '',
        description: '',
        content: ''
      },
      ownBlog: false
    }
  },
  methods: {
    getBlog () {
      const _this = this
      const blogId = _this.$route.params.blogId
      this.$axios.get('blog/detail?blogId=' + blogId).then((res) => {
        _this.blog = res.data.data
        const MarkdownIt = require('markdown-it')
        const md = new MarkdownIt()
        const result = md.render(_this.blog.content)
        _this.blog.content = result
        // 判断是否是自己的文章，能否编辑
        _this.ownBlog = (_this.blog.userId === _this.$store.getters.getUser.id)
      })
    },
    deleteBlog () {
      const _this = this
      const blogId = _this.$route.params.blogId
      this.$confirm('此操作将永久删除该博客, 是否继续?', '提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning'
      }).then(() => {
        _this.$axios.get('blog/delete?blogId=' + blogId).then((res) => {
          _this.$message({
            type: 'success',
            message: '删除成功!'
          })
          _this.$router.push('/blogs')
        })
      }).catch(() => {
        this.$message({
          type: 'info',
          message: '已取消删除'
        })
      })
    }
  },
  created () {
    this.getBlog()
  }
}
</script>
<style>
  .mblog {
    margin-top: 10px;
    padding: 10px;
    box-shadow: 0 2px 12px 0 rgba(0, 0, 0, 0.1);
  }
</style>
