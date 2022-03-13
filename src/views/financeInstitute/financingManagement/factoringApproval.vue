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
          <el-descriptions-item label="收款帐户">
            {{this.pledgeDetail.account}}
          </el-descriptions-item>
          <el-descriptions-item label="保理企业">
            {{this.pledgeDetail.factoringCompany}}
          </el-descriptions-item>
          <el-descriptions-item label="融资企业全称">
            {{this.pledgeDetail.company}}
          </el-descriptions-item>
          <el-descriptions-item label="收款银行">
            {{this.pledgeDetail.bank}}
          </el-descriptions-item>
          <el-descriptions-item label="资金用途">
            {{this.pledgeDetail.fundUse}}
          </el-descriptions-item>
          <el-descriptions-item label="碳信数量">
            {{this.pledgeDetail.amountCarbonTicket}}
          </el-descriptions-item>
          <el-descriptions-item label="附件">
            发票.png
          </el-descriptions-item>
        </el-descriptions>
      </div>

      <div class="description-title">
        <div class="table-rec"></div>
        审批操作
      </div>
      <div class="radio-approval-box">
        <el-radio v-model="radio" label="1">通过</el-radio>
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
import {updateInstitutionFundExamination} from "@/utils/api.js"
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
      pledgeDetail:"",
      headerTitle: {
        largeTitle: "融资管理",
        smallTitle: "保理审核",
      },
      edit: false,
      text: [
        {
          id: 1,
          label: "融资企业所属减排链",
          input: "某减排链",
        },
        {
          id: 2,
          label: "收款账户",
          input: "某账户",
        },
        {
          id: 3,
          label: "保理企业",
          input: "某企业",
        },
        {
          id: 4,
          label: "融资企业全称",
          input: "某企业",
        },
        {
          id: 5,
          label: "收款银行",
          input: "某银行",
        },
        {
          id: 6,
          label: "资金用途",
          input: "融资",
        },
        {
          id: 7,
          label: "碳信数量",
          input: "2300",
        },
        {
          id: 8,
          label: "附件",
          input: "发票.png",
        },
      ],
      dialogVisible: false,
      radio: "1",
      textarea: "",
      rules: {
        actionPassword: [{ validator: validatePass, trigger: "blur" }],
      },
      action:{
        accountName:localStorage.getItem("name"),
        accountType:localStorage.getItem("accountType"),
        actionPassword:"",
        id:"",
        comment:"",
      },
      radio: "1",
    };
  },
  async mounted(){
    this.pledgeID = parseInt(this.$route.params.id)
    const {data:res} = await this.$http.get("/factorSearch/" + this.pledgeID)
    this.pledgeDetail = res.data
    this.action.id = this.pledgeID
    console.log(this.pledgeDetail)
    if(this.radio == "1"){
      this.action.comment=true
    }
    else{
      this.action.comment=false
    }
    console.log(this.radio)
  },
  methods: {
    updateComment(label){
      this.action.comment = (label == 1)
      console.log(this.action)
    },
    
    submitForm(action) {
      this.$refs.action.validate(async valid => {
        if (valid) {
          this.dialogVisible = false;
          this.$confirm("确认签约操作")
            .then((_) => {
              updateInstitutionFundExamination(action).then((data)=>{
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
                  message: "完成签约",
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
