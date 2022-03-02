<template>
  <div>
    <el-submenu
      v-if="route.children && route.children.length > 1"
      :index="route.path"
    >
      <template #title>
        <menu-item
          :icon="route.meta.icon"
          :title="route.meta.title"
        ></menu-item>
        <!-- <i :class="route.meta.icon"></i>
            <span>{{route.meta.title}}</span> -->
      </template>
      <sidebar-item
        v-for="item in route.children"
        :key="item.path"
        :route="item"
      >
      </sidebar-item>
    </el-submenu>

    <el-menu-item
      v-if="!route.children || route.children.length == 0"
      :index="route.path"
    >
      <menu-item :route="route.meta.icon" :title="route.meta.title"></menu-item>
    </el-menu-item>

    <el-menu-item
      v-if="route.children && route.children.length == 1"
      :index="route.children[0].path"
    >
      <menu-item
        :route="route.children[0].meta.icon"
        :title="route.children[0].meta.title"
      ></menu-item>
    </el-menu-item>
  </div>
</template>
<script>
import SidebarItem from "./SidebarItem.vue";
import MenuItem from "./MenuItem.vue";
export default {
  name: "SidebarItem",
  props: ["route"],

  data() {
    return {};
  },
  components: {
    SidebarItem,
    MenuItem,
  },
  mounted() {
    console.log(this.route.children);
  },
};
</script>

<style scoped>
::v-deep .el-submenu__title {
  font-size: 16px !important;
}
.el-submenu__title i {
  color: #fff !important;
}
.el-submenu__title i img {
  padding-right: 20px;
}
.el-menu-item {
  font-size: 16px !important;
}
.el-menu-item i {
  color: #fff !important;
}
.el-menu-item.is-active i {
  color: #209f85 !important;
}
.el-menu-item.is-active {
  background-color: #dbf7f0 !important;
  color: #209f85 !important;
}

.el-menu-item i img {
  padding-right: 20px;
}
</style>
