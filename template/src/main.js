import Vue from 'vue'
import App from './App'
import router from './router'

// ELEMENT UI
import ElementUI from 'element-ui'
import 'element-ui/lib/theme-chalk/index.css'

// RESET CSS
import 'normalize.css'

// ICONFONT CSS
import 'common/styles/iconfont.css'

// BASE CONFIG
import config from 'utils/config'

Vue.config.productionTip = false

Vue.prototype.CONF = config

Vue.use(ElementUI)

/* eslint-disable no-new */
new Vue({
  el: '#app',
  router,
  render: h => h(App)
})
