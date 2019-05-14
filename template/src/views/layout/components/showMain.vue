<template>
  <section class="showMain">
    <div class="total-head">
      <div class="main-head">
        <div class="crumbs-incline" v-if="this.CONF.showMain.crumbsPattern === 1">
          <el-breadcrumb separator="/">
            <el-breadcrumb-item
              v-for="(item) in crumbsInclineList"
              :key="item.path"
              v-show="item.meta.title"
            >
              <router-link :to="item.redirect || item.path">{{item.meta.title}}</router-link>
            </el-breadcrumb-item>
          </el-breadcrumb>
        </div>
        <div class="crumbs-block" v-if="this.CONF.showMain.crumbsPattern === 2">
          <div class="crumbs-block-move-cont" @click="moveCrumbs(0)">
            <i class="icon-xiangzuo"></i>
          </div>
          <div class="crumbs-block-show-cont" ref="crumbsBar">
            <div class="crumbs-block-show-cont-scroll">
              <div
                class="crumbs-block-content"
                v-for="(item, index) in crumbsBlockList"
                :class="{'active-route': $route.path === item.path}"
                :key="index"
                v-show="item.meta.title"
              >
                <router-link tag="span" :to="item.redirect || item.path">{{item.meta.title}}</router-link>
                <i
                  class="icon-chuyidong"
                  @click="removeMatched(index)"
                  v-if="$route.path !== item.path"
                ></i>
              </div>
            </div>
          </div>
          <div class="crumbs-block-move-cont" @click="moveCrumbs(1)">
            <i class="icon-11"></i>
          </div>
        </div>
      </div>
    </div>
    <div class="show-main">
      <router-view></router-view>
    </div>
  </section>
</template>

<script>
export default {
  data() {
    return {
      crumbsInclineList: [],
      crumbsBlockList: [
        // {path: '/xxxxx', meta: { title:'showMain' }},
        // {path: '/xxxxx', meta: { title:'route' }},
        // {path: '/xxxxx', meta: { title:'methods' }},
        // {path: '/xxxxx', meta: { title:'getBreadcrumb' }},
        // {path: '/xxxxx', meta: { title:'console' }},
        // {path: '/xxxxx', meta: { title:'crumbsBlockList' }},
        // {path: '/xxxxx', meta: { title:'xxxxxxxxxx' }},
        // {path: '/xxxxx', meta: { title:'scrollLeft' }},
        // {path: '/xxxxx', meta: { title:'crumbsBlockList' }},
        // {path: '/xxxxx', meta: { title:'xxxxxxxxxx' }}
      ]
    };
  },
  mounted() {
    this.getBreadcrumb();
    console.log();
  },
  methods: {
    getBreadcrumb() {
      let matched = this.$route.matched.filter(item => item.name);
      this.crumbsInclineList = matched;
      if (this.crumbsBlockList.length !== 0) {
        if (this.crumbsBlockList.indexOf(matched[matched.length - 1]) === -1)
          this.crumbsBlockList.push(matched[matched.length - 1]);
      } else {
        this.crumbsBlockList.push(matched[matched.length - 1]);
      }
    },
    removeMatched(i) {
      console.log(i);
      this.crumbsBlockList.splice(i, 1);
    },
    moveCrumbs(v) {
      v === 0
        ? (this.$refs.crumbsBar.scrollLeft -= 50)
        : (this.$refs.crumbsBar.scrollLeft += 50);
    }
  },
  watch: {
    $route: "getBreadcrumb"
  }
};
</script>

<style lang="scss" scoped>
.total-head {
  width: 100%;
  height: 42px;
  .main-head {
    height: 38px;
    background: #fff;
    border-top: 2px solid #f9f9f9;
    border-bottom: 2px solid #f9f9f9;
    padding: 0 20px;
    font-size: 12px;
    color: #6f7387;
    overflow: hidden;
    .crumbs-block {
      padding: 2px;
      display: flex;
      .crumbs-block-show-cont {
        flex: 1;
        height: 54px;
        overflow-y: hidden;
        overflow-x: scroll;
        margin: 0px 25px;
        .crumbs-block-show-cont-scroll {
          width: 9999px;
          .crumbs-block-content {
            float: left;
            margin-right: 20px;
            line-height: 11px;
            padding: 10px;
            border: 1px solid $sideActiveBG;
            vertical-align: middle;
            cursor: pointer;
            border-radius: 3px;
            span {
              color: $fontColor;
              position: relative;
            }
            span::after {
              content: "";
              position: absolute;
              left: -10px;
              top: -9.5px;
              right: 0px;
              bottom: -9.5px;
            }
            i {
              font-size: 12px;
              color: $sideActiveBG;
              padding: 0;
              &:hover {
                color: $red !important;
              }
            }
            &:hover {
              background: $sideActiveBG !important;
              span,
              i {
                color: #fff;
              }
            }
          }
        }
      }
      .crumbs-block-move-cont {
        width: 40px;
        height: 33px;
        background: $sideActiveBG;
        border-radius: 3px;
        i {
          color: #fff;
          cursor: pointer;
          line-height: 33px;
          margin-left: 11px;
        }
      }
    }
    .crumbs-incline > div {
      line-height: 38px;
    }
    span:first-child {
      color: #b5b5b5;
    }
  }
  .active-route {
    background: #2370d0 !important;
    span,
    i {
      color: #fff !important;
    }
  }
}
.show-main {
  height: calc(100vh - 142px);
  margin: 20px;
  box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
  background: #fff;
  overflow: auto;
  border-radius: 3px;
}
</style>
