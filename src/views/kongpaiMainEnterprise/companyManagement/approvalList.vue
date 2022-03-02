<template>
  <div class="sub-content-box">
    <header-title :headerTitle="headerTitle"></header-title>

    <div class="sub-content-tabs">
      <!-- 切换标签栏 -->
      <el-tabs v-model="activeName" @tab-click="handleClick">
        <!-- 标签栏1：展示全部数据 -->
        <el-tab-pane label="全部" name="first">
          <template>
            <div>
              <list-table :data="tableData" :columns="column">
                <!-- 插槽1：状态 -->
                <template #status="{ row, $index }">
                  <el-tag v-if="row.approved" class="approved">已办理</el-tag>
                  <el-tag v-else class="not-approved">待审批</el-tag>
                </template>
                <!-- 插槽2：选择 -->
                <template #option="{ row, $index }">
                  <el-checkbox @change="getrows(row)" name="type"></el-checkbox>
                </template>
              </list-table>
            </div>
          </template>
          <div class="sub-content-import-export">
            <button @click="sendRow()" class="button-style">查看</button>
          </div>
        </el-tab-pane>

        <!-- 标签栏2：展示待审批数据 -->
        <el-tab-pane label="减排申报待审批" name="second"
          >减排申报待审批</el-tab-pane
        >

        <!-- 标签栏3：展示已办理数据 -->
        <el-tab-pane label="减排申报已办理" name="third"
          >减排申报已办理</el-tab-pane
        >
      </el-tabs>
    </div>
  </div>
</template>
<script>
import headerTitle from "@/components/headerTitle.vue";
import ListTable from "@/components/ListTable";
export default {
  data() {
    return {
      row: {},
      headerTitle: {
        largeTitle: "链属企业管理",
        smallTitle: "减排计划申报",
      },

      activeName: "first",
      column: [
        {
          prop: "option",
          label: "选择",
          width: "100",
          customSlot: "option",
        },
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
        {
          prop: "status",
          label: "碳信账户状态",
          customSlot: "status",
        },
      ],
      tableData: [
        {
          ID: "1",
          name: "青岛银行",
          relationship: "一级链属企业",
          amount: "3695",
          time: "2020-01 - 2020-12",
          ccer: "1455.58",
          approved: true,
        },
        {
          ID: "2",
          name: "青岛银行",
          relationship: "一级链属企业",
          amount: "3695",
          time: "2020-01 - 2020-12",
          ccer: "1455.58",
          approved: false,
        },
      ],
    };
  },
  methods: {
    handleClick(tab, event) {
      console.log(tab, event);
    },
    //获取单行数据
    getrows(row) {
      this.row = row;
      console.log(row.name);
    },
    // 发送ID
    sendRow() {
      this.$router.push({
        path: "/kongpaiMainEnterprise/companyManagement/approvalListForm",
      });
      console.log(this.row.name);
    },
  },
  components: {
    headerTitle,
    ListTable,
  },
};
</script>
<style scoped>
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

.button-style {
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
.approved {
  background-color: #dfefff;
  color: #369afe;
  font-weight: bold;
  width: 100px;
}
.not-approved {
  background-color: #ffeaea;
  color: #ff4b4b;
  font-weight: bold !important;
  width: 100px;
  border-color: #ffeaea;
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
