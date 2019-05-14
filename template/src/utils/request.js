import axios from 'axios'
import { Message } from 'element-ui'
// import store from 'store/index'
import router from 'router'
// ESTABLISH AXIOS
const service = axios.create({
  baseURL: process.env.BASE_URL,
  timeout: 20000
})

// REQUEST INTERCEPT
service.interceptors.request.use(
  config => {
    // let token = store.state.token
    // if (store.state.token) {
    //   config.headers['Token'] = 'Bearer ' + token
    // }
    return config
  },
  err => {
    console.log(err)
    Promise.reject(err)
  }
)

// RESPONE  INTERCEPT
service.interceptors.response.use(
  response => {
    let res = response.data
    return res
  },

  // let { data, code } = res
  // if (code !== '1') {
  //   Message({
  //     message: '请求失败',
  //     type: 'error',
  //     duration: 5 * 1000
  //   })
  //   if (code === '1001') {
  //     console.log('token为空')
  //   } else if (code === '1002') {
  //     console.log('token过期')
  //   }
  //   return false
  // } else if (code === '500') {
  //   console.log()
  // } else {
  //   if (data === null || data === '' || data === []) {
  //     let data = []
  //     return data
  //   } else {
  //     return data
  //   }
  // }
  // },
  // SERVER ERR
  err => {
    if (err && err.response) {
      switch (err.response.status) {
        case 400:
          err.message = '请求错误'
          break
        case 401:
          err.message = '未授权，请登录'
          break
        case 403:
          err.message = '拒绝访问'
          break
        case 404:
          err.message = `请求地址出错: ${err.response.config.url}`
          router.replace('/404')
          break
        case 408:
          err.message = '请求超时'
          router.replace('/home')
          break
        case 500:
          err.message = '服务器内部错误'
          router.replace('/500')
          break
        case 501:
          err.message = '服务未实现'
          break
        case 502:
          err.message = '网关错误'
          break
        case 503:
          err.message = '服务不可用'
          break
        case 504:
          err.message = '网关超时'
          break
        case 505:
          err.message = 'HTTP版本不受支持'
          break
        default:
      }
    }
    Message({
      message: err.message,
      type: 'error',
      duration: 5 * 1000
    })
    return Promise.reject(err)
  }
)
export default service
