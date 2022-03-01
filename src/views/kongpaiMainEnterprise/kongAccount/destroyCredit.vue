<template>
  <div class="sub-content-box">
    <header-title :headerTitle="headerTitle"></header-title>
    <div class="sub-content-body">
      <div class="description-title">
        <div class="table-rec"></div>
        填写表单
      </div>
      <el-row :gutter="40">
        <el-col :span="12">
          <el-form
            :label-position="labelPosition"
            label-width="80px"
            :model="formLabelAlign"
          >
            <el-form-item label="销毁方所属控排链">
              <el-input
                placeholder="控排链"
                v-model="formLabelAlign.kongpai"
              ></el-input>
            </el-form-item>
            <el-form-item label="销毁方">
              <el-input
                placeholder="控排链统一碳信账户"
                v-model="formLabelAlign.destroyerName"
              ></el-input>
            </el-form-item>
            <el-form-item label="款项余额">
              <el-input
                placeholder="￥100,000.00"
                v-model="formLabelAlign.moneyBalance"
              ></el-input>
            </el-form-item>
          </el-form>
        </el-col>
        <el-col :span="12">
          <el-form
            :label-position="labelPosition"
            label-width="80px"
            :model="formLabelAlign"
          >
            <el-form-item label="碳信销毁日期">
              <el-date-picker
                v-model="formLabelAlign.destroyedDate"
                type="date"
                placeholder="选择日期"
              >
              </el-date-picker>
            </el-form-item>
            <el-form-item label="碳信额度">
              <el-input
                placeholder="￥100,000.00"
                v-model="formLabelAlign.carbonCreditBalance"
              ></el-input>
            </el-form-item>
          </el-form>
        </el-col>
      </el-row>
      <div class="description-title">
        <div class="table-rec"></div>
        碳信创建明细
      </div>
      <el-row class="subcontent-summary">
        <el-table :data="tableData" style="width: 100%">
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
      </el-row>
      <div class="sub-content-submit-button">
        <el-button @click="dialogVisible = true" class="button-style"
          >提交</el-button
        >
      </div>
      <!-- 提交弹出操作密码面板 -->
      <el-dialog title="操作密码" :visible.sync="dialogVisible" width="30%">
        <el-form
          :model="ruleForm"
          status-icon
          :rules="rules"
          ref="ruleForm"
          label-width="100px"
          class="demo-ruleForm"
        >
          <el-form-item label="密码" prop="pass">
            <el-input
              type="password"
              v-model="ruleForm.pass"
              autocomplete="off"
            ></el-input>
          </el-form-item>
          <el-form-item>
            <el-button type="primary" @click="submitForm('ruleForm', tableData)"
              >提交</el-button
            >
          </el-form-item>
        </el-form>
      </el-dialog>
      <!-- 操作密码面板结束 -->
    </div>
  </div>
</template>
<script>
import headerTitle from "@/components/headerTitle.vue";
export default {
  data() {
    var validatePass = (rule, value, callback) => {
      if (value === "") {
        callback(new Error("请输入密码"));
      } else {
        if (this.ruleForm.checkPass !== "") {
          this.$refs.ruleForm.validateField("checkPass");
        }
        callback();
      }
    };
    return {
      headerTitle: {
        largeTitle: "碳控排链信账户",
        smallTitle: "碳信销毁",
      },
      labelPosition: "top",
      dialogVisible: false,
      ruleForm: {
        pass: "",
      },
      rules: {
        pass: [{ validator: validatePass, trigger: "blur" }],
      },
      formLabelAlign: {
        kongpai: "",
        destroyerName: "",
        moneyBalance: "",
        carbonCreditBalance: "",
        destroyedDate: "",
        aprovalPerson: "",
      },

      column: [
        {
          prop: "kongpai",
          label: "控排链",
          width: "",
        },

        {
          prop: "destroyerName",
          label: "销毁方",
          width: "",
        },
        {
          prop: "moneyBalance",
          label: "款项余额",
          width: "",
        },

        {
          prop: "carbonCreditBalance",
          label: "碳信额度",
          width: "",
        },
        {
          prop: "destroyedDate",
          label: "碳信销毁日期",
          width: "",
        },
        {
          prop: "aprovalPerson",
          label: "审核人",
          width: "",
        },
      ],
      tableData: [
        {
          kongpai: "某控排链",
          destroyerName: "核心企业",
          moneyBalance: "￥10,000.00",
          carbonCreditBalance: "￥10,000.00",
          destroyedDate: "02-02-2022",
          aprovalPerson: "陈某某",
        },
      ],
    };
  },
  methods: {
    submitForm(formName, tableData) {
      console.log(tableData);

      this.$refs[formName].validate((valid) => {
        if (valid) {
          //操作密码正确
          this.dialogVisible = false;
          this.$message({
            message: "操作成功",
            type: "success",
          });
          this.$confirm("确认销毁碳信？")
            .then((_) => {
              done();
            })
            .catch((_) => {});
        } else {
          //操作密码不正确
          console.log("error submit!!");
          return false;
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
.description-title {
  font-size: 18px;
  padding-top: 20px;
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
.sub-content-body {
  background: #fff;
  margin: 20px 40px 40px;
  padding: 20px 40px 20px 40px;
  border-radius: 25px;
  height: calc(70vh);
}
::v-deep .el-form-item__label {
  line-height: 14px;
}
::v-deep .el-input__inner {
  border-radius: 7px;
  height: 35px;
  background-color: #fafcfe;
}
::v-deep .el-input__inner input:hover {
  border: 1px solid #209f85;
}
.el-date-editor.el-input,
.el-date-editor.el-input__inner {
  width: 100%;
}
::v-deep .el-input--suffix .el-input__inner {
  margin: 0;
}

.subcontent-summary {
  margin-top: 30px;
  color: #a0a3bd;
  border: 1px solid #eee;
}

.sub-content-submit-button .el-button {
  width: 100px;
  height: 35px;
  border-radius: 7px;
  padding: 0;
  font-size: 14px;
}

.button-style {
  margin-top: 60px;
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
</style>


</style>
