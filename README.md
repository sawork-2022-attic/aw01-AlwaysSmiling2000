## 介绍

本仓库是在 [trystan](https://github.com/trystan) 的 [AsciiPanel](https://github.com/trystan/AsciiPanel) 项目基础上进行的二次开发。hello-world 目录下包含了一个使用 AsciiPanel 进行控制台输入输出的示例，它接收用户的输入并回显在窗口中。

## 如何运行

本项目已经包含一个可直接运行的 jar 包，只需要cd 到 hello-word 目录，然后执行
> java -jar target/ascii-console-1.0-SNAPSHOT-jar-with-dependencies.jar

如果要编译此项目，强烈建议使用 **IDEA** 打开。首先将 ascii-panel 安装到本地 maven 仓库，然后再运行 hello-word 下的 HelloWorld 主类（直接运行 jar 包程序启动比较慢）。在我本机上 IDEA 时常出现自动移除某个模块的现象，如果用 IDEA 打开后发现 hello-world 目录下的 pom 文件是橙色的，则表示 IDEA 认为该目录不是项目的一个模块，如果运行会报出找不到类路径下文件的错误。此时需要右键点击 hello-world 下的 pom 文件，选择将其添加到当前的 maven 工程（图标会变成蓝色），然后才能正常运行。控制台直接 mvn clean、mvn package 的话我自测是没问题的。
