import Layout from 'views/layout/layout'

const studentlist = {
  path: '/studentlist',
  component: Layout,
  redirect: '/studentlist/paper_infor',
  name: 'studentlist',
  meta: { title: '学生信息' },
  children: [
    {
      path: 'paper_infor',
      name: 'paper_infor',
      component: r =>
        require.ensure([], () =>
          r(require('views/studentlist/paper_infor'), 'paper_infor')
        ),
      meta: { title: '试卷信息', needLogin: true }
    }, {
      path: 'grade',
      name: 'grade',
      component: r =>
        require.ensure([], () =>
          r(require('views/studentlist/grade'), 'grade')
        ),
      meta: { title: '查看试卷', needLogin: true }
    }]
}
export default studentlist
