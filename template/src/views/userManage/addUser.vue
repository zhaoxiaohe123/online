<template>
  <div class="all">
    <h3>新增用户</h3>
    <div class="detail">填写下面的表单，创建新的用户</div>
    <el-row>
      <el-button>新增用户</el-button>
      <el-button type="info" @click="jump">用户列表</el-button>
    </el-row>

    <el-form :model="form" label-width="100px" ref="form">
      <el-form-item label="用户名:" prop="account">
        <el-input v-model="form.account" style="width:205px;"></el-input>
      </el-form-item>
      <el-form-item label="用户密码:" prop="passWord">
        <el-input v-model.number="form.passWord" style="width:205px;"></el-input>
      </el-form-item>
      <el-form-item label="用户身份：" prop="role">
        <el-select v-model="form.role" placeholder="请选择">
          <el-option label="管理员" value="Admin"></el-option>
          <el-option label="老师" value="teacher"></el-option>
          <el-option label="学生" value="student"></el-option>
        </el-select>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" @click="submit()">提交</el-button>
        <el-button @click="cancel('form')">重置</el-button>
      </el-form-item>
    </el-form>
  </div>
</template>

<script>
import { addUser } from 'api/test'
export default {
  data() {
    return {
      form: {
        account: '',
        passWord: '',
        role: ''
      }
    }
  },
  methods: {
    jump() {
      this.$router.push("userList");
    },
    submit() {
      if(this.form.account !=='' && this.form.passWord !=='' && this.form.role !==''){
        this.AddUser()
      }else{
        this.$message({
          type:'err',
          message:'不允许为空'
        })
      }
    },
    cancel(formName) {
      this.$refs[formName].resetFields();
    },
    async AddUser(){
      let data = {
        account: this.form.account,
        passWord: this.form.passWord,
        role: this.form.role,
        id:''
      }
      try{
        let res = await addUser(data)
        if ( res.code === '200'){
          this.$message({
            type: 'success',
            message: '请求成功'
          }) 
         this.$router.push('userList')
        } 
      } catch( err ){
        console.log(err)
      }
    }
  }
};
</script>

<style scoped lang="scss">
.all {
  padding-left: 30px;
}
.detail {
  color: $detailColor;
  font-size: 14px;
}
.el-row {
  margin: 20px 0;
}
span {
  color: $fontColor;
}
</style>

