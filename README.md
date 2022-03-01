## 介绍

本仓库是在 [trystan](https://github.com/trystan) 的 [AsciiPanel](https://github.com/trystan/AsciiPanel) 项目基础上进行的二次开发。hello-world 目录下包含了一个使用 AsciiPanel 进行控制台输入输出的示例，它接收用户的输入并回显在窗口中。

## 如何运行

本仓库已经包含一个可直接运行的 jar 包，只需要cd 到 hello-word 目录，然后执行
```shell
java -jar target/ascii-console-1.0-SNAPSHOT-jar-with-dependencies.jar
```

直接运行 jar 包可能启动比较慢。如果要编译此项目，强烈建议使用 **IDEA** 打开。首先将 ascii-panel 安装到本地 maven 仓库，然后再运行 hello-word 下的 HelloWorld 主类
