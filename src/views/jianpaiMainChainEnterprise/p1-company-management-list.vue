<template>
  <div class="sub-content-box">
    <div class="sub-content-header">
      <div class="sub-content-title-left">
        <div class="sub-content-title-left-title">链属企业管理</div>
        <div class="sub-content-title-left-sublist-title">链属企业列表</div>
      </div>
      <div class="sub-content-title-right">
        <el-input v-model="input" placeholder="搜索"></el-input>
      </div>
    </div>

    <div class="sub-content-tabs">
        <el-tabs v-model="activeName" @tab-click="handleClick">
            <el-tab-pane label="全部" name="first">
            <template>
                <div>
                <list-table :data="tableData" :columns="columns">
                    <!-- 插槽1：状态 -->
                    <template #status="{ row, $index }">
                    <el-tag v-if="row.add" type="success">已办理</el-tag>
                    <el-tag v-else type="danger">待审批</el-tag>
                    </template>
                    <!-- 插槽2：编辑 -->
                    <template #options="{ row, $index }">
                    <el-button type="text">编辑</el-button>
                    <el-button type="text">删除</el-button>
                    </template>
                </list-table>
                </div>
            </template>
            </el-tab-pane>
            <el-tab-pane label="企业碳信账户待审批" name="second"
            >企业碳信账户待审批</el-tab-pane
            >
            <el-tab-pane label="企业碳信账户已办理" name="third"
            >企业碳信账户已办理</el-tab-pane
            >
        </el-tabs>
        <div class="sub-content-import-export">
            <el-button><i class="el-icon-upload2"></i>列表导出</el-button>
            <el-button><i class="el-icon-download"></i>列表导入</el-button>
        </div>
    </div>
 
  </div>
</template>
<script>
import ListTable from "../../components/ListTable";
export default {
  data() {
    return {
      input: "",
      activeName: "first",
      columns: [
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
          width: "200px",
          customSlot: "status",
        },
        {
          prop: "options",
          label: "碳信账户状态",
          width: "200px",
          customSlot: "options",
        },
      ],
      tableData: [
        {
          name: "青岛银行",
          relationship: "一级链属企业",
          amount: "3695",
          time: "2020-01 - 2020-12",
          ccer: "1455.58",
          add: true,
        },
        {
          name: "青岛银行",
          relationship: "一级链属企业",
          amount: "3695",
          time: "2020-01 - 2020-12",
          ccer: "1455.58",
          add: false,
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
    ListTable,
  },
};
</script>
<style scoped>
.right-content {
  overflow: hidden;
}

.sub-content-title-right {
  line-height: 44px;
  padding-right: 40px;
}

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
/* .el-tag{
    background-color: #DFEFFF;
    color: #369AFE;
    font-weight: bold;
    width: 100px;
} */
</style>
