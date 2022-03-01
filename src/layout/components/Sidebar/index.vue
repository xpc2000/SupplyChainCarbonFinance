<template>
  <div class="content">
    <div class="left-content">
        <div class="title">
          <img src="@/assets/header-icon/LOGO.svg" />
          <span>碳信金融供应链</span>
        </div>
        <div class="nav-small-label">导航列表</div>
         
        <sidebar-menu></sidebar-menu>
          
    </div>
  
  </div>
</template>

<script>
import SidebarMenu from './SidebarMenu.vue'
export default ({
  data() {
    return {

    }
  },
  components: {
    SidebarMenu
  }
})
</script>

<style  scoped>


.nav-small-label {
  margin: 20px;
  font-size: 14px;
  color: #fff;
}
.content {
  display: flex;
  
  
}
.left-content {
  width: 260px;
  height: 100vh;
  background: #156a59;
}
.title {
  width: 260px;
  height: 70px;
  display: flex;

  /* justify-content: center; */
  align-items: center;
  color: #fff;
  background-color: #156a59;
}

.title img {
  display: inline-block;
  width: 50px;
  height: 50px;
  margin-right: 15px;
  margin-left: 20px;
}

/* 头部信息 */
.sub-content-box {
  display: block;
}

.sub-content-header {
  display: flex;
  height: 44px;
  margin-top: 50px;

  width: calc(100vw - 260px);
  justify-content: space-between;
}
.sub-content-title-left {
  display: flex;
  justify-content: center;
  align-items: center;
  color: #6e7191;
  padding-left: 40px;
  font-size: 32px;
  line-height: 44px;
}

.sub-content-title-left-sublist-title {
  margin-left: 20px;
  font-size: 16px;
  background-color: #156a59;
  padding: 3px 8px;
  border-radius: 7px;
  color: #fff;
  height: 33px;
  line-height: 33px;
}

.sub-content-title-right {
  line-height: 44px;
  padding-right: 40px;
}

</style>