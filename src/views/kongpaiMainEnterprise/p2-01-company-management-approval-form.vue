<template>
  <div class="sub-content-box">
    <div class="sub-content-header">
      <div class="sub-content-title-left">
        <div class="sub-content-title-left-title">链属企业管理</div>
        <div class="sub-content-title-left-sublist-title">减排计划申报</div>
      </div>
    </div>

    <div class="sub-content-body">
      <div class="description-title">
        <div class="table-rec"></div>
        审核信息
      </div>
      <div>
        <el-descriptions class="description-box">
          <el-descriptions-item label="付款方全称"
            >某控排链</el-descriptions-item
          >
          <el-descriptions-item label="签收方全称"
            >某控排链企业</el-descriptions-item
          >
          <el-descriptions-item label="控排链账户可发行额度"
            >500,000.00</el-descriptions-item
          >
          <el-descriptions-item label="付款方链属关系"
            >控排链</el-descriptions-item
          >
          <el-descriptions-item label="签收方链属关系"
            >控排链企业</el-descriptions-item
          >
          <el-descriptions-item label="审批时间"
            >2020-03-03</el-descriptions-item
          >
          <el-descriptions-item label="申请提交时间"
            >2020-03-03</el-descriptions-item
          >
          <el-descriptions-item label="交易地址"
            >XXXXXXXXXXXXX</el-descriptions-item
          >
          <el-descriptions-item label="碳信申请额度">2300</el-descriptions-item>
        </el-descriptions>
      </div>
      <!-- 审核信息 -->
      <div class="description-title">
        <div class="table-rec"></div>
        附件信息
      </div>
      <div class="upload-file-box">
        <el-descriptions class="description-box">
          <el-descriptions-item label="减排计划录入"
            >企业减排计划方案.word</el-descriptions-item
          >
        </el-descriptions>
      </div>
      <div class="description-title">
        <div class="table-rec"></div>
        审批操作
      </div>
      <div class="radio-approval-box">
        <el-radio v-model="radio" label="1">通过</el-radio>
        <el-radio v-model="radio" label="2">驳回</el-radio>
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
        <el-dialog
        title="操作密码"
        :visible.sync="dialogVisible"
        width="30%"
        >
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
                <el-button type="primary" @click="submitForm('ruleForm')">提交</el-button>
            </el-form-item>
            
            </el-form>
        </el-dialog>
        <!-- 操作密码面板结束 -->
      </div>
    </div>
  </div>
</template>
<script>
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
    dialogVisible:false,
      radio: "1",
      textarea: "",
        ruleForm: {
            pass: '',
        },
        rules: {
            pass: [
            { validator: validatePass, trigger: 'blur' }
            ],
        }
    };
  },
  methods: {
    next() {
      this.$message({
        message: "提交成功",
        type: "success",
      });
    },
    submitForm(formName) {
        this.$refs[formName].validate((valid) => {
          if (valid) {
            alert('submit!');
          } else {
            console.log('error submit!!');
            return false;
          }
        });
      },
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
  margin-right: 20px;
  margin-top: 20px;
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
