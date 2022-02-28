<template>
    <div class="sub-content-box">
       
            <div class="sub-content-header">
                <div class="sub-content-title-left">
                    <div class="sub-content-title-left-title">链属企业管理</div>
                    <div class="sub-content-title-left-sublist-title">链属企业列表</div>
                </div>
                <div class="sub-content-title-right">
                   <el-input v-model="input" placeholder="搜索"></el-input>
                </div>
            </div>
        
            
       
            <div class="sub-content-tabs">
                <el-tabs v-model="activeName" @tab-click="handleClick">
                    <el-tab-pane label="全部" name="first">
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
                                <el-table-column 
                                    label="状态" 
                                    width="180"
                                    align="center"> 
                                    <el-tag>已办理</el-tag>
                                </el-table-column>
                                <el-table-column prop="option" label="操作" width="180"  align="center">
                                     <el-button type="text">编辑</el-button>
                                     <el-button type="text">删除</el-button>
                                </el-table-column>
                         </el-table>
                         <div class="sub-content-import-export">
                            <el-button><i class="el-icon-upload2"></i>列表导出</el-button>
                            <el-button><i class="el-icon-download"></i>列表导入</el-button>
                        </div>
                    </el-tab-pane>
                    <el-tab-pane label="企业碳信账户待审批" name="second">企业碳信账户待审批</el-tab-pane>
                    <el-tab-pane label="企业碳信账户已办理" name="third">企业碳信账户已办理</el-tab-pane>
                   
                </el-tabs>
            </div>
            
                
            
           
      
    </div>
</template>
<script>


export default{
    data(){
        return{
            input:"",
            activeName: 'first',
            column:[ {

            prop: 'name',
            label: '公司名称',
            width: ""
            },
            {
            prop: 'relationship',
            label: '链属关系',
            width: ""
            },
            {
            prop: 'amount',
            label: '计划减排总量',
            width: ""
            },
            {
            prop: 'time',
            label: '减排时间段',
            width: ""
            },
            {
            prop: 'ccer',
            label: '碳信总额',
            width: ""
            }
            
            ],
        tableData: [{
            name: '青岛银行',
            relationship: '一级链属企业',
            amount: '3695',
            time:'2020-01 - 2020-12',
            ccer:'1455.58',
 
          },
          {
            name: '青岛银行',
            relationship: '一级链属企业',
            amount: '3695',
            time:'2020-01 - 2020-12',
            ccer:'1455.58',
          }
          ]

        }
    },
    methods: {
      handleClick(tab, event) {
        console.log(tab, event);
      }
    
    }
}
</script>
<style scoped>
/* .content{
    height: 300px;
} */
.right-content{
    overflow: hidden;
}
/* .sub-content-box{
    display: block;
    
} */

/* .sub-content-header{
    display: flex;
    height: 44px;
    margin-top: 50px;
   
    width: calc(100vw - 260px);
    justify-content: space-between;
}
.sub-content-title-left{
    display: flex;
    justify-content: center;
    align-items: center;
    color: #6E7191;
    padding-left: 40px;
    font-size: 32px;
    line-height: 44px;
  
}


.sub-content-title-left-sublist-title{
    margin-left: 20px;
    font-size: 16px;
    background-color: #209F85;
    padding: 3px 8px;
    border-radius: 7px;
    color: #fff;
    height: 33px;
    line-height: 33px;
    
} */

.sub-content-title-right{
    line-height: 44px;
    padding-right: 40px;
}

.sub-content-tabs{
padding-top: 10px;
 padding-left: 40px;
 padding-right: 40px;
 margin: 0 auto;
}

.sub-content-import-export{
    padding-top: 20px;
    
    
}


.sub-content-import-export .el-button
{
    width: 100px;
    height: 35px;
    border-radius: 7px;
    padding: 0;
     font-size: 14px;
    

}
.sub-content-import-export .el-button:focus{
 background: #fff;
 color: #209F85;
}

.sub-content-import-export .el-button:hover {
    background: #DBF7F0;
    color: #209F85;
}
::v-deep .el-input__inner{
    border-radius: 20px;
    
    height: 34px;
    padding-left: 20px; 

}

::v-deep .el-tabs__item.is-active{
    color: #209F85;
}
::v-deep .el-tabs__item :hover{
color: #209F85;
}

::v-deep .el-tabs__active-bar{
background-color: #209F85;
}
::v-deep .el-tabs__nav-wrap::after{
    background-color: #F5F7FA;
}
.el-tag{
    background-color: #DFEFFF;
    color: #369AFE;
    font-weight: bold;
    width: 100px;
}


</style>
