<template>
  <div class="all">
     <h3>新增试题</h3>
    <div class="detail">填写下面的表单，创建新的试题。选择不同的试题类型，需要填写的表单也各不相同。</div>
    <el-row>
      <el-button  type="info" @click="jump_test">新增客观题</el-button>
      <el-button>新增主观题</el-button>
      <el-button type="info" @click="jump">试题列表</el-button>
    </el-row>
    <div class="content">
      <div>
        <div>题 目 ：</div>
        <textarea v-model="stem" name="" id="" cols="50" rows="5"></textarea>
      </div>
      <el-button class="submit" @click="submit" type="primary">提交</el-button>
    </div>
   
  </div>
</template>
<script>
import { addSubTest } from 'api/test'
export default {
  data(){
    return {
      stem:"",
      answer:""
    }
  },
  methods:{
    jump_test(){
      this.$router.push('manageTest')
    },
    jump(){
      this.$router.push('list')
    },
    submit(){
      this.addTestXX()
      this.$router.push('list')
    },
    async addTestXX () {
      let data = {
        id: 0,
        // state: this.state,
        stem:this.stem,
        answer:this.answer
      }
      console.log (data)
      try{
        let res =await addSubTest(data)
         console.log (res)
      }catch (err) {
      console.log (err)
      }
    }

  }
}
</script>

<style lang="scss" scoped>
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
.content{
  padding-left: 30px;

}
.content>div{
  display: flex;
}

.submit{
  margin-top:50px;
  margin-left:200px;
}
</style>

