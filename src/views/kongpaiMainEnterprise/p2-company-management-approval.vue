<template>
  <div class="sub-content-box">
    <div class="sub-content-header">
      <div class="sub-content-title-left">
        <div class="sub-content-title-left-title">链属企业管理</div>
        <div class="sub-content-title-left-sublist-title">减排计划申报</div>
      </div>
      <div class="sub-content-title-right">
        <el-input v-model="input" placeholder="搜索"></el-input>
      </div>
    </div>

    <div class="sub-content-tabs">
      <el-tabs v-model="activeName" @tab-click="handleClick">
        <el-tab-pane label="全部" name="first">
          <el-table :data="tableData" style="width: 100%">
            <el-table-column type="selection" width="60" align="center">
            </el-table-column>
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
              <el-tag>已审批</el-tag>
            </el-table-column>
          </el-table>
          <div class="sub-content-import-export">
            <button @click="jumpToApproval" class="button-style">审批</button>
            <button class="button-style">查看</button>
          </div>
        </el-tab-pane>
        <el-tab-pane label="减排申报待审批" name="second"
          >减排申报待审批</el-tab-pane
        >
        <el-tab-pane label="减排申报已办理" name="third"
          >减排申报已办理</el-tab-pane
        >
      </el-tabs>
    </div>
  </div>
</template>
<script>
export default {
  data() {
    return {
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
    jumpToApproval() {
      this.$router.push({ path: "p2-01-company-management-approval-form" });
    },
  },
};
</script>
<style scoped>
.sub-content-tabs {
  padding-top: 10px;
  padding-left: 40px;
  padding-right: 40px;
  margin: 0 auto;
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

.sub-content-import-export .button-style {
  margin-right: 20px;
  width: 100px;
  height: 33px;
  border-radius: 7px;
  transition: 0.1s;
  border: none;
  text-align: center;
  box-sizing: border-box;
  background: #209f85;
  color: #fff;
}

.button-style:hover {
  background: transparent;
  border: 1px solid #209f85;
  color: #209f85;
  cursor: pointer;
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
::v-deep .el-checkbox__input.is-checked .el-checkbox__inner {
  background-color: #209f85 !important;
  border-color: #209f85 !important;
}
::v-deep .el-checkbox__input.is-indeterminate .el-checkbox__inner {
  background-color: #209f85;
  border-color: #209f85;
}
</style>
