// import router from 'router'
// import Storage from 'utils/storage'
// import Progress from 'nprogress'
// import 'nprogress/nprogress.css'
// import store from 'store'
// import { MessageBox } from 'element-ui'

// router.beforeEach((to, from, next) => {
//   Progress.start()
//   if (to.matched.some(res => res.meta.needLogin)) {
//     if (!Storage.get('token')) {
//       next({
//         path: '/login',
//         query: { redirect: to.path }
//       })
//       Progress.done()
//     } else {
// Changes to monitor 用来检查input变化，可用可不用
// if (store.state.isChangeVal === false) {
//   store.commit('SET_BLISTSHOW', true)
//   next(true)
//   Progress.done()
// } else {
//   MessageBox.confirm('你修改了值，是否继续返回?', '', {
//     confirmButtonText: '确定',
//     cancelButtonText: '取消',
//     showClose: false,
//     closeOnPressEscape: false,
//     type: 'warning'
//   }).then(() => {
//     store.commit('SET_ISCHANGEVAL', false)
//     store.commit('SET_BLISTSHOW', true)
//     next(true)
//     Progress.done()
//   }).catch(() => {
//     store.commit('SET_BLISTSHOW', false)
//     next(false)
//     Progress.done()
//   })
// }
// No exit allowed
//       if (to.path === '/login' && Storage.get('token')) {
//         next(false)
//         Progress.done()
//       }
//     }
//   } else {
//     next()
//     Progress.done()
//   }
// })

// router.afterEach(() => {
//   Progress.done()
// })
