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
              :disabled="true"
              placeholder=""
              v-model="formLabelAlign.senderChain"
            ></el-input>
            </el-form-item>
            <el-form-item label="款项额度">
              <el-input
              :disabled="true"
              placeholder=""
              v-model="avaliableCredit"
            ></el-input>
            </el-form-item>
            <el-form-item label="碳信销毁日期">
              <el-date-picker
                v-model="formLabelAlign.destroyedDate"
                type="datetime"
                placeholder="选择日期"
              >
              </el-date-picker>
            </el-form-item>
          </el-form>
        </el-col>
        <el-col :span="12">
          <el-form
            :label-position="labelPosition"
            label-width="80px"
            :model="formLabelAlign"
          >
          <el-form-item label="销毁方">
            <el-input
            :disabled="true"
            placeholder=""
            v-model="formLabelAlign.sender"
          ></el-input>
          </el-form-item>
            <el-form-item label="碳信额度">
              <el-input
              :disabled="true"
              placeholder=""
              v-model="avaliableCredit"
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
            <el-button type="primary" @click="submitForm(formLabelAlign)"
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
import {ticketDestroy} from "@/utils/api.js"
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
      avaliableCredit:localStorage.getItem("ticketBuyback"),
      headerTitle: {
        largeTitle: "碳控排链信账户",
        smallTitle: "碳信销毁",
      },
      labelPosition: "top",
      dialogVisible: false,
      rules: {
        actionPassword: [{ validator: validatePass, trigger: "blur" }],
      },
      formLabelAlign: {
        accountName:localStorage.getItem("name"),
        accountType:parseInt(localStorage.getItem("accountType")),
        actionPassword:"",
        senderChain:localStorage.getItem("chain"),
        sender:localStorage.getItem("name"),
        receiverChain:localStorage.getItem("chain"),
        receiver:localStorage.getItem("name"),
        num:0,
        usage:"",
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
      ],
      tableData: [
        {
          kongpai: "某控排链",
          destroyerName: "核心企业",
          moneyBalance: "￥10,000.00",
          carbonCreditBalance: "￥10,000.00",
          destroyedDate: "02-02-2022",
        },
      ],
    };
  },
  methods: {
    submitForm(formLabelAlign) {
       this.formLabelAlign.num=parseInt(this.avaliableCredit)
        this.$refs.formLabelAlign.validate(async valid => {
        if (valid) {
          //操作密码正确
          this.dialogVisible = false;
          this.$confirm("确认销毁碳信？")
          .then((_) => {
              ticketDestroy(formLabelAlign).then((data)=>{
                if (data.data.conde != 0){
                  this.dialogVisible = false;
                  this.$message({
                  message: "密码不正确",
                  type: "warning",
                  });
                }
                else{
                   console.log(this.formLabelAlign);
                  this.$message({
                  message: "碳信已销毁",
                  type: "success",
                  });
                }
              })
            })

        } 
      });
    },
  },
  mounted(){
   
    this.formLabelAlign.num=parseInt(this.avaliableCredit)
     console.log(this.formLabelAlign)
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
