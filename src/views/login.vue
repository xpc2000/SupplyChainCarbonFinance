<template>
  <div class="content">
    <div class="container">
      <h4 class="font-weight-bold text-center">登录</h4>
      <el-form
        :model="formLogin"
        :rules="rules"
        label-width="80px"
        ref="formLogin"
      >
        <el-form-item label="用户名：" class="logininput1" prop="username">
          <el-input v-model="formLogin.username"></el-input>
        </el-form-item>
        <el-form-item label="密 码：" prop="password">
          <el-input v-model="formLogin.password" type="password"></el-input>
        </el-form-item>
        <el-form-item label="用户：" prop="usertype">
          <el-select v-model="value" placeholder="请选择"> </el-select>
          <el-option
            v-for="item in options"
            :key="item.value"
            :label="item.label"
            :value="item.value"
          >
          </el-option>
        </el-form-item>
      </el-form>

      <el-button
        class="login-button"
        @click="loginSubmit(formLogin)"
        type="primary"
      >
        <span class="logintext">登录</span>
      </el-button>
      <el-button class="login-button2" @click="loginReturn" type="success">
        <span class="logintext">返回主页</span>
      </el-button>
      <div class="tip" @click="register">没有账号？点击这里注册</div>
    </div>
    <!-- 修改弹框 -->
    <el-dialog
      title="修改密码"
      :visible.sync="editDialogVisible"
      width="30%"
      height="270px"
      style="margin-top: 10vh"
    >
      <el-form
        :model="editPassForm"
        :rules="editFormRules"
        ref="editPassFormRef"
        label-width="100px"
      >
        <el-form-item label="用户名：" prop="userName">
          <el-input v-model="editPassForm.userName" class="userName"></el-input>
        </el-form-item>
        <el-form-item label="原密码：" prop="beforePass">
          <el-input
            v-model="editPassForm.beforePass"
            class="beforePass"
          ></el-input>
        </el-form-item>
        <el-form-item label="新密码：" prop="newPass">
          <el-input v-model="editPassForm.newPass" class="newPass"></el-input>
        </el-form-item>
      </el-form>
      <div slot="footer">
        <el-button @click="editDialogVisible = false">取消</el-button>
        <el-button type="primary" @click="editPass()">确定</el-button>
      </div>
    </el-dialog>
  </div>
</template>
<script>
import { Login, getCount } from "@/utils/api.js";
import { success, error } from "@/utils/notify.js";
export default {
  name: "login",
  components: {},
  data() {
    return {
      formLogin: {
        username: "",
        password: "",
      },
      editDialogVisible: false,
      editPassForm: {
        userName: "",
        beforePass: "",
        newPass: "",
      },

      editFormRules: {
        userName: [
          {
            required: true,
            message: "请输入用户名",
            trigger: "blur",
          },
        ],
        beforePass: [
          {
            required: true,
            message: "请输入原密码",
            trigger: "blur",
          },
        ],
        newPass: [
          {
            required: true,
            message: "请输入新密码",
            trigger: "blur",
          },
        ],
      },
      rules: {
        username: [
          { trigger: "blur", required: true, message: "请输入用户名" },
        ],
        password: [{ trigger: "blur", required: true, message: "请输入密码" }],
      },
    };
  },
  mounted() {},
  methods: {
    loginReturn() {
      this.$router.push({ path: "/Count" });
    },
    loginSubmit(formLogin) {
      // 表单验证
      // console.log(this.formLogin.username)
      this.$refs.formLogin.validate((valid) => {
        if (valid) {
          let params = {
            userName: this.formLogin.username,
            password: this.formLogin.password,
          };
          //   console.log(params)
          Login(params).then((res) => {
            if (res.data.code == "201") {
              error(res.data.msg, this);
            } else {
              // getCount({userName:this.userName}).then(res=>{
              //     console.log(res)
              // })
              console.log(res);
              localStorage.setItem("username", this.formLogin.username);
              success(res.data.msg, this);

              this.$router.push({ path: "/index" });

              // let time = new Date().getTime()
              // localStorage.setItem('login',time)
            }
          });
        }
      });
    },
    showEditDialog() {
      this.editDialogVisible = true;
    },
    editPass() {
      let params = {
        userName: this.editPassForm.userName,
        password: this.editPassForm.beforePass,
        newPass: this.editPassForm.newPass,
      };
    },
    register() {
      this.$router.push("/Register");
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
