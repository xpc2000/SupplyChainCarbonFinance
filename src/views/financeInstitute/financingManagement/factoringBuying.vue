<template>
  <div class="sub-content-box">
    <header-title :headerTitle="headerTitle"></header-title>

    <div class="sub-content-body">
      <div class="description-title">
        <div class="table-rec"></div>
        审核信息
      </div>

      <div class="description-box">
        <el-descriptions model="factorVo">
          <el-descriptions-item label="收款账户">
            {{this.factorVo.bankAccount}}
          </el-descriptions-item>
          <el-descriptions-item label="融资企业全称">
            {{this.factorVo.companyNeedFund}}
          </el-descriptions-item>
          <el-descriptions-item label="保理企业">
            {{this.factorVo.companyOfferFund}}
          </el-descriptions-item>
          <el-descriptions-item label="碳信数量">
            {{this.factorVo.num}}
          </el-descriptions-item>
          <el-descriptions-item label="收款银行">
            {{this.factorVo.bank}}
          </el-descriptions-item>
          <el-descriptions-item label="操作日期">
            {{this.factorVo.date}}
          </el-descriptions-item>
          <el-descriptions-item label="资金用途">
            {{this.factorVo.usage}}
          </el-descriptions-item>
          <el-descriptions-item label="融资期限">
            {{this.factorVo.factorDDL}}
          </el-descriptions-item>
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
        </el-descriptions>
      </div>

      <div class="description-title">
        <div class="table-rec"></div>
        保理买入
      </div>
      <div class="radio-approval-box">
        <el-radio v-model="radio" label="1">买入</el-radio>
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
            :model="factorVo"
            status-icon
            :rules="rules"
            ref="factorVo"
            label-width="100px"
            class="demo-factorVo"
          >
            <el-form-item label="密码" prop="actionPassword">
              <el-input
                type="password"
                v-model="factorVo.actionPassword"
                autocomplete="off"
              ></el-input>
            </el-form-item>
            <el-form-item>
              <el-button type="primary" @click="submitForm(factorVo)"
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
import {updateInstitutionFundSigning} from "@/utils/api.js";
export default {
  data() {
    var validatePass = (rule, value, callback) => {
      if (value === "") {
        callback(new Error("请输入密码"));
      } else {
        if (this.factorVo.checkPass !== "") {
          this.$refs.factorVo.validateField("checkPass");
        }
        callback();
      }
    };
    return {
      factorVo:{
        accountName:localStorage.getItem("name"),
        accountType:localStorage.getItem("type"),
        actionPassword:"",
        companyNeedFund:"",
        companyOfferFund:localStorage.getItem("name"),
        num:0,
        bankAccount:"",
        date:"",
        bank:"",
        id:0,
        fund:0,
        interestRate:0.0,
        serviceRate:0.0,
        factorDDL:"",
        usage:"",
      },
      headerTitle: {
        largeTitle: "融资管理",
        smallTitle: "保理买入",
      },
      edit: false,
      editableText: [
        {
          id: 6,
          label: "利率",
          input: "可编辑",
          edit: false,
        },
        {
          id: 7,
          label: "服务费率",
          input: "可编辑",
          edit: false,
        },
        {
          id: 8,
          label: "融资金额",
          input: "可编辑",
          edit: false,
        },
        {
          id: 9,
          label: "质押金额",
          input: "可编辑",
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
  async mounted(){
    this.factorVo.id = parseInt(this.$route.params.id)
    const {data:res} = await this.$http.get("/factorSearch/" + this.factorVo.id)
    console.log(res.data)
    this.factorVo.bankAccount = res.data.account
    this.factorVo.num = res.data.amountCarbonTicket
    this.factorVo.usage = res.data.fundUse
    this.factorVo.bank = res.data.bank
    this.factorVo.companyNeedFund = res.data.company
    this.factorVo.date = "2022-03-12 14:07:59"
    this.factorVo.factorDDL = "2022-03-12 23:23:23"
    console.log(this.factorVo)
  },

  methods: {
    submitForm(factorVo) {
      this.$refs.factorVo.validate(async valid => {
        if (valid) {
          this.dialogVisible = false;
          this.$confirm("确认签订操作")
            .then((_) => {
              updateInstitutionFundSigning(factorVo).then((data)=>{
                console.log(data)
                if (data.data.conde != 0){
                  this.dialogVisible = false;
                  this.$message({
                  message: "密码不正确",
                  type: "warning",
                  });
                }
                else{
                  this.$message({
                  message: "完成签订",
                  type: "success",
                  });
                }
              })
            })
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
  margin-bottom: 13px;
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
  margin-top: 14px;
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
