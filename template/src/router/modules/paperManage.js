import Layout from 'views/layout/layout'

const paperTest = {
  path: '/paperManage',
  component: Layout,
  redriect: '/paperManage/createPaper',
  name: 'paperManage',
  meta: { title: '试题管理' },
  children: [
    {
      path: 'createPaper',
      name: 'createPaper',
      component: r =>
        require.ensure([], () =>
          r(require('views/paperManage/createPaper'), 'createPaper')
        ),
      meta: { title: '创建试卷', needLogin: true }
    },
    {
      path: 'paperList',
      name: 'paperList',
      component: r =>
        require.ensure([], () =>
          r(require('views/paperManage/paperList'), 'paperList')
        ),
      meta: { title: '试卷列表', needLogin: true }
    }
  ]
}

export default paperTest
