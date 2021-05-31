import axios from 'axios'
import Element from 'element-ui'
import store from './store'
import router from './router'

axios.defaults.baseURL = 'http://localhost:8181'
axios.interceptors.request.use(config => {
  // 前置拦截，如果有token就在请求头中加入token
  const token = localStorage.getItem('token')
  if (token) {
    config.headers.Authorization = token
  }
  return config
})
axios.interceptors.response.use(response => {
  const res = response.data
  // if (res.message === '登录过期') {
  //   store.commit('REMOVE_INFO')
  //   router.push({
  //     path: '/login'
  //   })
  //   response.message = '请重新登录'
  // }
  if (res.result === 'SUCCESS') {
    return response
  } else {
    Element.Message({
      message: response.data.message,
      type: 'error',
      duration: 2 * 1000
    })
    // 直接拒绝往下面返回结果信息
    return Promise.reject(response.data.msg)
  }
}, error => {
  if (error.response.data) {
    error.message = error.response.data.message
  }
  // 根据请求状态觉得是否登录或者提示其他
  if (error.response.status === 401) {
    store.commit('REMOVE_INFO')
    router.push({
      path: '/login'
    })
    error.message = '请重新登录'
  }
  Element.Message({
    message: error.message,
    type: 'error',
    duration: 2 * 1000
  })
  return Promise.reject(error)
})
