// const { defineConfig } = require('@vue/cli-service')
module.exports = {
    transpileDependencies: true,
    devServer: {
        port: 8081,
        proxy: {
            '/api': {
                target: 'http://localhost:8080',
                ws: true,
                changeOrigin: true
            }
        }
    },
    outputDir: 'target/dist',
    assetsDir: 'static'
}
