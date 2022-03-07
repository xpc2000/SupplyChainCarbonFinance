module.exports = {
    publicPath: './',
    outputDir: 'dist',
    assetsDir: 'static',
    lintOnSave: process.env.NODE_ENV === 'development',
    productionSourceMap: false,
    devServer: {
      port: 8080,
      open: true,
      overlay: {
        warnings: false,
        errors: true
      },
      // 代理跨域的配置
      proxy: {
          // 当我们的本地的请求 有/api的时候，就会代理我们的请求地址向另外一个服务器发出请求
          // 这里的api 表示如果我们的请求地址有/api的时候,就出触发代理机制
          // localhost:8888/api/abc  => 代理给另一个服务器
        '/api': {
          target: 'http://127.0.0.1:8081', // 跨域请求的地址
          changeOrigin: true, // 只有这个值为true的情况下 才表示开启跨域
          secure: false, // 如果是https接口，需要配置这个参数
          // 路径重写
          pathRewrite: {
              // 重新路由  localhost:8888/api/login  => www.baidu.com/api/login
              '^/api': '' // 假设我们想把 localhost:8888/api/login 变成www.baidu.com/login 就需要这么做 
          }
        }
      }
    }
  }
  // 注意：修改了配置文件后一定要重启才会生效
  