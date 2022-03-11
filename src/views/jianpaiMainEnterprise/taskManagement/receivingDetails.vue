<template>
  <div class="sub-content-box">
    <header-title :headerTitle="headerTitle"></header-title>

    <div class="sub-content-body">
      <div class="description-title">
        <div class="table-rec"></div>
        审核信息
      </div>
      <div>
        <div class="description-box">
          <el-descriptions>
            <el-descriptions-item
              v-for="(item, index) in editableText"
              :key="item.id"
              :label="item.label"
            >
              {{ item.input }}
            </el-descriptions-item>
          </el-descriptions>
        </div>
      </div>
      <!-- 审核信息 -->
      <div class="description-title">
        <div class="table-rec"></div>
        签收详情
      </div>

      <!-- <el-descriptions class="description-box"> -->

      <div class="description-box">
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
      </div>

      <!-- </el-descriptions> -->

      <div class="description-title">
        <div class="table-rec"></div>
        审批操作
      </div>
      <div class="radio-approval-box">
        <el-radio v-model="radio" label="1">签收</el-radio>
        <el-radio v-model="radio" label="2">拒绝</el-radio>
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
              <el-button type="primary" @click="submitForm('ruleForm')"
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
import { loadCompanyTicketRow } from "@/utils/api.js";
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
      dialogVisible: false,
      radio: "1",
      textarea: "",
      ruleForm: {
        pass: "",
      },
      rules: {
        actionPassword: [{ validator: validatePass, trigger: "blur" }],
      },
      headerTitle: {
        largeTitle: "任务管理",
        smallTitle: "签收详情",
      },
      editableText: [
        {
          id: 1,
          label: "发行方所在供应链",
          input: "某控排链",
        },
        {
          id: 2,
          label: "签收方所在供应链",
          input: "某减排链",
        },
        {
          id: 3,
          label: "碳信转让金额",
          input: "2300",
        },
        {
          id: 4,
          label: "发行方企业全称",
          input: "某企业",
        },
        {
          id: 5,
          label: "签收方企业全称",
          input: "某企业",
        },
        {
          id: 6,
          label: "资金用途说明",
          input: "无",
        },
      ],

      column: [
        {
          prop: "sendername",
          label: "付款方",
          width: "",
        },

        {
          prop: "receiverName",
          label: "签收方",
          width: "",
        },
        {
          prop: "date",
          label: "碳信到账日期",
          width: "",
        },
        {
          prop: "amount",
          label: "碳信数量",
          width: "",
        },
        {
          prop: "status",
          label: "状态",
          width: "",
        },

        {
          prop: "file",
          label: "附件",
          width: "",
        },
      ],
      tableData: [
        {
          sendername: "某控排链企业",
          receiverName: "某减排链企业",
          date: "03-03-2022",
          amount: "2300",
          status: "待签收",
          file: "合同.pdf",
        },
      ],

      action: {
        accountName: localStorage.getItem("name"),
        accountType: localStorage.getItem("accountType"),
        actionPassword: "",
        id: "",
        comment: "",
      },
      receivedID: -999,
    };
  },

  // ==========================新增代码========================================
  async mounted() {
    this.receivedID = parseInt(this.$route.params.id);
    const { data: res } = await this.$http.get(
      "/ticketSearch/" + this.receivedID
    );
    this.receivedDetail = res.data;
    this.action.id = 13;
    if (this.radio == "1") {
      this.action.comment = true;
    } else {
      this.action.comment = false;
    }
    console.log(this.receivedDetail);
  },

  methods: {
    next() {
      this.$message({
        message: "提交成功",
        type: "success",
      });
    },
    submitForm(formName, formLabelAlign) {
      //console.log(formLabelAlign);

      this.$refs[formName].validate((valid) => {
        if (valid) {
          //操作密码正确
          this.dialogVisible = false;
          this.$message({
            message: "碳信已签收",
            type: "success",
          });
        } else {
          //操作密码不正确
          //console.log("error submit!!");
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
  margin: 30px 0px 30px 0px;

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
