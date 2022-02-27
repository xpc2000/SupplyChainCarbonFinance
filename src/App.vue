<template>
  <div id="app">
    <!-- <router-link></router-link> -->
    <router-view/>
  </div>
</template>

<script>
import layout from '@/layout';

export default {
  
  data(){
    return{

    }
  }
  // components:{
  //   layout
  // }
}
</script>

<style >
*{
  margin: 0;
  padding: 0;
}
input:focus{border:0rem;outline: none;}

#app{
 width: 100vw;
  height: 100vh;
  
}


</style>
