<template>
  <div class="sub-content-box">
    <header-title :headerTitle="headerTitle"></header-title>

    <div class="sub-content-body">
      <div class="description-title">
        <div class="table-rec"></div>
        审核信息
      </div>
      <div>
        <div class="description-box">
          <el-descriptions>
            <el-descriptions-item label="发行方所在供应链">
              {{ this.receivedDetail.initiatorSupplyChain }}
            </el-descriptions-item>
            <el-descriptions-item label="签收方所在供应链">
              {{ this.receivedDetail.receiverSupplyChain }}
            </el-descriptions-item>
            <el-descriptions-item label="碳信转让金额">
              {{ this.receivedDetail.amountCarbonTicket }}
            </el-descriptions-item>
            <el-descriptions-item label="发行方企业全称">
              {{ this.receivedDetail.initiatorName }}
            </el-descriptions-item>
            <el-descriptions-item label="签收方企业全称">
              {{ this.receivedDetail.receiverName }}
            </el-descriptions-item>
            <el-descriptions-item label="资金用途说明">
              {{ this.receivedDetail.fundUse }}
            </el-descriptions-item>
          </el-descriptions>
        </div>
      </div>
      <!-- 审核信息 -->
      <div class="description-title">
        <div class="table-rec"></div>
        签收详情
      </div>

      <!-- <el-descriptions class="description-box"> -->

      <div class="description-box">
        <el-table :data="tableData" :columns="column" style="width: 100%">
          <el-table-column
            v-for="(item, index) in column"
            :key="index"
            :prop="item.prop"
            :label="item.label"
            :width="item.width"
            align="center"
          >
          </el-table-column>
        </el-table>
      </div>

      <!-- </el-descriptions> -->

      <div class="description-title">
        <div class="table-rec"></div>
        审批操作
      </div>
      <div class="radio-approval-box">
        <el-radio v-model="radio" label="1" @change="updateComment(1)"
          >签收</el-radio
        >
        <el-radio v-model="radio" label="2" @change="updateComment(2)"
          >拒绝</el-radio
        >
        <div class="radio-approval-comment-title">审批意见</div>
        <div class="radio-approval-comment-content">
          <el-input
            type="textarea"
            :rows="2"
            placeholder="请输入内容"
            v-model="textarea"
          >
          </el-input>
        </div>

        <button class="button-style" @click="dialogVisible = true">提交</button>
        <!-- 提交弹出操作密码面板 -->
        <el-dialog title="操作密码" :visible.sync="dialogVisible" width="30%">
          <el-form
            :model="action"
            status-icon
            :rules="rules"
            ref="action"
            label-width="100px"
            class="demo-action"
          >
            <el-form-item label="密码">
              <el-input
                type="password"
                v-model="action.actionPassword"
                autocomplete="off"
              ></el-input>
            </el-form-item>
            <el-form-item>
              <el-button type="primary" @click="submitForm(action, ticketNum)"
                >提交</el-button
              >
            </el-form-item>
          </el-form>
        </el-dialog>
        <!-- 操作密码面板结束 -->
      </div>
    </div>
  </div>
</template>
<script>
import headerTitle from "@/components/headerTitle.vue";
import {
  loadCompanyTicketRow,
  ticketPublishCheck,
  ticketTransferCheck,
} from "@/utils/api.js";

export default {
  data() {
    var validatePass = (rule, value, callback) => {
      if (value === "") {
        callback(new Error("请输入密码"));
      } else {
        if (this.action.checkPass !== "") {
          this.$refs.action.validateField("checkPass");
        }
        callback();
      }
    };

    return {
      company: localStorage.getItem("name"),
      // id: "",
      dialogVisible: false,
      radio: "1",
      textarea: "",
      rules: {
        actionPassword: [{ validator: validatePass, trigger: "blur" }],
      },
      headerTitle: {
        largeTitle: "任务管理",
        smallTitle: "签收详情",
      },
      receivedDetail: {},
      column: [
        {
          prop: "senderName",
          label: "付款方",
          width: "",
        },

        {
          prop: "receiverName",
          label: "签收方",
          width: "",
        },
        {
          prop: "date",
          label: "碳信到账日期",
          width: "",
        },
        {
          prop: "amount",
          label: "碳信数量",
          width: "",
        },
        {
          prop: "status",
          label: "状态",
          width: "",
        },

        {
          prop: "file",
          label: "附件",
          width: "",
        },
      ],
      tableData: [
        {
          senderName: "senderName",
          receiverName: "某减排链企业",
          date: "03-03-2022",
          amount: "2300",
          status: "待签收",
          file: "合同.pdf",
        },
      ],
      ruleForm: {
        actionPassword: "",
      },
      action: {
        accountName: localStorage.getItem("name"),
        accountType: localStorage.getItem("accountType"),
        actionPassword: "",
        id: "",
        comment: "",
      },

      receivedID: -999,
      ticketNum: 0,
    };
  },

  // ==========================新增代码========================================
  async mounted() {
    this.receivedID = parseInt(this.$route.params.id);
    const { data: res } = await loadCompanyTicketRow(this.receivedID);
    console.log(res.data);

    this.receivedDetail = res.data;

    //签收详情数据
    this.tableData[0].senderName = this.receivedDetail.initiatorName;
    this.tableData[0].receiverName = this.receivedDetail.receiverName;
    this.tableData[0].date = this.receivedDetail.operationData;
    this.tableData[0].amount = this.receivedDetail.amountCarbonTicket;

    this.ticketNum = this.receivedDetail.amountCarbonTicket;
    console.log("ticketNum: " + this.ticketNum);
    this.action.id = this.receivedID;
    if (this.radio == "1") {
      this.action.comment = true;
    } else {
      this.action.comment = false;
    }
  },

  methods: {
    updateComment(label) {
      if (label == 1) this.action.comment = true;
      else this.action.comment = false;
      console.log(this.action);
    },

    // `operation` int NULL DEFAULT NULL COMMENT '1:创建/2:发行/3:转让/4:回购/5:融资/6:销毁',
    submitForm(action, ticketNum) {
      this.$refs.action.validate(async (valid) => {
        if (valid) {
          this.dialogVisible = false;
          this.$confirm("确认签收碳信？").then((_) => {
            ticketTransferCheck(action, parseInt(ticketNum)).then((data) => {
              if (data.data.conde != 0) {
                this.dialogVisible = false;
                this.$message({
                  message: "密码不正确",
                  type: "warning",
                });
              } else {
                console.log(data);
                this.$message({
                  message: "完成签收",
                  type: "success",
                });
              }
            });
          });
        }
      });
    },

    next() {
      this.$message({
        message: "提交成功",
        type: "success",
      });
    },
  },

  components: {
    headerTitle,
  },
};
</script>
<style scoped>
.sub-content-body {
  background: #fff;
  margin: 20px;

  border-radius: 25px;
}

.description-box {
  border: 1px solid #eee;
  margin: 10px 40px;
  border-radius: 12px;
}

.description-title {
  padding-top: 20px;
  margin-left: 40px;
  line-height: 30px;
}
.description-title .table-rec {
  float: left;
  width: 4px;
  height: 30px;
  border-radius: 50px;
  background-color: #f2a626;
  margin-right: 10px;
}
::v-deep .el-descriptions {
  padding: 20px 20px;
}
::v-deep .el-radio__input.is-checked .el-radio__inner {
  border-color: #156a59;
  background: #156a59;
}
::v-deep .el-radio__input.is-checked + .el-radio__label {
  color: #156a59;
}
.radio-approval-box {
  margin-left: 40px;
  margin-top: 30px;
}
.radio-approval-comment-title {
  font-size: 14px;
  margin: 15px 0px;
  color: #6e7191;
}
.radio-approval-comment-content {
  height: 30px;
  width: calc(100vw - 380px);
  border: 1px solid #eee;
  margin: 15px 0px;
}
.approval-button {
  margin: 20px 40px;
}
.button-style {
  margin: 30px 0px 30px 0px;

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
</style>
