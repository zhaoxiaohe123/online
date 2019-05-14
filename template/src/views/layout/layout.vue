<template>
  <div class="container">
    <div class="container-head">
      <top-nav></top-nav>
    </div>
    <div class="container-main">
      <div class="container-side">
        <side-bar></side-bar>
      </div>
      <div class="container-content">
        <show-main></show-main>
      </div>
    </div>
  </div>
</template>

<script>
import TopNav from "./components/topNav";
import SideBar from "./components/sideBar";
import ShowMain from "./components/showMain";
export default {
  components: {
    TopNav,
    SideBar,
    ShowMain
  }
};
</script>

<style lang="scss" scoped>
.container {
  min-width: 1440px;
  overflow: auto;
  .container-head {
    width: 100%;
    height: 60px;
  }
  .container-main {
    width: 100%;
    height: calc(100vh - 60px);
    display: flex;
    .container-side {
      width: auto;
      height: calc(100vh - 60px);
    }
    .container-content {
      min-width: 1130px;
      height: calc(100vh - 60px);
      background: #f7f9fd;
      flex: 1;
    }
  }
}
</style>
