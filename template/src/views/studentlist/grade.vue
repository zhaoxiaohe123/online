<template>
  <div class="all">
    <h3>查看分数</h3>
    <el-form :model="form" label-width="100px">
      <el-form-item label="查看分数:">
        <el-select v-model="select" @change="selectXX" placeholder="请选择">
          <el-option
            v-for="item in options"
            :key="item.id"
            :label="item.name"
            :value="item.id">
          </el-option>
        </el-select>
      </el-form-item>
      <el-form-item label="结果:">
        <el-input v-model="form.grade1"></el-input>
      </el-form-item>
    </el-form>
  </div>
</template>
<script>
import { getScore } from 'api/test'
import { paperList } from 'api/test'
export default {
  data() {
    return {
      options:[],
      select:'',
      form: {
        grade: '',
        grade1: ''
      }
    };
  },
  created(){
    // this.GetScore()
     this.PaperList()
  },
  methods:{
    selectXX(a){
     this.GetScore(a)
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
        console.log(res)
      }
    },
    async GetScore(a){
      let data = {
        paperId: a,
        userId: JSON.parse(sessionStorage.getItem('userId'))
      }
      let res = await getScore(data)
      if (res.code == '500' ){
        alert(res.message)
      }
      if(res.code == '200'){
        this.form.grade1 = res.data.score
        console.log(res)
      }
    },
  }
};
</script>
<style scoped lang="scss">
.all {
  padding-left: 30px;
}
.el-input {
  width: 204px;
}
</style>


