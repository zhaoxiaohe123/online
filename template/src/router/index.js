import Vue from 'vue'
import Router from 'vue-router'

import Layout from 'views/layout/layout'

import management from './modules/management'
import paperManage from './modules/paperManage'
import staAnalysis from './modules/staAnalysis'
import userManage from './modules/userManage'
import studentlist from './modules/studentlist'
import subItem from './modules/subItem'

Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/login',
      component: r =>
        require.ensure([], () => r(require('views/login/login'), 'login')),
      hidden: true
    },
    { path: '*', redirect: '/login', hidden: true },
    {
      path: '/',
      component: Layout,
      redirect: '/login',
      name: 'login',
      hidden: true,
      children: [
        {
          path: 'home',
          component: r =>
            require.ensure([], () => r(require('views/home/home'), 'home')),
          meta: { title: 'Home', needLogin: true }
        }
      ]
    },
    management,
    paperManage,
    staAnalysis,
    userManage,
    studentlist,
    subItem
  ]
})
