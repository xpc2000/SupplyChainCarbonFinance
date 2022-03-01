<template>
    <div class="sub-content-header">
                <div class="sub-content-title-left">
                    <div class="sub-content-title-left-title">{{headerTitle.largeTitle}}</div>
                    <div class="sub-content-title-left-sublist-title">{{headerTitle.smallTitle}}</div>
                </div>
                <!-- <div class="sub-content-title-right">
                   <el-input placeholder="搜索"></el-input>
                </div> -->
    </div>
</template>
<script>
export default{

    props:["headerTitle"],
  
}



</script>
<style scoped>
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