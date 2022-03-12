<template>
  <div class="sub-content-box">
    <header-title :headerTitle="headerTitle"></header-title>

    <div class="sub-content-body">
      <div class="description-title">
        <div class="table-rec"></div>
        发行方
      </div>
      <div class="form-body">
        <el-row :gutter="40">
          <el-col :span="12">
            <el-form
              :label-position="labelPositionForm"
              label-width="80px"
              :model="formLabelAlign"
            >
              <el-form-item label="转让方所属供应链">
                <el-input
                  placeholder="某减排链"
                  :disabled="true"
                  v-model="formLabelAlign.senderChain"
                ></el-input>
              </el-form-item>
              <el-form-item label="转让方企业全称">
                <el-input
                  placeholder="某减排链企业"
                  :disabled="true"
                  v-model="formLabelAlign.sender"
                ></el-input>
              </el-form-item>
              <el-form-item label="碳信转让日期">
                <el-date-picker
                  type="datetime"
                  placeholder="选择日期"
                  v-model="formLabelAlign.date"
                >
                </el-date-picker>
              </el-form-item>
            </el-form>
          </el-col>
          <el-col :span="12">
            <el-form
              :label-position="labelPositionForm"
              label-width="80px"
              :model="formLabelAlign"
            >
              <el-form-item label="碳信可用余额">
                <el-input
                  :disabled="true"
                  placeholder=""
                  v-model="formLabelAlign.balance"
                ></el-input>
              </el-form-item>
              <el-form-item label="碳信转让数量">
                <el-input
                  placeholder="￥￥￥￥￥"
                  v-model="formLabelAlign.num"
                ></el-input>
              </el-form-item>
              <el-form-item label="附件">
                <span
                  style="
                    position: absolute;
                    top: 120x;

                    float: right;
                  "
                  >点击上传文件</span
                >
                <el-input
                  placeholder="文件"
                  v-model="formLabelAlign.usage"
                ></el-input>
              </el-form-item>
            </el-form>
          </el-col>
        </el-row>
      </div>

      <div class="description-title">
        <div class="table-rec"></div>
        签收方
      </div>
      <div class="form-body">
        <el-row :gutter="40">
          <el-col :span="12">
            <el-form
              :label-position="labelPositionForm"
              label-width="80px"
              :model="formLabelAlign"
            >
              <el-form-item label="接收方所属供应链">
                <el-input
                  placeholder="某供应链"
                  v-model="formLabelAlign.receiverChain"
                ></el-input>
              </el-form-item>
            </el-form>
          </el-col>
          <el-col :span="12">
            <el-form
              :label-position="labelPositionForm"
              label-width="80px"
              :model="formLabelAlign"
            >
              <el-form-item label="接收方企业全称">
                <el-input
                  placeholder="某减排链企业"
                  v-model="formLabelAlign.receiver"
                ></el-input>
              </el-form-item>
            </el-form>
          </el-col>
        </el-row>
      </div>

      <div class="sub-content-submit-button">
        <el-button class="button-style" @click="dialogVisible = true"
          >提交</el-button
        >
      </div>

      <!-- 提交弹出操作密码面板 -->
      <el-dialog title="操作密码" :visible.sync="dialogVisible" width="30%">
        <el-form
          :model="formLabelAlign"
          status-icon
          :rules="rules"
          ref="formLabelAlign"
          label-width="100px"
          class="demo-ruleForm"
        >
          <el-form-item label="密码" prop="actionPassword">
            <el-input
              type="password"
              v-model="formLabelAlign.actionPassword"
              autocomplete="off"
            ></el-input>
          </el-form-item>
          <el-form-item>
            <el-button type="primary" @click="submitForm(formLabelAlign)">
              提交
            </el-button>
          </el-form-item>
        </el-form>
      </el-dialog>
      <!-- 操作密码面板结束 -->
    </div>
  </div>
</template>
<script>
import headerTitle from "@/components/headerTitle.vue";
import { ticketTransfer } from "@/utils/api.js";
export default {
  data() {
    var validatePass = (rule, value, callback) => {
      if (value === "") {
        callback(new Error("请输入密码"));
      } else {
        if (this.formLabelAlign.checkPass !== "") {
          this.$refs.formLabelAlign.validateField("checkPass");
        }
        callback();
      }
    };
    return {
      headerTitle: {
        largeTitle: "碳信管理  ",
        smallTitle: "碳信转让 ",
      },
      active: 1,
      textarea: "",
      dialogVisible: false,
      labelPositionTabs: "right",
      labelPositionForm: "top",
      formLabelAlign: {
        balance: localStorage.getItem("ticketBalance"),
        accountName: localStorage.getItem("name"),
        accountType: parseInt(localStorage.getItem("accountType")),
        actionPassword: "",
        senderChain: localStorage.getItem("chain"),
        sender: localStorage.getItem("name"),
        num: "",
        receiver: "",
        receiverChain: "",
        usage: "",
        date: "",
      },
      rules: {
        actionPassword: [{ validator: validatePass, trigger: "blur" }],
      },
    };
  },
  mounted() {
    console.log(localStorage);
  },
  methods: {
    submitForm(formLabelAlign) {
      this.$refs.formLabelAlign.validate(async (valid) => {
        if (valid) {
          console.log(formLabelAlign);
          //操作密码正确
          this.dialogVisible = false;
          this.$confirm("确认转让碳信？").then((_) => {
            ticketTransfer(formLabelAlign).then((data) => {
              console.log(data.data.conde);
              if (data.data.conde != 0) {
                this.dialogVisible = false;
                this.$message({
                  message: "密码不正确",
                  type: "warning",
                });
              } else {
                this.$message({
                  message: "碳信已转让",
                  type: "success",
                });
              }
            });
          });
        } else {
          this.$message({
            message: "密码不正确",
            type: "warning",
          });
        }
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
  margin: 20px 40px 40px;
  border-radius: 25px;
}
.form-body {
  margin: 20px 40px 0px;
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
  padding: 10px 40px;
}
/* ::v-deep .el-form-item {
  margin-bottom: 10px;
} */
::v-deep .el-form-item__label {
  line-height: 14px;
}
::v-deep .el-form--label-top .el-form-item__label {
  padding: 0 0 5px;
}
::v-deep .el-input__inner {
  border-radius: 5px;
  height: 35px;
  background-color: #fafcfe;
}
::v-deep .el-input__icon {
  height: 0;
}
::v-deep .el-input--suffix .el-input__inner {
  margin: 0;
}
.el-date-editor.el-input,
.el-date-editor.el-input__inner {
  width: 100%;
}
.sub-content-submit-button {
  /* height: 33px; */
  margin: 20px 40px 40px;
  padding-bottom: 40px;
}
/* .sub-content-submit-button .el-button {
  margin: 0;
} */
.sub-content-submit-button .button-style {
  padding: 0;
  margin-right: 20px;
  width: 100px;
  font-size: 14px;
  line-height: 33px;
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
