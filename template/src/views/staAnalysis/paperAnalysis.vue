<template>
  <div class="all">
    <h3>试卷分析</h3>
    <div class="detail">选择试卷查看分析题目正确率情况</div>
    <template>
      <el-table style="width:100%;" :data="tableData">
        <el-table-column prop="name" label="试卷名称" width="160"></el-table-column>
        <el-table-column prop="state" label="试卷状态" width="160"></el-table-column>
        <el-table-column prop="type" label="试卷类型" width="160"></el-table-column>
        <el-table-column prop="startTime" label="開始時間" width="160"></el-table-column>
        <el-table-column prop="endTime" label="結束時間" width="160"></el-table-column>
        <el-table-column prop="totalScore" label="卷面总分" width="160"></el-table-column>
        <el-table-column label="操作">
          <template slot-scope="scope">
            <el-button size="mini" @click="analysis(scope.row)" type="info">试卷分析</el-button>
          </template>
        </el-table-column>
      </el-table>
    </template>
  <el-dialog title="试卷分析" :visible.sync="dialogTableVisible" :before-close="handleClose">
       <div class="dialog">
      <!-- 所选择的试卷名称 -->
        <div class="dialog-label">2019年模拟考试卷</div>
        <!-- 循环的题目 -->
        <div class="dialog-item" >
            <div class="title">一、选择题</div>
            <div class="dialog-content"  v-for="(i,index) in option1">
              <div v-if="i.a==1">
                <div class="dig_cont">
                  <div>
                    <span style="margin-right:10px;color:#409eff">{{index+1}}</span>
                    <span>{{i.sub}}</span>
                  </div>
                  <div><span>正确率：</span><span>{{(index+1)*10+(7+index)}}</span><span>%</span></div>
                </div>
              </div>
            </div> 
            <div class="title">二、判断题</div>
            <div class="dialog-content"  v-for="(i,index) in option2">
              <div v-if="i.a==2" >
                 <div class="dig_cont">
                  <div>
                    <span style="margin-right:10px;color:#409eff">{{index+6}}</span>
                    <span>{{i.sub}}</span>
                  </div>
                  <div><span>正确率：</span><span>{{(index+2)*10+(6+index)}}</span><span>%</span></div>
                </div>
              </div>
            </div>
             <div class="title">三、主观题</div>
            <div class="dialog-content subitem" >
              <div v-if="zhuguanti.a==3" class="subite_cont">
                 <div>
                  <span style="margin-left:5px;margin-right:10px;color:#409eff">11</span>
                  <span>{{zhuguanti.con}}</span>
                 </div>
                <div class="DA"><span>正确率：</span><span>58</span><span>%</span></div>
              </div>
            </div>
          </div>
        <el-button style="margin-left:50px;margin-top:20px;" @click="submit" type="primary">返回</el-button>
      </div>
    </el-dialog>
    </div>
  </template>
<script>
import { paperList } from 'api/test'
import { getPaper } from 'api/test'
export default {
  data() {
     return {
       option1:[{},{},{},{},{}],
       option2:[{},{},{},{},{}],
       objectItm:[],
       tableData:[],
       dialogTableVisible:false,
       id:"",
       radio:"",
       zhuguanti:{
       con:"",
       a:""
      },
      flag:[{},{}],
     }
  },
  created(){
    this.PaperList()
  },
  methods: {
    analysis(row){
      this.dialogTableVisible=true,
      this.id = row.id
      this.GetPaper()
    },
    handleClose(done){
      this.$confirm('确认关闭？')
        .then(_ => {
          done();
        })
        .catch(_ => {});
    },
    submit(){
     this.dialogTableVisible = false;
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
     async GetPaper(){
      let data = {
       id:this.id
      }
      let res = await getPaper(data)
      if (res.code == '200' ){
        this.objectItm = res.data
        console.log( res.data )
        var i=0
        var j=0
        this.option2.length=5
        for(var item = 0,len = res.data.length;item<len;item++){
          if(res.data[item].sResponse.type == 'unit'){
            var str = res.data[item].sResponse.content
            var strs = str.split("/")
            this.option1[i].sub=res.data[item].sResponse.stem
            this.option1[i].opt = strs
            this.option1[i].a = 1
            i++
          }else if(res.data[item].sResponse.type == 'judge'){
            this.option2[j].a=2
            this.option2[j].sub=res.data[item].sResponse.stem
            j++
          }else{
            this.zhuguanti.con=res.data[item].sResponse.stem
            this.zhuguanti.a=3
          }
        }
      }
    }
  }
}
</script>

<style lang="scss" scoped>
.all{
  padding-left: 30px;
}
.detail {
  color: $detailColor;
  font-size: 14px;
  margin-bottom:20px;
}
.dialog{
  .dialog-label{
    font-size: 24px;
    text-align: center;
  }
  .dialog-item{
    margin-top: 20px;
      .dialog-content{
        border:1px solid #f1f9f9;
        margin-top:10px;
      }
  }
  .dig_cont{
    display:flex;
    justify-content: space-between;
    line-height:30px;
  }
  .dig_cont>div:nth-of-type(1){
    display:flex;
    align-items:center;
    padding-left:5px;
  }
  .dig_cont>div:nth-of-type(2),.DA{
    padding:5px;
    background:#c3ced9;
  }
  .subitem{
    line-height:30px;
  }
  .subite_cont{
    display:flex;
    justify-content:space-between;
  }
  .subite_cont>div:nth-of-type(1){
    display:flex;
    align-items:center;
  }
}
.title{
  font-weight:600;
}
</style>

