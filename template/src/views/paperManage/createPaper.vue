<template>
  <div class="all">
    <h3>创建试卷</h3>
    <div class="detail">填写下面的表单，创建试卷。</div>
    <el-row>
      <el-button>创建试卷</el-button>
      <el-button type="info" @click="jump">试卷列表</el-button>
    </el-row>

    <el-form :inline="true" ref="form" :rules="rules" :model="form" label-width="120px">
      <el-form-item label="试卷名称:" prop="name">
        <el-input v-model="form.name" style="width:600px;"></el-input>
      </el-form-item>
      <br>
      <el-form-item label="试卷类型:" prop="type">
        <el-select v-model="form.type" placeholder="请选择">
          <el-option label="普通试卷" value="common"></el-option>
          <el-option label="随机试卷" value="random"></el-option>
        </el-select>
      </el-form-item>
      <el-form-item label="考试状态:" prop="state" style="margin-left:65px;">
        <el-select v-model="form.state" placeholder="请选择">
          <el-option label="开放" value="open"></el-option>
          <el-option label="关闭" value="close"></el-option>
        </el-select> 
      </el-form-item>
      <br>
      <el-form-item label="开考时间:" prop="startTime">
        <el-col :span="22">
          <el-date-picker
            type="datetime"
            placeholder="选择日期"
            v-model="form.startTime"
            style="width: 100%;"
          ></el-date-picker>
        </el-col>
      </el-form-item>
      <el-form-item label="结束时间:" prop="endTime" style="margin-left:52px;">
        <el-col :span="22">
          <el-date-picker
            type="datetime"
            placeholder="选择日期"
            v-model="form.endTime"
            style="width: 100%;"
          ></el-date-picker>
        </el-col>
      </el-form-item>
      <br>
      <el-form-item label="公布时间:" prop="publicTime">
        <el-col :span="22">
          <el-date-picker
            type="datetime"
            placeholder="选择日期"
            v-model="form.publicTime"
            style="width: 100%;"
          ></el-date-picker>
        </el-col>
      </el-form-item>
      <el-form-item label="卷面总分:" prop="totalScore" style="margin-left:50px;">
        <el-input v-model="form.totalScore" style="width:200px;"></el-input>
      </el-form-item>
      <br>
      <el-form-item label="及格分数:" prop="passScore">
        <el-input v-model="form.passScore" style="width:200px;"></el-input>
      </el-form-item>
      <br>
      <el-form-item label="试卷说明:" prop="explain">
        <el-input type="textarea" v-model="form.explain" style="width:600px;"></el-input>
      </el-form-item>
      <el-form-item style="display:block ;margin-left:100px;">
        <el-button type="primary" @click="submit">提交</el-button>
        <el-button @click="reset('form')">重置</el-button>
      </el-form-item>
    </el-form>
  </div>
</template>

<script>
import {addPaper} from 'api/test'
export default {
  data() {
    return {
      form: {
        name: '', 
        type: '',
        state: '',
        startTime: '',
        endTime: '',
        publicTime: '',
        totalScore: '',
        passScore: '',
        explain: ''
      },
      rules: {
        name: [{ required: true, message: "名称不允许为空", trigger: "blur" }],
        type: [
          { required: true, message: "请选择试卷类型", trigger: "change" }
        ],
        state: [
          { required: true, message: "请选择试卷状态", trigger: "change" }
        ],
        startTime: [
          { required: true, message: "请选择开考时间", trigger: "change" }
        ],
        endTime: [
          { required: true, message: "请选择结束时间", trigger: "change" }
        ],
        publicTime: [
          { required: true, message: "请选择公布时间", trigger: "change" }
        ],
        totalScore: [{ required: true, message: "不允许为空", trigger: "blur" }],
        passScore: [{ required: true, message: "不允许为空", trigger: "blur" }],
        explain: [{ required: true, message: "不允许为空", trigger: "blur" }]
      }
    };
  },
  created(){
    // this.AddPaper()
  },
  methods: {
    jump() {
      this.$router.push("paperList");
    },
    submit() {
      this.AddPaper()
    },
    reset(formName) {
      this.$refs[formName].resetFields();
    },
    async AddPaper(){
      const date = new Date();
      let data = {
          id: "",
          name: this.form.name,                  
          type: this.form.type,                  
          state: this.form.state,               
          startTime: new Date(this.form.startTime).getTime(),        
          endTime: new Date(this.form.endTime).getTime(),            
          publicTime: new Date(this.form.publicTime).getTime(),      
          totalScore: this.form.totalScore,      
          passScore: this.form.passScore,        
          explain: this.form.explain          
      }
      try{
        let res = await addPaper(data)
        if(res.code === '200'){
          this.$message({
            type: 'success',
            message: '请求成功'
          }) 
          let name = res.data.name
          let state = res.data.state
          let type = res.data.type
          sessionStorage.setItem('name', JSON.stringify(res.data.name))
          sessionStorage.setItem('state', JSON.stringify(res.data.state))
          sessionStorage.setItem('type', JSON.stringify(res.data.type))
          sessionStorage.setItem('paperId', JSON.stringify(res.data.id))
          this.$router.push('paperList')
        }else {
            this.$message({
              type: 'error',
              message: res.message
            })
          }
      } catch (err){
        console.log(err)
      }
    } 
  }
}
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

