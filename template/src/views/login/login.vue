<template>
   <div class="login">
    <div class="login-cont">
      <div class="login-input">
        <span>账户：</span>
        <el-input v-model="account" placeholder="请输入账户"></el-input>
      </div>
      <div class="login-input">
        <span>密码：</span>
        <el-input v-model="passWord" placeholder="请输入密码"></el-input>
      </div>
      <div class="login-role">
        <el-radio-group v-model="role" size="mini">
            <el-radio label="student" border>学生</el-radio>
            <el-radio label="teacher" border>教师</el-radio>
            <el-radio label="Admin" border>管理员</el-radio>
        </el-radio-group>
      </div>
      <el-button type="primary" @click="login()">登入</el-button>
    </div>
  </div>
</template>


<script>
import { userLogin } from 'api/test'
export default {
  data () {
    return {
      account: '',
      passWord: '',
      role:''
    }
  },
  created () {
    // this.loginUserTest()
  },
  methods: {
    login () {
      if (this.account !== '' && this.passWord !== '') {
        this.loginUserTest()
      }
    },
    async loginUserTest () {
      let data = {
        account: this.account,
        passWord: this.passWord
      }
      try{ 
          let res = await userLogin(data)
          console.log("res1",res)
          if (res.code === '200') {
            if(res.data.role == this.role){
              this.$message({
                type: 'success',
                message: '登陆成功'
              })
              let account=res.data.account
              let role = res.data.role
              sessionStorage.setItem('account', JSON.stringify(res.data.account))
              sessionStorage.setItem('role', JSON.stringify(res.data.role)) 
              sessionStorage.setItem('userId', JSON.stringify(res.data.id))
              this.$router.push('home') 
              }
          } else {
            this.$message({
              type: 'error',
              message: res.message
            })
          }
      }catch(err){
        console.log(err)
      }
    }
  }
}
</script>
<style lang="scss" scoped>
.login{
  position: fixed;
  top: 0;
  bottom: 0;
  right: 0;
  left: 0;
  background: url("../../common/images/login1.jpg") no-repeat;
  background-size: 100% 100%;
  .login-cont{
    position: absolute;
    width: 400px;
    padding: 0 0 30px 0;
    // background: #fff;
    top: 50%;
    left: 50%;
    transform: translate(-50%, -50%);
    .login-input{
      overflow: hidden;
      margin-top: 30px;
      span{
        display: block;
        float: left;
        width: 80px;
        height: 40px;
        line-height: 40px;
        text-align: center;
      }
      /deep/ .el-input {
        display: block;
        float: left;
        width: 300px;
        height: 50px;
        input{
          background: #f1f1f1;
        }
      
      }
    }
    /deep/ .el-button{
      margin: 20px auto 0;
      display: block;
      width: 100px;
    }
    .login-role{
      margin-left: 80px;
      margin-top: 20px;
    }
  }
}
</style>
