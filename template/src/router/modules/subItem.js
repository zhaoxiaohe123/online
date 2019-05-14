import Layout from 'views/layout/layout'

const subItem = {
  path: '/subItem',
  component: Layout,
  redirect: '/subItem/zhuguanti',
  name: 'subItem',
  meta: { title: '主观题' },
  children: [
    {
      path: 'zhuguanti',
      name: 'zhuguanti',
      component: r =>
        require.ensure([], () =>
          r(require('views/subItem/zhuguanti'), 'zhuguanti')
        ),
      meta: { title: '主观题批阅', needLogin: true }
    }]
}
export default subItem
