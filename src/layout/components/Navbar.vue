<template>
 <div class="navbar-container">
      <div class="header">
        <div class="header-left">
          <input class="header-search-bar" type="text" placeholder="搜索框" />
        </div>
        <div class="header-right">
          <span class="header-right-change-language">中文</span>
          <img
            class="header-right-notification-icon"
            src="@/assets/header-icon/notification-icon.svg"
            alt=""
          />
          <img
            @click="centerDialogVisible = true"
            class="header-right-profile-icon"
            src="@/assets/header-icon/profile-icon.svg"
            alt=""
          />
        </div>
      </div>

       <!-- 登陆面板 -->
      <el-dialog
        title="登录"
        :visible.sync="centerDialogVisible"
        width="30%"
        center
      >
        <!-- <el-input placeholder="输入用户名" v-model="username" clearable>
        </el-input> -->
        <el-form
          :model="ruleForm"
          status-icon
          :rules="rules"
          ref="ruleForm"
          label-width="100px"
          class="demo-ruleForm"
        >
          <el-form-item label="用户名" prop="usernamePass">
            <el-input
              type="text"
              v-model="ruleForm.username"
              autocomplete="off"
            ></el-input>
          </el-form-item>
          <el-form-item label="密码" prop="passwordPass">
            <el-input
              type="password"
              v-model="ruleForm.password"
              autocomplete="off"
            ></el-input>
          </el-form-item>
        </el-form>
        <!-- <el-input placeholder="请输入密码" v-model="password" show-password>
        </el-input> -->
        <span slot="footer" class="dialog-footer">
          <el-button @click="centerDialogVisible = false">取 消</el-button>
          <el-button type="primary" @click="submitLoginForm(ruleForm)"
            >确 定</el-button
          >
        </span>
      </el-dialog>
 </div>
</template>

<script>
export default {
 data() {
    var validateUsername = (rule, value, callback) => {
      if (value === "") {
        callback(new Error("请输入用户名"));
      }
    };

    var validatePassword = (rule, value, callback) => {
      if (value === "") {
        callback(new Error("请输入密码"));
      }
    };
    return {
      centerDialogVisible: false,
      ruleForm: {
        username: "",
        password: "",
      },
      rules: {
        password: [{ validator: validatePassword, trigger: "blur" }],
        username: [{ validator: validateUsername, trigger: "blur" }],
      },
    };
  },

  methods:{
     submitLoginForm(ruleForm) {if(ruleForm.username==1&&ruleForm.password==1){
      this.$router.push("/");
      this.centerDialogVisible = false;
      this.username = "";
      this.password = "";

      this.$message({
        message: '成功登录',
        type: 'success'
      });
      }else if(ruleForm.username==2&&ruleForm.password==2){
      this.$router.push("/index2");
      this.centerDialogVisible = false;
      this.username = "";
      this.password = "";

      this.$message({
        message: '成功登录',
        type: 'success'
      });
      }else if(ruleForm.username==3&&ruleForm.password==3){
      this.$router.push("/index3");
      this.centerDialogVisible = false;
      this.username = "";
      this.password = "";

      this.$message({
        message: '成功登录',
        type: 'success'
      });
      }else if(ruleForm.username==4&&ruleForm.password==4){
      this.$router.push("/index4");
      this.centerDialogVisible = false;
      this.username = "";
      this.password = "";

      this.$message({
        message: '成功登录',
        type: 'success'
      });
      }else if(ruleForm.username==5&&ruleForm.password==5){
      this.$router.push("/index5");
      this.centerDialogVisible = false;
      this.username = "";
      this.password = "";

      this.$message({
        message: '成功登录',
        type: 'success'
      });
      }
      else{
        this.$message.error('登陆失败');
      }
    },
  }
}
</script>

<style scoped>

.navbar-container {
width: calc(100vw - 260px) !important;
}
.header {
  height: 70px;
  border-bottom: 1px solid #eee;
  background-color: #156a59;
  display: flex;
  justify-content: space-between;
}
.header-right {
  display: flex;
  justify-content: center;
  align-items: center;
  padding: 15px;
}
.header-search-bar {
  width: 270px;
  height: 40px;
  border-radius: 20px;
  border: none;
  padding-left: 20px;
  margin-top: 15px;
  margin-left: 15px;
}
.header-right-change-language {
  padding-right: 15px;
  color: #fff;
}
.header-right-profile-icon {
  width: 40px;
  height: 40px;
  padding-left: 15px;
  cursor: pointer;
}
</style>