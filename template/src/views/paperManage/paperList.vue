<template>
  <div class="all">
    <h3>试卷列表</h3>
    <div class="detail">试卷列表，您可以在如下列表中选择试卷进行修改或删除。</div>
    <el-row>
      <el-button type="info" @click="jump">创建试卷</el-button>
      <el-button>试卷列表</el-button>
    </el-row>

    <el-form :inline="true" :model="forminline">
      <el-form-item label="试卷名称:">
        <el-input v-model="name"></el-input>
      </el-form-item>
      <el-form-item label="试卷类型:">
        <el-select v-model="type" placeholder="全部">
          <el-option label="普通试卷" value="common"></el-option>
          <el-option label="随机试卷" value="random"></el-option>
        </el-select>
      </el-form-item>
      <el-form-item label="试题状态:">
        <el-select v-model="state" placeholder="全部">
          <el-option label="开放" value="open"></el-option>
          <el-option label="关闭" value="close"></el-option>
        </el-select>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" @click="onSubmit">查询</el-button>
      </el-form-item>
    </el-form>

    <template>
      <el-table style="width:100%;" :data="tableData">
        <el-table-column prop="name" label="试卷名称" width="160"></el-table-column>
        <el-table-column prop="state" label="试卷状态" width="100"></el-table-column>
        <el-table-column prop="type" label="试卷类型" width="100"></el-table-column>
        <el-table-column prop="totalScore" label="卷面总分" width="100"></el-table-column>
        <el-table-column prop="startTime" label="开始时间" width="160"></el-table-column>
        <el-table-column prop="endTime" label="结束时间" width="160"></el-table-column>
        <el-table-column label="操作">
          <template slot-scope="scope">
            <el-button size="mini" @click="handleEdit( scope.row)">编辑</el-button>
            <el-button size="mini" type="danger" @click="handleDelete(scope.row)">删除</el-button>
          </template>
        </el-table-column>
      </el-table>
    </template>

     <el-dialog title="试卷修改" :visible.sync="dialogTableVisible" :before-close="handleClose">
      <el-form style="width:100%" :data="tableDataDialog">
        <el-form-item label="试卷名称:">
          <el-input v-model="form1.name"></el-input>
        </el-form-item>
        <el-form-item label="试卷类型:">
          <el-input v-model="form1.type"></el-input>
        </el-form-item>
        <el-form-item label="试卷状态:">
          <el-input v-model="form1.state"></el-input>
        </el-form-item>
      </el-form>
      <el-button @click="submit()" type="primary">提交</el-button>
    </el-dialog>
    
    
  </div>
</template>

<script>
import { paperList } from 'api/test'
import { delPaper } from 'api/test'
import { updatePaper } from 'api/test'
export default {
  data () {
    return {
      dialogTableVisible:false,
      forminline: {},
      name: "",
      type: "",
      state: "",
      tableData: [],
      tableDataDialog:[],
      form1:{
        type:"",
        state:"",
        name:""
      }
    };
  },
  created(){
    this.PaperList()
  },
  methods: {
    jump() {
      this.$router.push("createPaper");
    },
    handleEdit(row){
     this.form1 = row;
     console.log(row)
     this.dialogTableVisible = true;
    },
    handleDelete( row) {
      this.deleteId = row.id;
      this.DelPaper()
    },
    onSubmit() {
      this.PaperList()
    },
     handleClose(done){
      this.$confirm('确认关闭？')
        .then(_ => {
          done();
        })
        .catch(_ => {});
    },
    submit(){
      this.dialogTableVisible=false;
      this.UpdatePaper()
      this.PaperList()
    },
    async PaperList () {
      let data = {
          name: this.name,
          pageNum: 0,
          pageSize: 0,
          state: this.state,
          type: this.type
      }
      let res = await paperList(data)
      if ( res.code === '200' ){
        this.tableData = res.data.data
        console.log(res.data.data)
      }
    },
    async DelPaper(){
      let data={
        id:this.deleteId
      }
      let res=await delPaper(data)
      if(res.code === '200'){
        this.PaperList()
      }
    },
    async UpdatePaper(){
      let data={
          endTime: 0,
          explain: this.explain,
          id: this.form1.id,
          name: this.form1.name,
          passScore: 0,
          publicTime: 0,
          startTime: 0,
          state: this.form1.state,
          totalScore: 0,
          type: this.form1.type
      }
      let res=await updatePaper(data)
      if(res.code=='200'){
        console.log(res)
      }else if(res.code=='500'){
        alert(res.message)
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
.block {
  margin-top: 40px;
}
.block > span {
  cursor: pointer;
  margin-left: 20px;
  color: #2370d0;
}
</style>


