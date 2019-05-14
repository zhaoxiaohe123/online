import Layout from 'views/layout/layout'

const management = {
  path: '/management',
  component: Layout,
  redirect: '/management/list',
  name: 'management',
  meta: { title: '试题管理' },
  children: [
    {
      path: 'list',
      name: 'list',
      component: r =>
        require.ensure([], () =>
          r(require('views/management/list'), 'list')
        ),
      meta: { title: '试题列表', needLogin: true }
    },
    {
      path: 'manageTest',
      name: 'manageTest',
      component: r =>
        require.ensure([], () =>
          r(require('views/management/manageTest'), 'manageTest')
        ),
      meta: { title: '新增客观题', needLogin: true }
    },
    {
      path: 'subjectiveItem',
      name: 'subjectiveItem',
      component: r =>
        require.ensure([], () =>
          r(require('views/management/subjectiveItem'), 'subjectiveItem')
        ),
      meta: { title: '新增主观题', needLogin: true }
    }
  ]
}

export default management
