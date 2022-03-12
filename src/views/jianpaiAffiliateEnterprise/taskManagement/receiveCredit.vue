<template>
  <div class="sub-content-box">
    <header-title :headerTitle="headerTitle"></header-title>

    <div class="sub-content-tabs">
      <el-tabs v-model="activeName" @tab-click="handleClick">
        <!-- <el-tab-pane label="全部" name="first"> </el-tab-pane> -->
        <el-tab-pane label="待签收" name="first">
          <template>
            <div>
              <list-table :data="pendingData" :columns="column">
                <!-- 插槽1：状态 -->
                <template #status="{ row, $index }">
                  <el-tag v-if="row.approved" class="approved">已签收</el-tag>
                  <el-tag v-else class="not-approved">待签收</el-tag>
                </template>

                <template #option="{ row, $index }">
                  <el-checkbox name="type" @change="getrows(row)"></el-checkbox>
                </template>
              </list-table>
            </div>
          </template>
          <div class="sub-content-import-export">
            <button class="button-style" @click="sendRow()">查看</button>
          </div>
        </el-tab-pane>
        <el-tab-pane label="已签收" name="second">
          <template>
            <div>
              <list-table :data="submittedData" :columns="column">
                <!-- 插槽1：状态 -->
                <template #status="{ row, $index }">
                  <el-tag class="approved">已签收</el-tag>
                  <!-- <el-tag v-if="row.approved" class="approved">已签收</el-tag> -->
                  <!-- <el-tag v-else class="not-approved">待签收</el-tag> -->
                </template>

                <template #option="{ row, $index }">
                  <el-checkbox name="type" @change="getrows(row)"></el-checkbox>
                </template>
              </list-table>
            </div>
          </template>
          <div class="sub-content-import-export">
            <button class="button-style" @click="sendRow()">查看</button>
          </div>
        </el-tab-pane>
      </el-tabs>
    </div>
  </div>
</template>
<script>
import headerTitle from "@/components/headerTitle.vue";
import ListTable from "@/components/ListTable";
import {
  loadCompanyPendingTicket,
  loadCompanySignedTicket,
} from "@/utils/api.js";

export default {
  data() {
    return {
      headerTitle: {
        largeTitle: "任务管理",
        smallTitle: "签收碳信",
      },
      row: {},
      activeName: "first",
      column: [
        {
          prop: "option",
          label: "选择",
          width: "100",
          customSlot: "option",
        },
        {
          prop: "sender",
          label: "转让方/发行方",
          width: "",
        },
        {
          prop: "time",
          label: "创建时间",
          width: "",
        },
        {
          prop: "amount",
          label: "碳信数额",
          width: "",
        },
        {
          prop: "status",
          label: "签收状态",
          customSlot: "status",
        },
      ],
      tableData: [
        // {
        //   ID: "1",
        //   task: "请您签收碳信，发行方控排链核心企业向您发行",
        //   amount: "3695",
        //   date: "2022-03-03 12:00",
        //   amount: "3200",
        //   approved: false,
        // },
        // {
        //   ID: "2",
        //   task: "请您签收碳信，转让方减排链核心企业向您转让",
        //   amount: "3695",
        //   date: "2022-03-03 12:00",
        //   amount: "3200",
        //   approved: true,
        // },
      ],

      // ========================新增代码===========================
      pendingData: [],
      submittedData: [],
      selectedID: "",
      company: localStorage.getItem("name"),
      chain: localStorage.getItem("chain"),
    };
  },

  // ========================新增代码===========================
  async mounted() {
    // console.log(await loadCompanySubmittedPledge(this.chain, this.company))
    // const {data:submitted} = await loadCompanySubmittedPledge(this.chain, this.company)
    // this.submittedData = submitted.data

    // 待签收
    const { data: pending } = await loadCompanyPendingTicket(
      this.chain,
      this.company
    );
    this.pendingData = pending.data;

    // 已签收
    const { data: submittedData } = await loadCompanySignedTicket(
      this.chain,
      this.company
    );
    this.submittedData = submittedData.data;
  },

  methods: {
    // ========================新增代码===========================
    //获取单行数据
    getrows(row) {
      this.selectedID = row.id;
      console.log(this.selectedID);
    },

    // ========================这里有问题===========================
    // 发送ID
    sendRow() {
      this.$router.push({
        path:
          "/jianpaiMainEnterprise/taskManagement/receivingDetails/" +
          this.selectedID,
      });
    },

    handleClick(tab, event) {
      //console.log(tab, event);
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
