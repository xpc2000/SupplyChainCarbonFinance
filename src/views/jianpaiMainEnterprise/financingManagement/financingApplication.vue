<template>
  <div class="sub-content-box">
    <header-title :headerTitle="headerTitle"></header-title>

    <div class="sub-content-body">
      <div class="description-title">
        <div class="table-rec"></div>
        申请表单
      </div>
      <div class="form-body">
        <el-row :gutter="40">
          <el-col :span="12">
            <el-form
              :label-position="labelPositionForm"
              label-width="80px"
              :model="formLabelAlign"
            >
              <el-form-item label="融资企业所属减排链">
                <el-input
                  placeholder="某减排链"
                  v-model="formLabelAlign.chain"
                ></el-input>
              </el-form-item>
              <el-form-item label="融资企业全称">
                <el-input
                  placeholder="某企业"
                  v-model="formLabelAlign.accountName"
                ></el-input>
              </el-form-item>
              <el-form-item label="碳信数量">
                <el-input
                  placeholder="XXXXXX"
                  v-model="formLabelAlign.num"
                ></el-input>
              </el-form-item>
              <el-form-item label="操作时间">
                <el-date-picker
                  v-model="formLabelAlign.date"
                  type="datetime"
                  placeholder="选择日期"
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
              <el-form-item label="保理企业">
                <el-input
                  placeholder="某企业"
                  v-model="formLabelAlign.companyOfferFund"
                ></el-input>
              </el-form-item>
              <el-form-item label="收款银行">
                <el-input
                  placeholder="某银行"
                  v-model="formLabelAlign.bank"
                ></el-input>
              </el-form-item>
              <el-form-item label="收款账户">
                <el-input
                  placeholder="某账户"
                  v-model="formLabelAlign.bankAccount"
                ></el-input>
              </el-form-item>
            </el-form>
          </el-col>
        </el-row>
        <el-row>
          <div class="usage-title">资金用途</div>
          <div class="usage-comment">
            <el-input
              type="textarea"
              :rows="8"
              placeholder="请输入内容"
              v-model="formLabelAlign.usage"
            >
            </el-input>
          </div>
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
import { submitCompanyFundApplication } from "@/utils/api.js";
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
      company: localStorage.getItem("name"),
      chain: localStorage.getItem("chain"),
      headerTitle: {
        largeTitle: "融资管理  ",
        smallTitle: "融资申请",
      },
      textarea: "",
      active: 1,
      dialogVisible: false,
      labelPositionTabs: "right",
      labelPositionForm: "top",
      formLabelAlign: {
        accountName: localStorage.getItem("name"),
        accountType: localStorage.getItem("accountType"),
        chain: localStorage.getItem("chain"),
        actionPassword: "",
        companyNeedFund: localStorage.getItem("name"),
        companyOfferFund: "",
        num: "",
        bankAccount: "",
        bank: "",
        usage: "",
        date: "",
      },
      rules: {
        actionPassword: [{ validator: validatePass, trigger: "blur" }],
      },
    };
  },
  methods: {
    submitForm(formLabelAlign) {
      //console.log(formLabelAlign);
      this.formLabelAlign.num = parseInt(this.formLabelAlign.num);

      this.$refs.formLabelAlign.validate(async (valid) => {
        if (valid) {
          //操作密码正确
          const { data: res } = await this.$http.post(
            "/fund/apply",
            formLabelAlign
          );
          console.log(formLabelAlign);
          if (res.conde != 0) {
            error(res.data.msg, this);
          } else {
            //成功
            console.log(res);
            this.dialogVisible = false;
            this.$message({
              message: "申请成功",
              type: "success",
            });
          }
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
.usage-title {
  font-size: 14px;
  margin: 10px 0px 15px 0px;
  color: #606266;
}
.usage-comment {
  height: 150px;
  border: 1px solid #eee;
  margin: 10px 0px 30px 0px;
  background-color: #fafcfe;
  border-radius: 5px;
}
</style>
