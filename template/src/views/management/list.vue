<template>
  <div class="all">
    <h3>试题列表</h3>
    <div class="detail">试题列表，您可以在如下列表中选择试题进行修改或删除</div>
    <el-row>
      <el-button type="info" @click="jump">新增客观题</el-button>
      <el-button type="info" @click="jump_item">新增主观题</el-button>
      <el-button>试题列表</el-button>
    </el-row>

    <el-form :inline="true" :model="formInline">
      <el-form-item label="试题类型:">
        <el-select v-model="type" placeholder="全部">
          <el-option label="单选题" value="unit"></el-option>
          <el-option label="判断题" value="judge"></el-option>
        </el-select>
      </el-form-item>
      <el-form-item label="试题难度:">
        <el-select v-model="difficulty" placeholder="全部">
          <el-option label="容易" value="easy"></el-option>
          <el-option label="常规" value="convention"></el-option>
          <el-option label="困难" value="difficulty"></el-option>
        </el-select>
      </el-form-item>
      <el-form-item label="试题状态:">
        <el-select v-model="state" placeholder="全部">
          <el-option label="开放" value="open"></el-option>
          <el-option label="关闭" value="close"></el-option>
        </el-select>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" @click="qurey()">查询</el-button>
      </el-form-item>
    </el-form>

    <template>
      <el-table :data="tableData" style="width:100%" stripe>
        <el-table-column prop="type" label="试题类型" ></el-table-column>
        <el-table-column prop="difficulty" label="试题难度" ></el-table-column>
        <el-table-column prop="state" label="试题状态" ></el-table-column>
        <el-table-column prop="stem" label="试题题干" ></el-table-column>
        <el-table-column label="操作">
          <template slot-scope="scope">
            <el-button size="mini"  @click="dialog(scope.row)">编辑</el-button>
            <el-button size="mini" type="danger" @click="handleDelete(scope.row)">删除</el-button>
          </template>
        </el-table-column>
      </el-table>
    </template>

    <el-dialog title="试卷修改" :visible.sync="dialogTableVisible" :before-close="handleClose">
      <el-form style="width:100%" :data="tableDataDialog">
        <el-form-item label="试题类型:">
          <el-input v-model="form1.type"></el-input>
        </el-form-item>
        <el-form-item label="试卷状态:">
          <el-input v-model="form1.state"></el-input>
        </el-form-item>
        <el-form-item label="试题难度:">
          <el-input v-model="form1.difficulty"></el-input>
        </el-form-item>
        <el-form-item label="试题题干:">
          <el-input v-model="form1.stem"></el-input>
        </el-form-item>
      </el-form>
      <el-button @click="submit" type="primary">提交</el-button>
    </el-dialog>
  </div>
</template>
<script>
import { testList } from "api/test";
import { delTest } from "api/test";
import { updateTest } from "api/test";
export default {
  data() {
    return {
      dialogTableVisible:false,
      formInline: {},
      type:'',
        difficulty:'',
        state:'',
      tableData: [],
      tableDataDialog:[],
      form1:{
        type:'',
        state:'',
        difficulty:'',
        stem:''
      }
    }
  },
  created(){
    this.TestList()
  },
  methods: {
    jump() {
      this.$router.push("manageTest")
    },
    jump_item() {
      this.$router.push("subjectiveItem")
    },
   qurey(){
     this.TestList()
   },
   dialog(row) {
     this.form1 = row;
     console.log("iiiii",this.form1)
     this.dialogTableVisible = true;
   },
    handleDelete(row) {
      this.deleteId = row.id;
      this.DelTest()
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
      this.UpdateTest()
      this.TestList()
    },
    async TestList () {
      let data = {
          difficulty: this.difficulty,
          state: this.state,
          type: this.type
      }
      let res = await  testList(data)
      if (res.code === '200') {
        this.tableData = res.data.data
        console.log(res)
      }
    },
     async DelTest () {
      let data = {
        id: this.deleteId
      }
      let res = await  delTest(data)
      if(res.code == '200'){
        this.TestList()
      }
    },
    async UpdateTest () {
      let data = {
         answerList: [
          {
            content: this.content,
            flag: true,
            option: this.option
          }
          ],
          content: this.content,
          difficulty: this.form1.difficulty,
          id: this.form1.id,
          state: this.form1.state,
          stem: this.form1.stem,
          type: this.form1.type
      }
      let res = await  updateTest(data)
      if(res){
        console.log(res);
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



