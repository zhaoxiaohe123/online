import Layout from 'views/layout/layout'

const staAnalysis = {
  path: '/staAnalysis',
  component: Layout,
  redriect: '/staAnalysis/testAnalysis',
  name: 'staAnalysis',
  meta: { title: '统计分析' },
  children: [
    {
      path: 'testAnalysis',
      name: 'testAnalysis',
      component: r =>
        require.ensure([], () =>
          r(require('views/staAnalysis/testAnalysis'), 'testAnalysis')
        ),
      meta: { title: '考试分析', needLogin: true }
    },
    {
      path: 'paperAnalysis',
      name: 'paperAnalysis',
      component: r =>
        require.ensure([], () =>
          r(require('views/staAnalysis/paperAnalysis'), 'paperAnalysis')
        ),
      meta: { title: '试卷分析', needLogin: true }
    }
  ]
}

export default staAnalysis
