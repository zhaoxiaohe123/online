<template>
  <div class="all">
    <h3>试题列表</h3>
    <div class="detail">试题列表，您可以在如下列表中选择试题进行查看</div>
    <template>
      <el-table :data="tableData">
        <el-table-column prop="name" label="试卷名称" width="160px;"></el-table-column>
        <el-table-column prop="startTime" label="開始時間" width="160px;"></el-table-column>
        <el-table-column prop="endTime" label="結束時間" width="160px;"></el-table-column>
        <el-table-column prop="type" label="考试类型" width="160px;"></el-table-column>
        <el-table-column prop="totalScore" label="卷面总分" width="160px;"></el-table-column>
        <el-table-column label="操作">
          <template slot-scope="scope">
            <el-button size="mini" @click="handleEdit(scope.row)" type="info">开始考试</el-button>
          </template>
        </el-table-column>
      </el-table>
    </template>
    <el-dialog title="开始考试" :visible.sync="dialogTableVisible" :before-close="handleClose">
       <div class="dialog">
      <!-- 所选择的试卷名称 -->
        <div class="dialog-label">2019年模拟考试卷</div>
        <!-- 循环的题目 -->
        <div class="dialog-item" >
            <div class="title">一、选择题</div>
            <div class="dialog-content"  v-for="(i,ind) in option1">
              <div v-if="i.a==1" class="dialog_item">
                <div >
                  <span style="margin-right:10px;color:#409eff">{{ind+1}}</span>
                  <span>{{i.sub}}</span>
                </div>
                <el-radio-group v-model="radio[ind]">
                  <div v-for="(j,index) in i.opt">
                    <el-radio :label="index"><span class="stem" >{{j}}</span></el-radio>
                  </div>
                </el-radio-group>
              </div>
            </div> 
            <div class="title">二、判断题</div>
            <div class="dialog-content"  v-for="(i,index) in option2">
              <div v-if="i.a==2"  class="dialog_item">
                 <div>
                  <span style="margin-right:10px;color:#409eff">{{index+6}}</span>
                  <span>{{i.sub}}</span>
                 </div>
                <el-radio-group v-model="flag[index]" >
                    <el-radio :label="index*2">正确</el-radio>
                    <el-radio :label="index*2+1">错误</el-radio>
                </el-radio-group>
              </div>
            </div>
            <div class="title">三、主观题</div>
            <div class="dialog-content" >
              <div v-if="zhuguanti.a==3"  class="dialog_item">
                 <div >
                  <span style="margin-right:10px;color:#409eff">11</span>
                  <span>{{zhuguanti.con}}</span>
                 </div>
                <textarea v-model="daan"></textarea>
              </div>
            </div>
          </div>
        <el-button style="margin-left:50px;margin-top:20px;" @click="submit" type="primary">提交</el-button>
      </div>
    </el-dialog>
    <el-dialog  title="成绩" :visible.sync="dialogScoreVisible">
      <div class="dialog_title">
        <div>客观题所得分为： {{score}}</div>
        <div >主观题请耐心等待</div>
        <el-button @click="exit" type="primary" plain>请前往登出</el-button>
      </div>
    </el-dialog>
  </div>
</template>
<script>
import { paperList } from 'api/test'
import { getPaper } from 'api/test'
import { setScore } from 'api/test'
export default {
  data() {
    return {
      option1:[{},{},{},{},{}],
      option2:[{},{},{},{},{}],
      objectItm:[],
      answer1:[{},{},{},{},{}],
      answer2:[{},{},{},{},{}],
      dialogTableVisible:false,
      dialogScoreVisible:false,
      form: {
        name: '',
        type: ''
      },
      radio:[{},{},{},{},{}],
      zhuguanti:{
        con:"",
        a:""
      },
      flag:[{},{},{},{},{}],
      tableData: [],
      score:0,
      daan:"",
      paperid:""
    };
  },
  created(){
    this.PaperList()
    // this.GetAnswer()
   
  },
  methods:{
    submit(){
     this.dialogTableVisible = false;
     var score=0
     for(var i = 0,len = this.radio.length;i<len;i++){
       if(this.radio[i]=="0"){
         this.radio[i]="A"
       }else if(this.radio[i]=="1"){
         this.radio[i]="B"
       }else if(this.radio[i]=="2"){
         this.radio[i]="C"
       }else if(this.radio[i]=="3"){
         this.radio[i]="D"
       }
     }
     for(var i = 0,len = this.flag.length;i<len;i++){
       if(this.flag[i]%2==0){
         this.flag[i]="1"
       }else if(this.flag[i]%2!=0){
         this.flag[i]="0"
       }
     }
     for(var i = 0,len = this.radio.length;i<len;i++){
       if(this.radio[i]==this.answer1[i]){
         score+=10
       }
     }
      for(var i = 0,len = this.flag.length;i<len;i++){
       if(this.flag[i]==this.answer2[i]){
         score+=10
       }
     }
     this.score=score
     this.SetAllScore()
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
      }
    },
    handleEdit(row){
      this.paperid = row.id
     this.form1 = row;
      this.GetPaper()
     this.dialogTableVisible = true;
    },
    handleClose(done){
      this.$confirm('确认关闭？')
        .then(_ => {
          done();
        })
        .catch(_ => {});
    },
    exit(){
      this.$message('退出学生端，考试结束')
      this.$router.push('login')
    },
    async SetAllScore(){
      let data={
        score:this.score,
        daan:this.daan,
        id:this.paperid,
        userid: JSON.parse(sessionStorage.getItem('userId'))
      }
      let res = await setScore(data)
      if ( res.code == '200'){
        this.dialogScoreVisible=true
      }
    },
    async GetPaper(){
      let data = {
       id:this.form1.id
      }
      let res = await getPaper(data)
      if (res.code == '200' ){
        console.log(res)
        var i=0
        var j=0
        var k=0
        var l=0
        this.option2.length=5
        for(var item = 0,len = res.data.length;item<len;item++){
          if(res.data[item].sResponse.type == 'unit'){
            this.answer1[k] = res.data[item].aResponse[0].option
            var str = res.data[item].sResponse.content
            var strs = str.split("/")
            this.option1[i].sub=res.data[item].sResponse.stem
            this.option1[i].opt = strs
            this.option1[i].a = 1
            i++
            k++
          }else if(res.data[item].sResponse.type == 'judge'){
            this.answer2[l] = res.data[item].aResponse[0].flag
            this.option2[j].a=2
            this.option2[j].sub=res.data[item].sResponse.stem
            j++
            l++
          }else{
            this.zhuguanti.con=res.data[item].sResponse.stem
            this.zhuguanti.a=3
          }
        }
        
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
  margin-bottom: 20px;
}
.dialog{
  .dialog-label{
    font-size: 24px;
    text-align: center;
  }
  .dialog-item{
    margin-top: 20px;
    margin-left:20px;
      .dialog-content{
        margin:10px 0;
        border: 1px solid #cac5c5;
        padding: 7px;
        .stem{
          line-height: 30px;
          text-align: left;
          width: 100%;
          margin-left: 5px;
        }
      }
  }
}
.title{
  font-weight:600;
}
.dialog_item>div:nth-of-type(1){
  line-height:30px;
}
.el-radio-group{
  margin-left:20px;
}
textarea{
  margin-left:20px;
  width: 231px;
}
.dialog_title{
  text-align:center;
  .el-button{
    margin-top:10px;
  }
}
.dialog_title>div:nth-of-type(1){
  margin:10px;
}
</style>


