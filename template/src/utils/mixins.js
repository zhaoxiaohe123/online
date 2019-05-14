import { Loading, Message } from 'element-ui'
let loading
const loadingMode = {
  methods: {
    startLoading () {
      loading = Loading.service({
        lock: true,
        text: '加载中……',
        background: 'rgba(0, 0, 0, 0.7)'
      })
    },
    endLoading () {
      loading.close()
    }
  }
}
const messageMode = {
  methods: {
    message (title, type, time) {
      Message({
        message: title,
        type: type,
        duration: time
      })
    }
  }
}

export { loadingMode, messageMode }

// 以上是根据ELEMENT UI中的一些功能进行二次封装
