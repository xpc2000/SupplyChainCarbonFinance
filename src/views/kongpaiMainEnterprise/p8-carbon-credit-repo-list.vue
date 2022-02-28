<template>
    <div class="sub-content-box">
       
            <div class="sub-content-header">
                <div class="sub-content-title-left">
                    <div class="sub-content-title-left-title">碳信管理</div>
                    <div class="sub-content-title-left-sublist-title">碳信回购</div>
                </div>
          
            </div>
            <div class="sub-content-comment">在期限内向持有碳信的企业回购碳信</div>
            <div class="sub-content-body">
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
                    
                    <el-table-column prop="option" label="操作" width="180"  align="center">
                            <el-button type="text">回购</el-button>
                  
                    </el-table-column>
                </el-table>
                
              
            
            </div>
            <div class="sub-content-import-export">
                <el-button><i class="el-icon-upload2"></i>列表导出</el-button>
                <el-button><i class="el-icon-download"></i>列表导入</el-button>
            </div>

    </div>
</template>
<script>


export default{
    data(){
        return{
             column:[ {

            prop: 'code',
            label: '发行编号',
            width: ""
            },
            {
            prop: 'time',
            label: '发行时间',
            width: ""
            },
            {
            prop: 'receiver',
            label: '签收方',
            width: ""
            },
            {
            prop: 'repoDate',
            label: '回购期限',
            width: ""
            },
            {
            prop: 'repoStatus',
            label: '回购状态',
            width: ""
            }
            
            ],
        tableData: [{
            code: '#0012451',
            time: '04/08/2020 12:34 AM',
            receiver: '减排链企业',
            repoDate:'04/08/2020 12:34 AM',
            repoStatus:'尚未回购',
 
          },
          {
          code: '#0012451',
            time: '04/08/2020 12:34 AM',
            receiver: '减排链企业',
            repoDate:'04/08/2020 12:34 AM',
            repoStatus:'尚未回购',
          }
          ]

            
        }
    },
    methods: {
        
    }
}
</script>


<style scoped>
.sub-content-body{
        background: #fff;
        margin: 20px 40px 40px;
        border-radius: 25px;
    
    }
.sub-content-comment{
     margin: 20px 40px 20px;
     color: #A0A3BD;
}

.el-table{
    border-radius: 20px;
}
.sub-content-import-export{
    margin-left: 40px;
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
</style>