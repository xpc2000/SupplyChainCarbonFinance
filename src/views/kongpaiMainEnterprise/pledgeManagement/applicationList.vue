<template>
  <div class="sub-content-box">
    <header-title :headerTitle="headerTitle"></header-title>

    <div class="sub-content-tabs">
      <el-tabs v-model="activeName">
        <el-tab-pane label="质押待审批" name="first">
          <template>
            <div>
              <list-table :data="submittedData" :columns="column">
                <!-- 插槽1：状态 -->
                <template #status="{ row, $index }">
                  <el-tag v-if="row.status" class="approved">待签约</el-tag>
                  <el-tag v-else class="not-approved">待审核</el-tag>
                </template>

                <!-- 插槽2：选择 -->
                <template #option="{ row, $index }">
                  <el-checkbox @change="getrows(row)" name="type"></el-checkbox>
                </template>
              </list-table>
            </div>
            <div class="sub-content-import-export">
              <button @click="sendRow()" class="button-style">查看</button>
            </div>
          </template>
        </el-tab-pane>
        
        <el-tab-pane label="质押待签约" name="second">
            <template>
              <div>
                <list-table :data="pendingData" :columns="column">
                  <!-- 插槽1：状态 -->
                  <template #status="{ row, $index }">
                    <el-tag v-if="row.status" class="approved">待签约</el-tag>
                    <el-tag v-else class="not-approved">待审核</el-tag>
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
        </el-tab-pane>
      </el-tabs>
    </div>
  </div>
</template>
<script>
import headerTitle from "@/components/headerTitle.vue";
import ListTable from "@/components/ListTable";
import {loadCompanySigningPledge, loadCompanySubmittedPledge} from "@/utils/api.js"
export default {
  data() {
    return {
      selectedID: "",
      row: {},
      headerTitle: {
        largeTitle: "碳配额质押申请",
        smallTitle: "申请列表",
      },

      activeName: "first",
      company:localStorage.getItem("name"),
      chain:localStorage.getItem("chain"),
      column: [
        {
          prop: "option",
          label: "选择",
          width: "100",
          customSlot: "option",
        },

        {
          prop: "institution",
          label: "金融机构",
          width: "",
        },
        {
          prop: "amount",
          label: "配额数量",
          width: "",
        },
        {
          prop: "status",
          label: "碳信账户状态",
          customSlot: "status",
        },
      ],
      submittedData: [],
      pendingData:[],
    };
  },
  async mounted(){
    // console.log(await loadCompanySubmittedPledge(this.chain, this.company))
    const {data:submitted} = await loadCompanySubmittedPledge(this.chain, this.company)
    this.submittedData = submitted.data
    const {data:pending} = await loadCompanySigningPledge(this.chain, this.company)
    this.pendingData = pending.data
  },

  methods: {

    //获取单行数据
    getrows(row) {
      this.selectedID = row.id
      console.log(this.selectedID);
    },
    // 发送ID
    sendRow() {
      this.$router.push({
        path: `/kongpaiAffiliateEnterprise/pledgeManagement/pledgeSigning/${this.selectedID}`
      });
      //console.log(this.row.name);
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
