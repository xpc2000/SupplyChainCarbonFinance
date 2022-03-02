import axios from 'axios'
// import { config } from 'vue/types/umd'

//创建实例
const instance = axios.create({
    // baseURL: "http://39.99.139.14/api",//请求后台的地址
    baseURL: "https://127.0.0.1:8081/api",
    timeout:3000
})



//请求拦截
instance.interceptors.request.use( config =>{
    //获取token
    let token = localStorage.getItem("token");

    if(token){
        config.headers.token = token
    }
    //有其他需求可以写在这里====
    return config
},err=>{
    return Promise.reject(err)
})

//拦截器 相应拦截器
instance.interceptors.response.use(res=>{
    localStorage.setItem('token', res.data.token)
    return res
    
}, err =>{
    //如果权限失效，可再次做处理
    //比如token有时间限制
    return Promise.reject(err)
})


// 整体导出
export default instance;