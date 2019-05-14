<!--
<template>
    <div class="all">
        <div class="title">
            <div>题 目：</div>
            <textarea v-model="zhuguan"></textarea>
        </div>
        <div>
            <span>结 果：</span>
            <el-input v-model="jieguo"></el-input>
        </div>
    </div>
</template>
-->

 
 
 
 <template>
    <!--<div>
        <span class="title" style="color:red">主观题答案</span>
    </div>-->
    
      <el-table :data="tableData" style="width:70%" stripe>
        <el-table-column prop="stem" label="主观题题目" ></el-table-column>
        <el-table-column prop="sum" label="主观题结果" ></el-table-column>
        <el-table-column prop="score" label="主观题结果" >
            <template slot-scope="scope">
            <el-input v-model="score"></el-input>
            <el-button  type="primary" plain @click="submit" style="margin-top:5px;">提交</el-button>
          </template>
        </el-table-column>
      </el-table>
        
 </template>
<script>
import {getItemScore} from 'api/test'
import {getZHUGUANTIScore} from 'api/test'
    export default {
        data () {
            return {
               tableData:[{
                   stem:'',
                   sum:''
               }],
               score:'',
               studentid:"",
               id:"",
               userpaperid:""
            }
        },
        created(){
            this.getZHUGUANTI()
        } ,
        methods:{
            submit(){
                this.getZHUGUANTIScore()
            },
            async getZHUGUANTI(){
                let data = {
                }
                let res = await getItemScore(data)
                if(res.code == '200'){
                    this.tableData[0].stem = res.data.zhuguanti
                    this.tableData[0].sum = res.data.answer
                    this.studentid = res.data.subjectId
                    this.userpaperid = res.data.userpaperid
                    this.id = res.data.id
                    console.log(this.tableData[0])
                    console.log(res.data)
                }
            },
            async getZHUGUANTIScore(){
                let data = {
                    score:this.score,
                    id:this.id,
                    userid:this.studentid
                }
                let res = await getZHUGUANTIScore(data)
                if(res.code == '200'){
                    this.$message("主观题批阅成功！")
                }
            },
        }
    }
</script>
<style scoped lang="scss">
// .all {
//   padding-left: 30px;
//   margin-top:50px;
// }
// .el-input {
//   width: 180px;
//   margin-top:20px;
// }
// .title{
//     display:flex;
// }
.title{
    font-size:24px;
    margin:30px;
    color:red;
}
.el-table{
    margin:50px 100px;
}
</style>