<template>
  <div class="sub-content-box">
    <header-title :headerTitle="headerTitle"></header-title>

    <div class="sub-content-body">
      <div class="description-title">
        <div class="table-rec"></div>
        审核信息
      </div>

      <div class="description-box">
        <el-descriptions>
          <!-- "配额所有者 质押金额 贷款期限 操作日期 配额量 质押率 贷款利率 附件" -->
          <el-descriptions-item label="配额所属供应链">
            {{ this.pledgeDetail.controlChain }}
          </el-descriptions-item>
          <el-descriptions-item label="配额所有者">
            {{ this.pledgeDetail.quotaOwner }}
          </el-descriptions-item>
          <el-descriptions-item label="质押金额">
            {{ this.pledgeDetail.pledgeAmount }}
          </el-descriptions-item>
          <el-descriptions-item label="贷款期限">
            {{ this.pledgeDetail.loanTerm }}
          </el-descriptions-item>
          <el-descriptions-item label="操作日期">
            {{ this.pledgeDetail.operationData }}
          </el-descriptions-item>
          <el-descriptions-item label="配额量">
            {{ this.pledgeDetail.quotaQuantity }}
          </el-descriptions-item>
          <el-descriptions-item label="质押率">
            {{ this.pledgeDetail.pledgeRate }}
          </el-descriptions-item>
          <el-descriptions-item label="贷款利率">
            {{ this.pledgeDetail.loanInterestRate }}
          </el-descriptions-item>
          <el-descriptions-item label="附件"> 附件.pdf </el-descriptions-item>

          <!-- <el-descriptions-item v-for="(item,index) in editableText" :label="item.label">
          {{item.input}}
          </el-descriptions-item> -->
        </el-descriptions>
      </div>

      <div class="description-title">
        <div class="table-rec"></div>
        意见
      </div>
      <div class="radio-approval-box">
        <el-radio v-model="radio" label="1" @change="updateComment(1)"
          >签署</el-radio
        >
        <el-radio v-model="radio" label="2" @change="updateComment(2)"
          >拒绝</el-radio
        >
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
            :model="action"
            status-icon
            :rules="rules"
            ref="action"
            label-width="100px"
            class="demo-action"
          >
            <el-form-item label="密码" prop="actionPassword">
              <el-input
                type="password"
                v-model="action.actionPassword"
                autocomplete="off"
              ></el-input>
            </el-form-item>
            <el-form-item>
              <el-button type="primary" @click="submitForm(action)"
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
import { updateCompanyPledgeSigning } from "@/utils/api.js";
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
      action: {
        accountName: localStorage.getItem("name"),
        accountType: localStorage.getItem("accountType"),
        actionPassword: "",
        id: "",
        comment: "",
      },
      pledgeID: -999,
      headerTitle: {
        largeTitle: "质押签约",
        smallTitle: "质押签订",
      },
      edit: false,
      pledgeDetail: {},
      dialogVisible: false,
      radio: "1",
      textarea: "",
      rules: {
        actionPassword: [{ validator: validatePass, trigger: "blur" }],
      },
    };
  },
  async mounted() {
    this.pledgeID = parseInt(this.$route.params.id);
    const { data: res } = await this.$http.get(
      "/pledgeSearch/" + this.pledgeID
    );
    this.pledgeDetail = res.data;
    this.pledgeDetail.operationData = "2022-03-12 14:07:59";
    this.pledgeDetail.loanTerm = "2022-03-12 23:23:23";
    this.action.id = this.pledgeID;
    if (this.radio == "1") {
      this.action.comment = true;
    }
    console.log(this.pledgeDetail);
  },

  methods: {
    updateComment(label) {
      this.action.comment = label == 1;
      console.log(this.action);
    },
    submitForm(action) {
      this.$refs.action.validate(async (valid) => {
        if (valid) {
          console.log(action);
          const { data: res } = await updateCompanyPledgeSigning(
            action,
            parseInt(this.$route.params.id)
          );
          console.log(res);
          if (res.conde != 0) {
            this.dialogVisible = false;
            this.$message({
              message: "签约失败",
            });
            return false;
          } else {
            this.dialogVisible = false;
            this.$message({
              message: "完成签约",
              type: "success",
            });
          }
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
