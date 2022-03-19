<template>
  <div class="sub-content-box">
    <header-title :headerTitle="headerTitle"></header-title>

    <div class="sub-content-body">
      <div class="description-title">
        <div class="table-rec"></div>
        审核信息
      </div>

      <div class="description-box">
        <el-descriptions model="formLabelAlign">
          <el-descriptions-item label="配额所属供应链">
            {{ this.pledgeDetail.chain }}
          </el-descriptions-item>
          <el-descriptions-item label="配额所有者">
            {{ this.pledgeDetail.companyNeedFund }}
          </el-descriptions-item>
          <el-descriptions-item label="操作日期">
            {{ this.pledgeDetail.date }}
          </el-descriptions-item>
          <el-descriptions-item label="配额量">
            {{ this.pledgeDetail.pledgeNum }}
          </el-descriptions-item>
          <el-descriptions-item label="附件"> 合同.pdf </el-descriptions-item>
          <el-descriptions-item
            v-for="(item, index) in editableText"
            :key="item.prop"
            :label="item.label"
          >
            <span v-show="!item.edit">{{ item.input }}</span>
            <el-input v-show="item.edit" v-model="item.input"></el-input>
            <i
              :class="{
                'el-icon-edit': !item.edit,
                'el-icon-check': item.edit,
              }"
              @click="item.edit = !item.edit"
            ></i>
          </el-descriptions-item>
          <el-descriptions-item
            v-for="(item, index) in pledgeDDL"
            :key="item.prop"
            :label="item.label"
          >
            <span v-show="!item.edit">{{ item.input }}</span>
            <el-date-picker
              v-show="item.edit"
              v-model="item.input"
              type="datetime"
            ></el-date-picker>
            <i
              :class="{
                'el-icon-edit': !item.edit,
                'el-icon-check': item.edit,
              }"
              @click="item.edit = !item.edit"
            ></i>
          </el-descriptions-item>
        </el-descriptions>
      </div>

      <div class="description-title">
        <div class="table-rec"></div>
        审批操作
      </div>
      <div class="radio-approval-box">
        <el-radio v-model="radio" label="1">审核</el-radio>
        <el-radio v-model="radio" label="2">拒绝</el-radio>
        <div class="radio-approval-comment-title">签署意见</div>
        <div class="radio-approval-comment-content">
          <el-input
            type="textarea"
            :rows="8"
            placeholder="请输入内容"
            v-model="textarea"
          >
          </el-input>
        </div>

        <button class="button-style" @click="dialogVisible = true">提交</button>
        <!-- 提交弹出操作密码面板 -->
        <el-dialog title="操作密码" :visible.sync="dialogVisible" width="30%">
          <el-form
            :model="pledgeDetail"
            status-icon
            :rules="rules"
            ref="pledgeDetail"
            label-width="100px"
            class="demo-pledgeDetail"
          >
            <el-form-item label="密码" prop="actionPassword">
              <el-input
                type="password"
                v-model="pledgeDetail.actionPassword"
                autocomplete="off"
              ></el-input>
            </el-form-item>
            <el-form-item>
              <el-button type="primary" @click="submitForm(pledgeDetail)"
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
import editableText from "@/components/editableText.vue";
import { updateInstitutionPledgeSigning } from "@/utils/api.js";
export default {
  data() {
    var validatePass = (rule, value, callback) => {
      if (value === "") {
        callback(new Error("请输入密码"));
      } else {
        if (this.pledgeDetail.checkPass !== "") {
          this.$refs.pledgeDetail.validateField("checkPass");
        }
        callback();
      }
    };
    return {
      pledgeDetail: {
        accountName: localStorage.getItem("name"),
        accountType: parseInt(localStorage.getItem("accountType")),
        actionPassword: "",
        id: 0,
        chain: "",
        companyNeedFund: "",
        companyOfferFund: localStorage.getItem("name"),
        pledgeNum: 0,
        pledgeFund: 0,
        pledgeRate: 0.0,
        interestRate: 0.0,
        pledgeDDL: "",
        date: "",
        usage: "",
      },
      headerTitle: {
        largeTitle: "任务管理",
        smallTitle: "质押签订",
      },
      edit: false,
      editableText: [
        {
          id: 7,
          prop: "pledgeRate",
          label: "质押率",
          input: "可编辑",
          edit: false,
        },
        {
          id: 8,
          prop: "interestRate",
          label: "贷款利率",
          input: "可编辑",
          edit: false,
        },
        {
          id: 9,
          prop: "pledgeFund",
          label: "质押金额",
          input: "可编辑",
          edit: false,
        },
      ],
      pledgeDDL: [
        {
          id: 6,
          prop: "pledgeDDL",
          label: "贷款期限",
          input: "2022-03-12 01:01:01",
          edit: false,
        },
      ],
      dialogVisible: false,
      radio: "1",
      textarea: "",
      rules: {
        actionPassword: [{ validator: validatePass, trigger: "blur" }],
      },
    };
  },
  async mounted() {
    this.pledgeDetail.id = parseInt(this.$route.params.id);
    console.log(this.$route.params.id);
    const { data: res } = await this.$http.get(
      "/pledgeSearch/" + this.pledgeDetail.id
    );
    console.log("res.data", res.data);
    this.pledgeDetail.chain = res.data.controlChain;
    this.pledgeDetail.companyNeedFund = res.data.quotaOwner;
    this.pledgeDetail.usage = res.data.fundUse;
    this.pledgeDetail.date = res.data.operationData;
    this.pledgeDetail.pledgeNum = res.data.quotaQuantity;
    this.pledgeDetail.date = "2022-03-12 14:07:59";
    this.pledgeDetail.pledgeDDL = "2022-03-12 01:01:01";
    console.log(this.pledgeDetail);
  },
  methods: {
    updateComment(label) {
      this.action.comment = label == 1;
      console.log(this.action);
    },
    submitForm(pledgeDetail) {
      this.pledgeDetail.pledgeRate = parseFloat(this.editableText[0].input);
      this.pledgeDetail.interestRate = parseFloat(this.editableText[1].input);
      this.pledgeDetail.pledgeFund = parseInt(this.editableText[2].input);
      console.log(this.pledgeDetail);
      this.$refs.pledgeDetail.validate(async (valid) => {
        if (valid) {
          this.dialogVisible = false;
          console.log(this.pledgeDetail);

          updateInstitutionPledgeSigning(pledgeDetail).then((data) => {
            console.log(data);
            if (data.data.conde != 0) {
              this.dialogVisible = false;
              this.$message({
                message: "密码不正确",
                type: "warning",
              });
            } else {
              this.$message({
                message: "完成签订",
                type: "success",
              });
            }
          });
        }
      });
    },
  },
  components: {
    headerTitle,
    editableText,
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
  font-size: 18px;
  padding-top: 20px;
  margin-left: 40px;
  margin-bottom: 30px;
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
  margin: 20px 0px 15px 0px;
  color: #6e7191;
}
.radio-approval-comment-content {
  height: 150px;
  width: calc(100vw - 380px);
  border: 1px solid #eee;
  margin: 15px 0px 30px 0px;
}

.approval-button {
  margin: 20px 40px;
}
.button-style {
  margin: 30px 20px 50px 0px;
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
