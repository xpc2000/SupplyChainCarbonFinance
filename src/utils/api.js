import  request from './request.js'

//登录
export const Login = params => request.post ('/login', params)

//查询用户信息
export const getMessage = (params) => request.get('/getMessage', params );

//删除用户信息
export const deleteData = (params) => request.delete('/getCount', params );

