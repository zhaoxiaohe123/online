<template>
  <div class="all">
    <h3>用户列表</h3>
    <div class="detail">您可以在如下列表中选择用户进行修改或删除</div>
    <el-row>
      <el-button type="info" @click="jump">新增用户</el-button>
      <el-button>用户列表</el-button>
    </el-row>

    <template>
      <el-table
        :data="tableData"
        stripe>
        <el-table-column prop="account" label="用户名" width="200"></el-table-column>
        <el-table-column prop="passWord" label="密码" width="200"></el-table-column>
        <el-table-column prop="role" label="用户身份" width="200"></el-table-column>
        <el-table-column prop="createTime" label="创建时间" width="200">
          <template slot-scope="scope">
            <span>{{  scope.row.createTime | timestamp }}</span>
          </template>
        </el-table-column>
        <el-table-column label="操作">
          <template slot-scope="scope"> 
            <el-button size="mini" type="info" @click="Edit(scope.row)">编辑</el-button>
            <el-button size="mini" type="danger" @click="Delete(scope.row)">删除</el-button>
          </template>
        </el-table-column>
      </el-table>
    </template>
     <el-dialog title="用户管理" :visible.sync="dialogTableVisible" :before-close="handleClose">
      <el-form style="width:100%" :data="tableDataDialog">
        <el-form-item label="用户名:">
          <el-input v-model="form.account"></el-input>
        </el-form-item>
        <el-form-item label="用户密码:">
          <el-input v-model="form.passWord"></el-input>
        </el-form-item>
        <el-form-item label="用户身份:">
          <el-input v-model="form.role"></el-input>
        </el-form-item>
      </el-form>
      <el-button @click="submit" type="primary">提交</el-button>
    </el-dialog>
  </div>
</template>

<script>
import {delUser} from 'api/test'
import {userList} from 'api/test'
import {updateUser} from 'api/test'
export default {
  data() {
    return {
      dialogTableVisible:false,
      tableDataDialog:[],
      pageNum:0,
      pageSize:0,
      tableData: [],
      form:{
        account:"",
        passWord:'',
        role:''
      }
    }
  },
  created(){
    // this.DelUser()
    this.UserList()
    // this.UpdateUser()
  },
  filters: {
    timestamp (time) {
      var date = new Date(time)
      var Y = date.getFullYear()
      var M = date.getMonth() + 1
      var D = date.getDate()
      M = M < 10 ? '0' + M : M
      D = D < 10 ? '0' + D : D
      var h = date.getHours() + ':'
      var m = date.getMinutes()
      m = m < 10 ? '0' + m : m
      return Y + '-' + M + '-' + D + ' ' + h + m
    }
  },
  methods: {
    jump() {
      this.$router.push("addUser");
    },
    Delete(row) {
      this.deleteId = row.id;
      this.DelUser()
    },
    Edit(row){
      console.log(row)
      this.form = row;
      this.dialogTableVisible = true;
    },
    submit(){
      this.dialogTableVisible = false;
      this.UpdateUser()
    },
     handleClose(done){
      this.$confirm('确认关闭？')
        .then(_ => {
          done();
        })
        .catch(_ => {});
    },
     async DelUser(){
      let data = {
        id: this.deleteId
      }
      try{
        let res = await delUser(data)
        if (res.code === '200' ){
          this.UserList()
        }
      } catch (err) {
        console.log(err)
      }
      
    },
    async UserList(){
      let data = {
        pageNum: this.pageNum,
        pageSize: this.pageSize,
        role: this.role
      }
      try {
        let res =await userList(data)
        if (res.code === '200'){
          this.tableData = res.data.list
          console.log('USER_LIST',res.data.list)
        }else{
          console.log(err)
        }
      } catch (err){
        console.log (err)
      }
    },
    async UpdateUser(){
      let data = {
        account: this.form.account,
        id: this.form.id,
        passWord: this.form.passWord,
        role: this.form.role
      }
      let res = await updateUser(data)
      if (res ){
        console.log( res )
      }
    },
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

</style>

