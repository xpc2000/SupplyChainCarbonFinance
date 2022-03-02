<template>
  <div class="sub-content-box">
    <header-title :headerTitle="headerTitle"></header-title>

    <div class="sub-content-tabs">
      <el-tabs v-model="activeName" @tab-click="handleClick">
        <el-tab-pane label="全部" name="first">
          <el-table :data="tableData" style="width: 100%">
            <el-table-column
              v-for="(item, index) in column"
              :key="index"
              :prop="item.prop"
              :label="item.label"
              :width="item.width"
              align="center"
            >
            </el-table-column>
            <el-table-column label="状态" width="180" align="center">
              <el-tag>已办理</el-tag>
            </el-table-column>
            <el-table-column prop="option" label="操作" align="center">
              <el-button type="text">编辑</el-button>
            </el-table-column>
          </el-table>
          <div class="sub-content-import-export">
            <el-button><i class="el-icon-upload2"></i>列表导出</el-button>
            <el-button><i class="el-icon-download"></i>列表导入</el-button>
          </div>
        </el-tab-pane>
        <el-tab-pane label="企业碳信账户待审批" name="second"
          >企业碳信账户待审批</el-tab-pane
        >
        <el-tab-pane label="企业碳信账户已办理" name="third"
          >企业碳信账户已办理</el-tab-pane
        >
      </el-tabs>
    </div>
  </div>
</template>
<script>
import headerTitle from "@/components/headerTitle.vue";

export default {
  data() {
    return {
      headerTitle: {
        largeTitle: "链属企业管理",
        smallTitle: "链属企业列表",
      },
      input: "",
      activeName: "first",
      column: [
        {
          prop: "name",
          label: "公司名称",
          width: "",
        },
        {
          prop: "relationship",
          label: "链属关系",
          width: "",
        },
        {
          prop: "amount",
          label: "计划减排总量",
          width: "",
        },
        {
          prop: "time",
          label: "减排时间段",
          width: "",
        },
        {
          prop: "ccer",
          label: "碳信总额",
          width: "",
        },
      ],
      tableData: [
        {
          name: "青岛银行",
          relationship: "一级链属企业",
          amount: "3695",
          time: "2020-01 - 2020-12",
          ccer: "1455.58",
        },
        {
          name: "青岛银行",
          relationship: "一级链属企业",
          amount: "3695",
          time: "2020-01 - 2020-12",
          ccer: "1455.58",
        },
      ],
    };
  },
  methods: {
    handleClick(tab, event) {
      console.log(tab, event);
    },
  },
  components: {
    headerTitle,
  },
};
</script>
<style scoped>
.sub-content-title-right {
  line-height: 44px;
  padding-right: 40px;
}
.sub-content-body {
  margin: 20px 40px 40px;
}
.sub-content-tabs {
  margin: 20px 40px 40px;
}

.sub-content-import-export {
  padding-top: 20px;
}

.sub-content-import-export .el-button {
  width: 100px;
  height: 35px;
  border-radius: 7px;
  padding: 0;
  font-size: 14px;
}
.sub-content-import-export .el-button:focus {
  background: #fff;
  color: #209f85;
}

.sub-content-import-export .el-button:hover {
  background: #dbf7f0;
  color: #209f85;
}
::v-deep .el-input__inner {
  border-radius: 20px;

  height: 34px;
  padding-left: 20px;
}

::v-deep .el-tabs__item.is-active {
  color: #209f85;
}
::v-deep .el-tabs__item :hover {
  color: #209f85;
}

::v-deep .el-tabs__active-bar {
  background-color: #209f85;
}
::v-deep .el-tabs__nav-wrap::after {
  background-color: #f5f7fa;
}
.el-tag {
  background-color: #dfefff;
  color: #369afe;
  font-weight: bold;
  width: 100px;
}
</style>
