<template>
  <div class="all">
    <h3>考试分析</h3>
    <div class="detail">选择试卷查看分析考试的统计情况</div>

    <div class="choose-input">
      <span>选择试卷：</span>
       <el-select v-model="select" @change="selectXX" placeholder="请选择">
        <el-option
          v-for="item in options"
          :key="item.id"
          :label="item.name"
          :value="item.id">
        </el-option>
      </el-select>
    </div>

    <el-form label-width="100px;" :model="form">
      <el-form-item label="分数统计：">
        <el-form :model="form" class="form-detail" :inline="true">
          <el-form-item label="最高分">
            <el-input v-model="form.maxScore"></el-input>
          </el-form-item>
          <br>
          <el-form-item label="最低分">
            <el-input v-model="form.minScore"></el-input>
          </el-form-item>
          <br>
          <el-form-item label="平均分">
            <el-input v-model="form.average"></el-input>
          </el-form-item>
        </el-form>
      </el-form-item>
      <el-form-item label="用户统计：">
        <el-form :model="form" class="form-detail" :inline="true">
          <el-form-item label="及格人数">
            <el-input v-model="form.passPerson"></el-input>
          </el-form-item>
          <br>
          <el-form-item label="实际人数">
            <el-input v-model="form.totalPerson"></el-input>
          </el-form-item>
        </el-form>
      </el-form-item>
    </el-form>
  </div>
</template>

<script>
import { analysisPaper } from 'api/test';
import { paperList } from 'api/test';
export default {
  data() {
    return {
      select:"",
      options:[],
      id:'',
      tableData:[],
      form: {
        maxScore: '',
        minScore: '',
        average: '',
        passPerson: '',
        totalPerson: '',
        passRate: ''
      }
    };
  },
  created(){
    this.PaperList()
    // this.AnalysisPaper(a)
  },
  methods: {
    selectXX(a){
      this.AnalysisPaper(a)
      console.log(a)
    },
    async AnalysisPaper(a){
      let data = {
        id:a
      }
      let res = await analysisPaper(data)
      if (res ){
        this.form =res.data
        console.log( res )
      }
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
        this.options = res.data.data
        console.log(res.data.data)
      }
    },
    handleClose(done){
      this.$confirm('确认关闭？')
        .then(_ => {
          done();
        })
        .catch(_ => {});
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
  margin-bottom: 20px;
}
.el-input {
  display: block;
}
.form-detail {
  margin-left: 100px;
}
.choose-input{
  overflow: hidden;
  margin-top: 30px;
  line-height: 40px;
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
  }
  i{
    margin-left: 10px;
  }
}
</style>

