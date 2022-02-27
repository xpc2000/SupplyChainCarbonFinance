<template>
  <div class="content">
    <div class="left-content">
      <div class="title">
        <img src="../assets/header-icon/LOGO.svg" />
        <span>碳信金融供应链</span>
      </div>

      <el-menu
        default-active="2"
        class="el-menu-vertical-demo"
        background-color="#156A59"
        text-color="#fff"
        active-text-color="#04B78A"
        style="height: calc(100% - 70px)"
        :router="true"
      >
        <div class="nav-small-label">减排链核心企业</div>
        <el-submenu index="1">
          <template slot="title">
            <i
              ><img src="../assets/header-icon/nav-icon-multiple.svg" alt=""
            /></i>
            <span>链属企业管理</span>
          </template>
          <el-menu-item-group>
            <el-menu-item
              index="/jianpaiMainChainEnterprise/p1-company-management-list"
            >
              <span>链属企业列表</span>
            </el-menu-item>
          </el-menu-item-group>
        </el-submenu>

        <el-submenu index="3">
          <template slot="title">
            <i
              ><img
                src="../assets/header-icon/nav-icon-management-board.svg"
                alt=""
            /></i>
            <span>碳信管理</span>
          </template>
          <el-menu-item-group>
            <el-menu-item
              index="/jianpaiMainChainEnterprise/p2-company-carbon-credit-account-detail"
              >企业碳信账户</el-menu-item
            >
            <el-menu-item
              index="/jianpaiMainChainEnterprise/p3-carbon-credit-transfer"
              >碳信转让</el-menu-item
            >
          </el-menu-item-group>
        </el-submenu>

        <el-submenu index="4">
          <template slot="title">
            <i
              ><img
                src="../assets/header-icon/nav-icon-management-board.svg"
                alt=""
            /></i>
            <span>融资管理</span>
          </template>
          <el-menu-item-group>
            <el-menu-item
              index="/jianpaiMainChainEnterprise/p4-financing-application"
              >融资申请</el-menu-item
            >
          </el-menu-item-group>
        </el-submenu>

        <el-submenu index="5">
          <template slot="title">
            <i
              ><img
                src="../assets/header-icon/nav-icon-management-board.svg"
                alt=""
            /></i>
            <span>任务管理</span>
          </template>
          <el-menu-item-group>
            <el-menu-item
              index="/jianpaiMainChainEnterprise/p5-carbon-receiving-task"
              >签收碳信</el-menu-item
            >
          </el-menu-item-group>
        </el-submenu>

        <el-menu-item index="/jianpaiMainChainEnterprise/p6-notifications-list">
          <i
            ><img src="../assets/header-icon/nav-icon-message-list.svg" alt=""
          /></i>
          <span>信息通知</span>
        </el-menu-item>
      </el-menu>
    </div>
    <div class="right-content">
      <div class="header">
        <div class="header-left">
          <input class="header-search-bar" type="text" placeholder="搜索框" />
        </div>
        <div class="header-right">
          <span class="header-right-change-language">中文</span>
          <img
            class="header-right-notification-icon"
            src="../assets/header-icon/notification-icon.svg"
            alt=""
          />
          <img
            @click="centerDialogVisible = true"
            class="header-right-profile-icon"
            src="../assets/header-icon/profile-icon.svg"
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
              v-model="ruleForm.usernamePass"
              autocomplete="off"
            ></el-input>
          </el-form-item>
          <el-form-item label="密码" prop="passwordPass">
            <el-input
              type="password"
              v-model="ruleForm.passwordPass"
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
      <router-view></router-view>
    </div>
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
      // username: "",
      // password: "",
      centerDialogVisible: false,
      ruleForm: {
        passwordPass: "",
        usernamePass: "",
      },
      rules: {
        passwordPass: [{ validator: validatePassword, trigger: "blur" }],
        usernamePass: [{ validator: validateUsername, trigger: "blur" }],
      },
    };
  },

  mounted() {
    console.log(this.$route);
    // this.submitLoginForm();
  },
  methods: {
    // JumpTologinPage() {
    //   if (this.passwordPass == "1" && this.usernamePass == "1") {
    //     this.$router.push("/");
    //     this.centerDialogVisible = false;
    //     this.usernamePass = "";
    //     this.usernamePass = "";

    //     this.$notify({
    //       title: '成功登录',
    //       // message: '这是一条成功的提示消息',
    //       type: 'success'
    //     });

    //   }

    // },

    // submitLoginForm(ruleForm) {
    //     // console.log(this.ruleForm)
    //     this.$axios({
    //       url:'http://127.0.0.1:3333/tablist',
    //       method:'post',
    //       data:{
    //         // 'username':this.ruleForm.usernamePass,
    //         // 'password':this.ruleForm.passwordPass
    //       }
    //     }).then((res)=>{
    //       if(res.data.status==200){
    //         let data = res.data;

    //         window.localStorage["token"]=res.data.data.token;
    //         window.localStorage["token"]=res.data.data.user.userId;

    //         if(localStorage.getItem('token')){
    //           this.$router.push("/");
    //         }else{
    //             this.$message.error('用户名或密码错误');
    //       }
    //         }
    //       }else{
    //          this.$message.error('用户名或密码错误');
    //       }
    //     }).catch((res)=>{
    //       console.log(res)
    //     })

    //     },
       submitLoginForm(ruleForm) {
          if(ruleForm.usernamePass==1&&ruleForm.passwordPass==1){
          this.$router.push("/");
          this.centerDialogVisible = false;
          this.usernamePass = "";
          this.usernamePass = "";
        
          this.$message({
            message: '成功登录',
            type: 'success'
          });
          }else if(ruleForm.usernamePass==2&&ruleForm.passwordPass==2){
          this.$router.push("/index2");
          this.centerDialogVisible = false;
          this.usernamePass = "";
          this.usernamePass = "";
        
          this.$message({
            message: '成功登录',
            type: 'success'
          });
          }else if(ruleForm.usernamePass==3&&ruleForm.passwordPass==3){
          this.$router.push("/index3");
          this.centerDialogVisible = false;
          this.usernamePass = "";
          this.usernamePass = "";
        
          this.$message({
            message: '成功登录',
            type: 'success'
          });
          }
          
          
          
          else{
            this.$message.error('登陆失败');
          }
       
            

        }

  },
};
</script>

<style>
.content {
  display: flex;
  background-color: #f5f7fa;
}
.nav-small-label {
  margin: 20px;
  font-size: 14px;
  color: #fff;
}
.el-submenu__title {
  font-size: 16px !important;
}
.el-submenu__title i {
  color: #fff !important;
}
.el-submenu__title i img {
  padding-right: 20px;
}
.el-menu-item {
  font-size: 16px !important;
}
.el-menu-item i {
  color: #fff !important;
}
.el-menu-item.is-active i {
  color: #209f85 !important;
}
.el-menu-item.is-active {
  background-color: #dbf7f0 !important;
  color: #209f85 !important;
}

.el-menu-item i img {
  padding-right: 20px;
}
.left-content {
  width: 260px;
  height: 100vh;
}
.right-content {
  width: calc(100vw - 260px) !important;
}

.title {
  width: 260px;
  height: 70px;
  display: flex;

  /* justify-content: center; */
  align-items: center;
  color: #fff;
  background-color: #156a59;
}

.title img {
  display: inline-block;
  width: 50px;
  height: 50px;
  margin-right: 15px;
  margin-left: 20px;
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

.sub-content-box {
  display: block;
}

.sub-content-header {
  display: flex;
  height: 44px;
  margin-top: 50px;

  width: calc(100vw - 260px);
  justify-content: space-between;
}
.sub-content-title-left {
  display: flex;
  justify-content: center;
  align-items: center;
  color: #6e7191;
  padding-left: 40px;
  font-size: 32px;
  line-height: 44px;
}

.sub-content-title-left-sublist-title {
  margin-left: 20px;
  font-size: 16px;
  background-color: #156a59;
  padding: 3px 8px;
  border-radius: 7px;
  color: #fff;
  height: 33px;
  line-height: 33px;
}

.sub-content-title-right {
  line-height: 44px;
  padding-right: 40px;
}

.el-button--primary {
  background: #156a59 !important;
  border-color: #156a59 !important;
}
.el-input--suffix .el-input__inner {
  margin-bottom: 30px;
}

.el-input :focus {
  border: 1px solid #209f85 !important;
}
</style>
