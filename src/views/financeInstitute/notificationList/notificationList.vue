<template>
    <div class="sub-content-box">
       
             <header-title :headerTitle="headerTitle"></header-title>

             <div class="sub-content-body">
                 <div  class="notification-box" 
                 :class="{'pin-backgorund':item.pin==true}"
                 v-for="(item,index) in notification"
                 :key=index>
                    <div class="notication-left-box">
                        <div class="notification-title">
                            {{item.message}}
                        </div>
                        <div class="notification-message">
                            {{item.day}} | {{item.time}}
                        </div>
                    </div>
                    <div class="notication-right-box" >
                        <img @click="pin(item)" class="pin-icon" src="@/assets/header-icon/bi_pin-angle-fill.svg" alt="">
                        <i class="el-icon-more more-icon"></i>
                    </div>
                 </div>
                 
                 

                 
                 
                
             </div>

    </div>
</template>
<script>
import headerTitle from "@/components/headerTitle.vue";
export default{
    data() {
        return{
            headerTitle: {
                largeTitle: "信息通知",
                smallTitle: "信息详情",
            },
            pinThis:false,
            notification:[
                {
                    message:"碳信到账提醒1",
                    day:"今天",
                    time:"8:00A.M",
                    pin:false

                },
                {
                    message:"碳信到账提醒2",
                    day:"今天",
                    time:"8:00A.M",
                     pin:false

                },
                {
                    message:"碳信到账提醒3",
                    day:"今天",
                    time:"8:00A.M",
                     pin:false

                }
            ]
        }
        
    },

    methods:{
        pin(item){
            
           item.pin = !item.pin
         
       
        }
    },
     components: {
    headerTitle,
  },
}
</script>

<style scoped>
.sub-content-body{
        background: #fff;
        margin: 20px 40px 40px;
        padding: 40px 20px;
        border-radius: 25px;
    
    }
.notification-box{
    display: flex;
    justify-content: space-between;
    align-items:center;
    margin-bottom: 20px;
    padding: 10px;
    background: #FAFAFA;

    
}
.notification-title{
    font-size: 16px;
    padding-bottom: 5px;
    color: #303030;
}
.notification-message{
    font-size: 14px;
    color: #91929E;
}
.notication-right-box{
    color: #B2B2B2;
}

.pin-icon{
    padding-right: 20px;
    cursor: pointer;
}
.more-icon{
    padding-right: 20px;
}
.pin-backgorund{
    background: #E0FAF3;
}
</style>

