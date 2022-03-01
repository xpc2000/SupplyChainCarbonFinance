<template>
  <div class="layout-container">
    <Sidebar></Sidebar>
    <div>
      <Navbar></Navbar>
      <app-main></app-main>
    </div>
  </div>
</template>

<script>
import Sidebar from './components/Sidebar'
import AppMain from './components/AppMain'
import Navbar from './components/Navbar'
export default ({
  data() {
    return {

    }
  },
  components: {
    Sidebar,
    AppMain,
    Navbar
  }
})
</script>

<style lang="less" scoped>
.layout-container {
  width: 100vw;
  height: 100vh;
  display: flex;
  background: #F5F7FA;

}
</style>