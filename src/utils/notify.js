export const success = (msg, that) => {
    that.$message({
        message: '成功登录',
        type: 'success'
      })
}

export const error = (msg,that) => {
    that.$message.error('密码或用户名错误');
}