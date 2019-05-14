const sideInfo = {
  data () {
    return {
      navEvent: {
        opened: true,
        router: true
      },
      navList: [
        {
          hasLevelOne: true,
          isClick: false,
          name: '试题管理',
          path: '/management',
          role:'teacher',
          icon: 'icon-tikuguanli',
          children:
            [
              { hasLevelTwo: false, isClick: false, name: '新增客观题', path: '/management/manageTest' },
              { hasLevelTwo: false, isClick: false, name: '新增主观题', path: '/management/subjectiveItem' },
              { hasLevelTwo: false, isClick: false, name: '试题列表', path: '/management/list' }

            ]
        },
        {
          hasLevelOne: true,
          isClick: false,
          name: '试卷管理',
          role:'teacher',
          path: '/paperManage',
          icon: 'icon-shijuanguanli',
          children:
            [
              { hasLevelTwo: false, isClick: false, name: '创建试卷', path: '/paperManage/createPaper' },
              { hasLevelTwo: false, isClick: false, name: '试卷列表', path: '/paperManage/paperList' }
            ]
        },
        {
          hasLevelOne: true,
          isClick: false,
          role:'teacher',
          name: '统计分析',
          path: '/staAnalysis',
          icon: 'icon-tongji',
          children:
            [
              { hasLevelTwo: false, isClick: false, name: '考试分析', path: '/staAnalysis/testAnalysis' },
              { hasLevelTwo: false, isClick: false, name: '试卷分析', path: '/staAnalysis/paperAnalysis' }
            ]
        },
        {
          hasLevelOne: true,
          isClick: false,
          role:'teacher',
          name: '主观题',
          path: '/subItem',
          icon: 'icon-zhuguanti',
          children:
            [
              { hasLevelTwo: false, isClick: false, name: '主观题批阅', path: '/subItem/zhuguanti' }
            ]
        },
        {
          hasLevelOne: true,
          isClick: false,
          role:'Admin',
          name: '用户管理',
          path: '/userManage',
          icon: 'icon-yonghuguanli',
          children:
            [
              { hasLevelTwo: false, isClick: false, name: '新增用户', path: '/userManage/addUser' },
              { hasLevelTwo: false, isClick: false, name: '用户列表', path: '/userManage/userList' }
            ]
        },
        {
          hasLevelOne: true,
          isClick: false,
          role:'student',
          name: '学生信息',
          path: '/studentlist',
          icon: 'icon-xueshengxinxi',
          children:
            [
              { hasLevelTwo: false, isClick: false, name: '试卷信息', path: '/studentlist/paper_infor' },
              { hasLevelTwo: false, isClick: false, name: '查看成绩', path: '/studentlist/grade' }
            ]
        }
      ]
    }
  }
}

export { sideInfo }
