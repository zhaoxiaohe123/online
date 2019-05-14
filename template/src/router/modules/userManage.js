import Layout from 'views/layout/layout'

const userManage = {
  path: '/userManage',
  component: Layout,
  redriect: '/userManage/userList',
  name: 'userManage',
  meta: { title: '用户管理' },
  children: [
    {
      path: 'userList',
      name: 'userList',
      component: r =>
        require.ensure([], () =>
          r(require('views/userManage/userList'), 'userList')
        ),
      meta: { title: '用户列表', needLogin: true }
    },
    {
      path: 'addUser',
      name: 'addUser',
      component: r =>
        require.ensure([], () =>
          r(require('views/userManage/addUser'), 'addUser')
        ),
      meta: { title: '新增用户', needLogin: true }
    }
  ]
}

export default userManage
