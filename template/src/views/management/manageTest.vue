<template>
  <div class="all">
    <h3>新增试题</h3>
    <div class="detail">填写下面的表单，创建新的试题。选择不同的试题类型，需要填写的表单也各不相同。</div>
    <el-row>
      <el-button >新增客观题</el-button>
       <el-button type="info" @click="jump_item">新增主观题</el-button>
      <el-button type="info" @click="jump">试题列表</el-button>
    </el-row>

    <el-form :inline="true" ref="form" :rules="rules" :model="form" label-width="100px">
      <el-form-item label="试题类型：" prop="type">
        <el-select v-model="form.type" placeholder="请选择">
          <el-option label="单选题" value="unit"></el-option>
          <el-option label="判断题" value="judge"></el-option>
        </el-select>
      </el-form-item>
      <el-form-item label="试题难度：" prop="difficulty">
        <el-select v-model="form.difficulty" placeholder="请选择">
          <el-option label="容易" value="easy"></el-option>
          <el-option label="常规" value="convention"></el-option>
          <el-option label="困难" value="difficulty"></el-option>
        </el-select>
      </el-form-item>
      <br>
      <el-form-item label="所属状态" prop="state">
        <el-select v-model="form.state" placeholder="请选择">
          <el-option label="开放" value="open"></el-option>
          <el-option label="关闭" value="close"></el-option>
        </el-select>
      </el-form-item>
      <el-form-item label="单题分值：" prop="grade">
        <el-input v-model="form.grade"  disabled></el-input>
      </el-form-item>
      <br>
      <el-form-item label="试题题干：" prop="stem">
        <el-input type="textarea" v-model="form.stem"></el-input>
      </el-form-item>
      <br>
      <el-form-item label="答案设置：" prop="setting">
        <el-radio-group @change = "select" v-model="answerList[0].option" type="setting" v-if="form.type==='unit'">
          <el-radio label="A">选项A</el-radio>
          <el-input type="textarea"  v-model="SA"  rows="1" class="choose"></el-input>
          <br>
          <el-radio label="B">选项B</el-radio>
          <el-input type="textarea" v-model="SB" rows="1" class="choose"></el-input>
          <br>
          <el-radio label="C">选项C</el-radio>
          <el-input type="textarea" v-model="SC" rows="1" class="choose"></el-input>
          <br>
          <el-radio label="D">选项D</el-radio>
          <el-input type="textarea" v-model="SD" rows="1" class="choose"></el-input>
          <br>
        </el-radio-group>
        <el-radio-group
          v-model="answerList[0].flag"
          type="setting"
          style="display:block"
          v-if="form.type==='judge'"
        >
          <el-radio label=true>正确</el-radio>
          <el-radio label=false>错误</el-radio>
        </el-radio-group>
      </el-form-item>
      <br>
     
      <el-form-item style="display:block ;margin-left:100px;">
        <el-button type="primary" @click="sumbit()">提交</el-button>
        <el-button @click="resetForm('form')">重置</el-button>
      </el-form-item>
    </el-form> 
  </div>
</template>

<script>
import { addTest } from  'api/test'
export default {
  data() {
    return {
      SA:"",
      SB:"",
      SC:"",
      SD:"",
      form: {
        type: "",
        difficulty: "",
        state: "",
        grade: "10",
        stem: ""
      },
       answerList:[
         {
            content: "",
            flag: "",
            option: ""
         }
       ],
      rules: {
        type: [
          { required: true, message: "请选择试题类型", trigger: "change" }
        ],
        difficulty: [
          { required: true, message: "请选择试题难易", trigger: "change" }
        ],
        state: [
          { required: true, message: "请选择试题状态", trigger: "change" }
        ],
        stem: [{ required: true, message: "题干不可或缺", trigger: "blur" }]
      }
    };
  },
  created () {
    // this.addTestXX()
  },
  methods: {
    select(a){
        var s = this.SA +"/" + this.SB +"/" + this.SC +"/" + this.SD
        this.form.content = s
        if(a=='A'){
          this.answerList[0].content = this.SA
        }else if(a=='B'){
          this.answerList[0].content = this.SB
        }else if(a=='C'){
          this.answerList[0].content = this.SC
        }else if(a=='D'){
          this.answerList[0].content = this.SD
        }
      console.log(a)
    },
    jump () {
      this.$router.push("list")
    },
    jump_item(){
      this.$router.push('subjectiveItem')
    },
    sumbit () {
      this.addTestXX()
    },
    resetForm (formName) {
      this.$refs[formName].resetFields()
    },
    async addTestXX () {
      let data = {
        answerList: [
          {
            content: this.answerList[0].content,
            flag: this.answerList[0].flag,
            option: this.answerList[0].option
          }
        ],
        content: this.form.content,
        difficulty: this.form.difficulty,
        id: 0,
        state: this.form.state,
        stem:this.form.stem,
        type: this.form.type
      }
      console.log (data)
      try{
        let res =await addTest(data)
        if (res.code === '200'){
          this.$message({
            type: 'success',
            message: '添加成功'
          })
          this.$router.push('list')
        }else {
            this.$message({
              type: 'error',
              message: res.message
            })
          }
      }catch (err) {
      console.log (err)
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

.el-input {
  width: 204px;
}
.el-textarea {
  width: 800px;
}
.el-radio {
  margin-bottom: 17px;
}
.choose {
  width: 200px;
  margin-bottom: 10px;
}
</style>
