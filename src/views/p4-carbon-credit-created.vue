<template>
   	<div class="sub-content-box">

		<div class="sub-content-header">
			<div class="sub-content-title-left">
				<div class="sub-content-title-left-title">链属企业管理</div>
				<div class="sub-content-title-left-sublist-title">碳信创建</div>
			</div>
		</div>
        <div class="sub-content-body">
            <el-row  :gutter="40" >
                <el-col :span="8">
                    <el-form :label-position="labelPosition" label-width="80px" :model="formLabelAlign">
                        <el-form-item label="销毁方所属控排链">
                            <el-input  placeholder="控排链" v-model="formLabelAlign.kongpai"></el-input>
                        </el-form-item>
                        <el-form-item label="创建方">
                            <el-input  placeholder="控排链统一余额账户" v-model="formLabelAlign.sendername"></el-input>
                        </el-form-item>
                        <el-form-item label="签收方">
                            <el-input  placeholder="控排链统一余额账户" v-model="formLabelAlign.receivername"></el-input>
                        </el-form-item>
                    </el-form>
                </el-col>
                  <el-col :span="8">
                    <el-form :label-position="labelPosition" label-width="80px" :model="formLabelAlign">
                        <el-form-item label="款项余额">
                            <el-input placeholder="￥100,000.00" v-model="formLabelAlign.moneyBalance"></el-input>
                        </el-form-item>
                        <el-form-item label="碳额度">
                            <el-input placeholder="￥100,000.00" v-model="formLabelAlign.carbonCreditBalance"></el-input>
                        </el-form-item>
                        <el-form-item label="碳信创建日期">
                            <el-date-picker
                                v-model="formLabelAlign.createdDate"
                                type="date"
                                placeholder="选择日期">
                                </el-date-picker>
                        </el-form-item>
                    </el-form>
                </el-col>
                
            </el-row>
            <el-row class="subcontent-top-title">
                <el-col :span="12">碳信创建明细</el-col> 
            </el-row>
            <el-row class="subcontent-bellow-body">
                
                <el-table
                :data="tableData"
                style="width: 100%">
                    <el-table-column
                        v-for="(item, index) in column"
                        :key="index"
                        :prop="item.prop"
                        :label="item.label"
                        :width="item.width"
                        align="center">
                    </el-table-column>
                    
                </el-table>
            </el-row>
            <div class="sub-content-submit-button">
                <el-button  @click="dialogVisible=true" class="button-style">提交</el-button>
    
            </div>
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
                        <el-button type="primary" @click="submitForm('ruleForm',tableData)">提交</el-button>
                    </el-form-item>
                    
                    </el-form>
                </el-dialog>
            <!-- 操作密码面板结束 -->
        </div>
        
		
    </div>
</template>
<script>


export default{
    data(){
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
        return{ 
            labelPosition: 'top',
            dialogVisible:false,
            ruleForm: {
                pass: '123456',
            },
            rules: {
                pass: [
                    { validator: validatePass, trigger: 'blur' }
                ],
            },
            formLabelAlign: {
                kongpai:'',
                sendername: '',
                receiverName:'',
                moneyBalance: '',
                carbonCreditBalance:'',
                createdDate: '',

            },
            
            column:[ {

            prop: 'kongpai',
            label: '控排链',
            width: ""
            },
            
            {
            prop: 'sendername',
            label: '创建方',
            width: ""
            },
            {

            prop: 'carbonCode',
            label: '碳信创建编码',
            width: ""
            },
            {
            prop: 'receiverName',
            label: '签收方',
            width: ""
            },
            {
            prop: 'moneyBalance',
            label: '款项余额',
            width: ""
            },
            
            {
            prop: 'carbonCreditBalance',
            label: '碳信额度',
            width: ""
            },
            {
            prop: 'createdDate',
            label: '碳信创建日期',
            width: ""
            },
            {
            prop: 'aprovalPerson',
            label: '审核人',
            width: ""
            }
            
            ],
        tableData: [{
            kongpai: '某控排链',
            sendername: '核心企业',
            carbonCode: 'E2345D',
            receiverName: '核企碳信账户',
            moneyBalance:'￥10,000.00',
            carbonCreditBalance:'￥10,000.00',
            createdDate:'02-02-2022',
            aprovalPerson:'陈某某'
 
          }
          ]
			 
            
        }
    },
    methods:{
        submitForm(formName,tableData){
            // let password=this.formName;
            // this.$axios({
            //     method:'post',
            //     url:'http://127.0.0.1:3333/get_login',
            //     data:{ password: password}

            // }).then(res=>{
            //     console.log(res);
            //     let{code} = res.data;
            //     if(code == '200'){
            //         sessionStorage.setItem('password', password);
            //         console.log(password);
            //     }
            // })

            console.log(tableData)

            this.$refs[formName].validate((valid) => {

            if (valid) {//操作密码正确
                this.dialogVisible=false
                 this.$message({
                    message: '操作成功',
                    type: 'success'
                });


            } else {//操作密码不正确
                console.log('error submit!!');
                return false;
            }
            });
      },
      
      
    }
}
</script>
<style scoped>
  
    .sub-content-body{
        background: #fff;
        margin: 20px 40px 40px;
        padding: 20px;
        border-radius: 25px;
        height:calc(70vh);
    }
    ::v-deep .el-form-item__label{
        line-height: 14px;
    }
    ::v-deep .el-input__inner{
        border-radius: 7px;
        height: 35px;
        background-color:#FAFCFE;
    }
    ::v-deep .el-input__inner input:hover{
        border: 1px solid #209F85;
    }
    .el-date-editor.el-input, .el-date-editor.el-input__inner{
        width: 100%;
    }
    ::v-deep .el-input--suffix .el-input__inner{
        margin: 0;
    }
    .subcontent-bellow-body{
	    border-radius: 7px;
        border: 1px solid #eee;
        margin-top: 15px;
    }

    .subcontent-top-title{
        margin-top: 30px;
        color: #A0A3BD;
    }
   
    .sub-content-submit-button .el-button
    {
        width: 100px;
        height: 35px;
        border-radius: 7px;
        padding: 0;
        font-size: 14px;
    }

.sub-content-submit-button .button-style{
     margin-top: 60px;
   margin-right: 20px;
    width: 100px;
    height: 33px;
    border-radius: 7px;
    transition: .1s;
    border: none;
    text-align: center;
    box-sizing: border-box;
    background: #209F85;
    color: #fff;
}
.button-style:hover{
    background: transparent;
    border: 1px solid #209F85;
    color: #209F85;
    cursor: pointer;
}



</style>
