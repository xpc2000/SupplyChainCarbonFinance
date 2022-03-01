<template>
    <div class="menu-box">
          <i class="menu-icon" :class="icon"></i>
            <span>{{title}}</span>
    </div>
</template>
<script>
export default({
    name:"MenuItem",
    props:["icon", "title"],
    data(){
        return{

        }
    }
})

</script>
<style scoped>
.menu-box {
display: flex;
align-items: center;
}
.menu-icon {
color: #fff !important;
margin-right: 10px;

}
</style>