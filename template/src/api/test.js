
import request from 'utils/request'
// 增加试题
export function addTest (data) {
  return request({
    url: '/api/subject/add/v1',
    method: 'post',
    data: data
  })
}
export function addSubTest (data) {
  return request({
    url: '/api/subject/addSub/v1',
    method: 'post',
    data: data
  })
}
// 删除试题
export function delTest (data) {
  return request({
    url: '/api/subject/del/v1',
    method: 'post',
    data: data
  })
}
// 试题列表
export function testList (data) {
  return request({
    url: '/api/subject/list/v1',
    method: 'post',
    data: data
  })
}
// 更新试题
export function updateTest (data) {
  return request({
    url: '/api/subject/update/v1',
    method: 'post',
    data: data
  })
}
// 新增试卷
export function addPaper (data) {
  return request({
    url: '/api/testPaper/add/v1',
    method: 'post',
    data: data
  })
}
// 试卷分析
export function analysisPaper (data) {
  return request({
    url: '/api/testPaper/analysis/v1',
    method: 'post',
    data: data
  })
}
// 删除试卷
export function delPaper (data) {
  return request({
    url: '/api/testPaper/del/v1',
    method: 'post',
    data: data
  })
}
// 试卷列表--教师端
export function paperList (data) {
  return request({
    url: '/api/testPaper/list/v1',
    method: 'post',
    data: data
  })
}

// 试卷列表下拉框
export function listBoxPaper (data) {
  return request({
    url: '/api/testPaper/listBox/v1',
    method: 'post',
    data: data
  })
}
// 更新试卷
export function updatePaper (data) {
  return request({
    url: '/api/testPaper/update/v1',
    method: 'post',
    data: data
  })
}
// 增加用户
export function addUser (data) {
  return request({
    url: '/api/user/add/v1',
    method: 'post',
    data: data
  })
}
// 删除用户
export function delUser (data) {
  return request({
    url: '/api/user/del/v1',
    method: 'post',
    data: data
  })
}
// 用户列表
export function userList (data) {
  return request({
    url: '/api/user/list/v1',
    method: 'post',
    data: data
  })
}
// 用户登录
export function userLogin (data) {
  return request({
    url: '/api/user/login/v1',
    method: 'post',
    data: data
  })
}
// 更新密码
export function userPwd (data) {
  return request({
    url: '/api/user/restPassWord/v1',
    method: 'post',
    data: data
  })
}
// 更新用戶
export function updateUser (data) {
  return request({
    url: '/api/user/update/v1',
    method: 'post',
    data: data
  })
}
// 回答試卷
export function getAnswer (data) {
  return request({
    url: '/api/userPaper/addAnswer/v1',
    method: 'post',
    data: data
  })
}
// 查看試卷試題
export function getPaper (data) {
  return request({
    url: '/api/userPaper/getPaper/v1',
    method: 'post',
    data: data
  })
}
// 學生獲取成績
export function getScore (data) {
  return request({
    url: '/api/userPaper/getScore/v1',
    method: 'post',
    data: data
  })
}

export function setScore (data) {
  return request({
    url: '/api/userPaper/setScore/v1',
    method: 'post',
    data: data
  })
}

export function getItemScore (data) {
  return request({
    url: '/api/userPaper/getItemScore/v1',
    method: 'post',
    data: data
  })
}

export function getZHUGUANTIScore (data) {
  return request({
    url: '/api/userPaper/getZHUGUANTIScore/v1',
    method: 'post',
    data: data
  })
}