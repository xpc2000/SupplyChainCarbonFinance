<template>
  <div class="content">
    <div class="container">
      <h4 class="font-weight-bold text-center">登录</h4>

      <!-- 登录面板 -->
      <el-form
        :model="formLogin"
        :rules="rules"
        label-width="80px"
        ref="formLogin"
      >
        <el-form-item label="用户名：" class="logininput1" prop="userEmail">
          <el-input v-model="formLogin.userEmail"></el-input>
        </el-form-item>
        <el-form-item label="密 码：" prop="password">
          <el-input v-model="formLogin.password" type="password"></el-input>
        </el-form-item>
        <el-form-item label="角色：" prop="accountType">
          <el-select v-model="formLogin.accountType" placeholder="请选择">
            <el-option
              v-for="item in options"
              :key="item.value"
              :label="item.label"
              :value="item.value"
            >
            </el-option>
          </el-select>
        </el-form-item>
      </el-form>

      <!-- 登录按钮 -->
      <el-button
        class="login-button"
        @click="loginSubmit(formLogin)"
        type="primary"
      >
        <span class="logintext">登录</span>
      </el-button>

      <!-- 返回主页 -->
      <el-button class="login-button2" type="success">
        <span class="logintext">返回主页</span>
      </el-button>

      <div class="tip">没有账号？点击这里注册</div>
    </div>
  </div>
</template>
<script>
import { loginVerification } from "@/utils/api.js";
import { success, error } from "@/utils/notify.js";
export default {
  name: "login",
  components: {},
  data() {
    return {
      formLogin: {
        userEmail: "",
        password: "",
        accountType: "",
      },

      rules: {
        userEmail: [
          { trigger: "blur", required: true, message: "请输入用户名" },
        ],
        password: [{ trigger: "blur", required: true, message: "请输入密码" }],
        accountType: [
          { trigger: "blur", required: true, message: "请选择用户类型" },
        ],
      },

      options: [
        {
          value: 0,
          label: "金融机构",
        },
        {
          value: 1,
          label: "控排链核心企业",
        },
        {
          value: 2,
          label: "控排链链属企业",
        },
        {
          value: 3,
          label: "减排链核心企业",
        },
        {
          value: 4,
          label: "减排链链属企业",
        },
      ],
      value: "",
    };
  },
  mounted() {},
  methods: {
    loginSubmit(formLogin) {
      // 表单验证
      this.$refs.formLogin.validate(async valid => {
        if (!valid) return; 
        const {data:res} = await loginVerification(this.formLogin)
        console.log(res)

        // const {data:res} = await this.$http.post("user/login", this.formLogin);
            if (res.conde != 0) {
              error(res.data.msg, this);
            } else {
              // //console.log(res);
              localStorage.clear();
              localStorage.setItem("userEmail", this.formLogin.userEmail);
              localStorage.setItem("name", res.data.name)
              localStorage.setItem("chain", res.data.chain)
              localStorage.setItem("accountType", this.formLogin.accountType);
              success(res.data.msg, this);
              this.$router.push({ path: "/index" });
            }
        
      });
    },
  },
};
</script>
<style scoped>
.content {
  background: #156a59;
  width: 100vw;
  height: 100vh;
}
.container {
  margin-top: 10vh;
  padding: 20px;
  border: 1px solid #eee;
  background: #fff;
}
::v-deep .el-dialog {
  height: 37vh !important;
  background: #fff;
  padding-right: 2%;
}
.container {
  position: fixed;
  left: 50%;
  top: 35%;
  transform: translate(-50%, -50%);
  width: 360px;
}
.font-weight-bold {
  font-weight: 1000 !important;
  text-align: center;
  font-size: 1.5rem;
}
.el-form-item__label {
  font-size: 18px;
  font-weight: 500;
}
.login-button {
  background: #156a59 !important;
  border-color: #156a59 !important;
  margin-top: 20px !important;
  width: 100% !important;
}
.login-button2 {
  background: #f2a626 !important;
  border-color: #f2a626 !important;
  margin-top: 20px !important;
  width: 100% !important;
}
.logintext {
  font-weight: 500;
  font-size: 18px;
  color: #fff;
}

::v-deep .el-dialog {
  height: 28vh;
}
::v-deep .el-button + .el-button {
  margin-left: 0 !important;
}
::v-deep .el-button {
}
::v-deep.el-dialog__body {
  padding: 15px 20px;
}
::v-deep .el-dialog__footer {
  padding: 0px 20px 10px;
}
::v-deep .el-icon-close:before {
  cursor: pointer;
}
.editPass {
  position: absolute;
  top: 230px;
  right: 30px;
  font-size: 14px;
  color: #9c9494;
  cursor: pointer;
}
.el-form-item__label {
  color: #0d0d0d;
  font-size: 15px;
}
::v-deep .el-dialog__body {
  background: #fff;
}
.logininput1 {
  margin-top: 50px;
  margin-bottom: 30px;
}
.logininput {
  margin-bottom: 50px;
}
.tip {
  text-align: center;
  margin: 20px;
  color: #a2a0a0;
  cursor: pointer;
}
.tip:hover {
  color: #1b6ec2;
  text-decoration: underline;
}
</style>
