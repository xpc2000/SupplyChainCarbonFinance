<template>
  
  <el-table v-bind="$attrs" v-on="$listeners" ref="listTable" >
   
    <el-table-column
      v-for="(item, index) in columns"
      :key="item.prop + item.label + index"
      v-bind="item"
      align="center"
    >
     
      <template #default="{ row, $index }">
     
        <!-- 没有插槽的情况 -->
      
        <span v-if="!item.customSlot || item.customSlot == ''">{{
          row[item.prop]
        }}</span>
        
        <!-- 有插槽 -->
      
        <slot v-else :name="item.customSlot" :row="row" :index="$index"></slot>
    
      </template>
  
    </el-table-column>
  
  </el-table>
</template>

<script>
export default {
  name: "listTable",
  props: ["columns"],
  data() {
    return {};
  },
  mounted() {
    console.log(this.columns);
  },
};
</script>