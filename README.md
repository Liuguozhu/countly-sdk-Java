### countly 历史版本

| 版本名称 | 说明 | git 标签 |
| :---: | :---: | :---: |
|  v1.0.0 | 第1版，可实现登录请求和自定义事件请求，使用示例详见Test | version--1.0.0 |
|  v1.0.2 | 第2版，可实现创建应用，使用示例详见Test | version--1.0.2 |
|  v1.0.3 | 第3版，修改参数，设备id移出config | version--1.0.3 |

### 项目说明
- 由于未找到官方关于JAVA比较方便使用的SDK，固创建此项目
- 本项目仅供技术研究使用，关于countly的任何问题，以官方说明为准。

### countly服务
- 部署方法，请自行百度谷歌。
- 部署建议：用一台全新的服务器，没有nginx、node、mongodb等服务，并设置好代理，执行 ` wget -qO- http://c.ly/install | bash `
- 自定义安装参考：[安装Countly Web Server过程记录](https://www.cnblogs.com/lulee007/p/4570325.html)
- [Countly官方地址](https://count.ly/)
- [Countly Help Center](https://support.count.ly/hc/en-us)
- [官方API](https://api.count.ly/reference)

### 手动打包

- 打包成可运行jar和zip
```bash
mvn clean assembly:assembly
```
打包完成后，会在项目根目录下的 target 目录里生成一个`*.tar.gz`文件，~~解压运行`sh start.sh`即可启动服务~~

- 打包到本地maven仓库
```bash
mvn clean install -Dmaven.test.skip=true
```
打包完成后，本地maven仓库中会有这个版本的文件；
在需要使用的项目pom.xml中添加如下代码即可使用

```
        <dependency>
            <groupId>coder</groupId>
            <artifactId>countly</artifactId>
            <version>1.0.0</version>
        </dependency>
```

