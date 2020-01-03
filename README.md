### countly 历史版本

| 版本名称 | 说明 | git 标签 |
| :---: | :---: | :---: |
|  v1.0.0 | 第一版，可实现登录请求和自定义事件请求，使用示例详见Test | version--1.0.0 |


## 手动打包

- 打包成可运行jar和zip
```bash
mvn clean assembly:assembly
```
打包完成后，会在项目根目录下的 target 目录里生成一个`*.tar.gz`文件，解压运行`sh start.sh`即可启动服务

- 打包到本地maven仓库
```bash
mvn clean install -Dmaven.test.skip=true
```


## countly服务
部署方法，请自行百度谷歌。部署建议（用一台全新的服务器，没有nginx、node、mongodb等服务，并设置好代理，执行 ` wget -qO- http://c.ly/install | bash ` 自定义安装参考：[安装Countly Web Server过程记录](https://www.cnblogs.com/lulee007/p/4570325.html)）
- [Countly官方简介](https://resources.count.ly/v2.0/docs/users-guide)
- [安装常见问题](https://resources.count.ly/v2.0/docs/installation-faq)
- [官方API](https://www.stylefeng.cn/gunsVIP)