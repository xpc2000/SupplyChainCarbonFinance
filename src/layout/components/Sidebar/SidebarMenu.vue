<template>
  <div>
    <el-menu
      class="el-menu-vertical-demo"
      background-color="#156A59"
      text-color="#fff"
      active-text-color="#04B78A"
      style="height: calc(100% - 70px)"
      :default-active="$route.path"
      :router="true"
    >
      <sidebar-item v-for="item in routes" :key="item.path" :route="item">
      </sidebar-item>
    </el-menu>
  </div>
</template>

<script>
import SidebarItem from "./SidebarItem.vue";
import { mapGetters } from "vuex";

import { routes, getUserRoutes } from "@/router";
export default {
  data() {
    return {
      routes: getUserRoutes(localStorage.getItem("username")),
    };
  },

  components: {
    SidebarItem,
  },
  mounted() {
    console.log("Logged in user name: " + localStorage.getItem("username"));
    console.log(this.routes);
  },
};
</script>

<style scoped></style>
