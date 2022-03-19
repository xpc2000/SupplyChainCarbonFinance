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
              <el-form-item label="发行方全称">
                <el-input
                  :disabled="true"
                  placeholder=""
                  v-model="formLabelAlign.sender"
                ></el-input>
              </el-form-item>
              <el-form-item label="可发行碳信余额">
                <el-input
                  :disabled="true"
                  placeholder=""
                  v-model="avaliableCredit"
                ></el-input>
              </el-form-item>
              <el-form-item label="资金用途说明">
                <el-input
                  placeholder="资金用途详情"
                  v-model="formLabelAlign.usage"
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
              <!-- TODO -->
              <el-form-item label="发行方所属控排链">
                <el-input
                  :disabled="true"
                  placeholder=""
                  v-model="formLabelAlign.senderChain"
                ></el-input>
              </el-form-item>
              <el-form-item label="碳信交易数额">
                <el-input
                  placeholder="￥￥￥￥￥"
                  v-model="formLabelAlign.num"
                  type="number"
                ></el-input>
              </el-form-item>
              <el-form-item label="碳信发行日期">
                <el-date-picker
                  v-model="formLabelAlign.repoDate"
                  type="datetime"
                  placeholder="选择日期"
                >
                </el-date-picker>
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
              <el-form-item label="签收方全称">
                <el-input
                  placeholder="某减排链企业"
                  v-model="formLabelAlign.receiver"
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
              <el-form-item label="签收方所属减排链">
                <el-input
                  placeholder="某减排链"
                  v-model="formLabelAlign.receiverChain"
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
          class="demo-formLabelAlign"
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
import { ticketPublish } from "@/utils/api.js";
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
      avaliableCredit: localStorage.getItem("ticketUnissued"),
      pledgeID: 0,
      headerTitle: {
        largeTitle: "碳信管理 ",
        smallTitle: "碳信发行 ",
      },
      updatedUnissued: "",
      active: 1,
      textarea: "",
      dialogVisible: false,
      labelPositionTabs: "right",
      labelPositionForm: "top",
      formLabelAlign: {
        accountName: localStorage.getItem("name"),
        accountType: parseInt(localStorage.getItem("accountType")),
        actionPassword: "",
        senderChain: localStorage.getItem("chain"),
        sender: localStorage.getItem("name"),
        receiverChain: "",
        receiver: "",
        num: 0,
        usage: "",
      },
      rules: {
        actionPassword: [{ validator: validatePass, trigger: "blur" }],
      },
    };
  },

  methods: {
    submitForm(formLabelAlign) {
      this.formLabelAlign.num = parseInt(this.formLabelAlign.num);
      this.$refs.formLabelAlign.validate(async (valid) => {
        if (valid) {
          //操作正确
          console.log(formLabelAlign);
          this.dialogVisible = false;
          this.$confirm("确认发行碳信？").then((_) => {
            ticketPublish(formLabelAlign).then((data) => {
              console.log(data.data.conde);
              if (data.data.conde != 0) {
                this.dialogVisible = false;
                this.$message({
                  message: "密码不正确",
                  type: "warning",
                });
              } else {
                this.updatedUnissued =
                  this.avaliableCredit - this.formLabelAlign.num;
                console.log(
                  "updatedunissued",
                  this.updatedUnissued,
                  "this.ticketUnissued - this.formLabelAlign.num",
                  this.avaliableCredit - this.formLabelAlign.num
                );
                // localStorage.setItem("ticketUnissued", this.updatedUnissued)
                this.$message({
                  message: "碳信已发行",
                  type: "success",
                });
              }
            });
          });
        }
      });
    },
  },
  mounted() {
    // this.ticketUnissued =
    this.formLabelAlign.num = parseInt(this.formLabelAlign.num);
    // this.avaliableCredit = this.ticketUnissued
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
