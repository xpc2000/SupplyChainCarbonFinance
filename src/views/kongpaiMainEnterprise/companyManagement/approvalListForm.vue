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
          <el-descriptions-item
            v-for="(item, index) in editableText"
            :key="item.id"
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
          <el-descriptions-item label="减排计划录入">
            减排计划方案.word</el-descriptions-item
          >
        </el-descriptions>
      </div>

      <div class="description-title">
        <div class="table-rec"></div>
        申报反馈
      </div>
      <div class="radio-approval-box">
        <el-radio v-model="radio" label="1">通过</el-radio>
        <el-radio v-model="radio" label="2">驳回</el-radio>
        <div class="radio-approval-comment-title">审批意见</div>
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
            :model="planVo"
            status-icon
            :rules="rules"
            ref="planVo"
            label-width="100px"
            class="demo-planVo"
          >
            <el-form-item label="密码" prop="actionPassword">
              <el-input
                type="password"
                v-model="planVo.actionPassword"
                autocomplete="off"
              ></el-input>
            </el-form-item>
            <el-form-item>
              <el-button type="primary" @click="submitForm(planVo)"
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
import { submitChainPlan } from "@/utils/api.js";
export default {
  data() {
    var validatePass = (rule, value, callback) => {
      if (value === "") {
        callback(new Error("请输入密码"));
      } else {
        if (this.planVo.checkPass !== "") {
          this.$refs.planVo.validateField("checkPass");
        }
        callback();
      }
    };
    return {
      planVo: {
        accountName: localStorage.getItem("name"),
        accountType: parseInt(localStorage.getItem("accountType")),
        actionPassword: "",
        chain: "",
        company: "",
        ticketNum: 0,
        ReductionNum: 0,
        year: "",
      },
      headerTitle: {
        largeTitle: "链属企业管理",
        smallTitle: "减排计划申报",
      },
      edit: false,
      editableText: [
        {
          id: 1,
          label: "所在控排链",
          input: localStorage.getItem("chain"),
          edit: false,
        },
        {
          id: 2,
          label: "执行企业",
          input: "创浦机械有限公司",
          edit: false,
        },
        {
          id: 3,
          label: "计划减排量",
          input: "3695",
          edit: false,
        },
        {
          id: 4,
          label: "申报碳信额度",
          input: "1456",
          edit: false,
        },
        {
          id: 5,
          label: "年份",
          input: "2022-03-13 21:51:03",
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
  async mounted() {
    this.planVo.year = this.editableText[4].input;
    this.planVo.chain = this.editableText[0].input;
    this.planVo.ReductionNum = parseInt(this.editableText[2].input);
    this.planVo.ticketNum = parseInt(this.editableText[3].input);
  },

  methods: {
    submitForm(planVo) {
      console.log(planVo);

      this.$refs.planVo.validate(async (valid) => {
        if (valid) {
          //操作密码正确
          const { data: res } = await submitChainPlan(planVo);
          console.log(res);
          if (res.conde != 0) {
            console.log("shibai ");
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
