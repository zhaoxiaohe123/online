<template>
  <div class="side-bar-container">
    <el-scrollbar style="height: 100%; overflow-x: hidden">
      <el-menu
        :open="$route.matched[0].path"
        :unique-opened="navEvent.opened"
        :router="navEvent.router"
        :default-active="$route.path"
        :collapse="isCollapse"
        :collapse-transition="true"
        class="el-menu-vertical-demo"
        background-color="#32445c"
        text-color="#fff"
      >
        <!-- 一级 -->
        <template v-for="(item,ind) in navList" v-if="item.role === role">
          <!-- 判断是否存在二级菜单 - 存在二级菜单 -->
          <el-submenu :index="item.path" :key="ind" v-if="item.hasLevelOne">
            <template slot="title">
              <i :class="item.icon"></i>
              <span>{{ item.name }}</span>
            </template>
            <!-- 循环二级菜单 -->
            <el-menu-item-group v-for="(items,inde) in item.children" :key="inde">
              <!-- 判断是否有三级菜单 - 存在三级菜单 -->
              <el-submenu :index="items.path" v-if="items.hasLevelTwo" :key="inde">
                <template slot="title">{{ items.name }}</template>
                <el-menu-item-group v-for="(itemss,index) in items.children" :key="index">
                  <el-menu-item :index="itemss.path" :disabled="itemss.isClick">{{ itemss.name }}</el-menu-item>
                </el-menu-item-group>
              </el-submenu>
              <!-- 不存在三级菜单 -->
              <el-menu-item
                :index="items.path"
                v-else
                :key="inde"
                :disabled="items.isClick"
              >{{ items.name }}</el-menu-item>
            </el-menu-item-group>
          </el-submenu>
          <!-- 不存在二级菜单 -->
          <el-menu-item :index="item.path" :key="ind" v-else :disabled="items.isClick">
            <i :class="item.icon"></i>
            <span slot="title">{{ item.name }}</span>
          </el-menu-item>
        </template>
      </el-menu>
    </el-scrollbar>
  </div>
</template>

<script>
import { sideInfo } from "utils/sideInfo";
import Bus from "utils/eventBus";
export default {
  mixins: [sideInfo],
  data() {
    return {
      role:JSON.parse(sessionStorage.getItem('role')),
      isCollapse: false
    };
  },
  mounted() {
    var vm = this;
    Bus.$on("val", data => {
      vm.isCollapse = data;
    });
  },
  created() {
    this.emitIsCollapse();
    console.log("role" ,JSON.parse(sessionStorage.getItem('role')))
  },
  methods: {
    emitIsCollapse() {
      Bus.$emit("val", this.isCollapse);
    }
  }
};
</script>

<style scoped lang="scss">
/deep/ .el-scrollbar__wrap {
  overflow-x: hidden;
}
/deep/ .el-submenu__title {
  width: 200px;
}
.side-bar-container {
  height: 100%;
  // width: 300px;
  width: 100%;
  background: $sideBG;
  overflow: hidden;
}
/deep/ .el-menu {
  border-right-width: 0;
}
/deep/ .public-style {
  clear: both;
}
/deep/ .public-icon {
  margin-right: 5px;
  width: 24px;
  height: 24px;
  display: inline-block;
}
/deep/ .el-menu-item.is-active {
  background: $sideActiveBG !important;
  color: $sideActiveFC !important;
}
/deep/ .el-menu-item-group__title {
  padding: 0;
}
/deep/ .el-scrollbar__view > ul {
  transition: width 0s linear;
}
/deep/ .el-menu-vertical-demo.el-menu {
  width: 200px !important;
}
/deep/ .el-menu-vertical-demo.el-menu--collapse.el-menu {
  width: 64px !important;
}
</style>
