### countly 历史版本

| 版本名称 | 说明 | git 标签 |
| :---: | :---: | :---: |
|  v1.0.0 | 第一版，可实现登录请求和自定义事件请求，使用示例详见Test | version--1.0.0 |


## 手动打包

```bash
mvn clean assembly:assembly
```
打包完成后，会在项目根目录下的 target 目录里生成一个`*.tar.gz`文件，解压运行`sh start.sh`即可启动服务

打包到本地maven仓库
```bash
mvn clean install -Dmaven.test.skip=true
```


countly服务部署方法，请自行百度谷歌。