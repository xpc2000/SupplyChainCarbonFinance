import Vue from 'vue'
import App from './App.vue'
import { router } from './router'
import { routeNormal } from './router'
import store from './store'
import ElementUI from 'element-ui'; 
import 'element-ui/lib/theme-chalk/index.css';
import echarts from 'echarts';
import axios from 'axios' 


Vue.prototype.$http = axios
axios.defaults.baseURL="http://127.0.0.1:8081"

// Vue.prototype.$echarts = echarts
Vue.config.productionTip = false
Vue.use(ElementUI);
new Vue({
  router,
  store,
  render: h => h(App)
}).$mount('#app')



