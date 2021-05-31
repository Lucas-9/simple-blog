import Vue from 'vue'
import VueRouter from 'vue-router'
import BlogDetail from '../views/BlogDetail'
Vue.use(VueRouter)

const routes = [
  {
    path: '/detail/:blogId',
    name: 'BlogDetail',
    component: BlogDetail
  },
  {
    path: '/edit',
    name: 'BlogEdit',
    component: () => import(/* webpackChunkName: "about" */ '../views/BlogEdit.vue'),
    meta: {
      requireAuth: true
    }
  },
  {
    path: '/edit/:blogId',
    name: 'BlogEdit',
    component: () => import(/* webpackChunkName: "about" */ '../views/BlogEdit.vue'),
    meta: {
      requireAuth: true
    }
  },
  {
    path: '/',
    name: 'Blogs',
    component: () => import(/* webpackChunkName: "about" */ '../views/Blogs.vue')
  },
  {
    path: '/index',
    name: 'Blogs',
    component: () => import(/* webpackChunkName: "about" */ '../views/Blogs.vue')
  },
  {
    path: '/blogs',
    name: 'Blogs',
    component: () => import(/* webpackChunkName: "about" */ '../views/Blogs.vue')
  },
  {
    path: '/login',
    name: 'Login',
    component: () => import(/* webpackChunkName: "about" */ '../views/Login.vue')
  }
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
