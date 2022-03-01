package org.sawork2022;

import org.sawork2022.ascii.AsciiConsole;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/*
    hello-world 模块基于 ascii-panel 项目完成了一个简单的，可以进行输入输出的
    控制台。resources 目录下的 base-config.xml 文件是关于 spring 构件装配的
    配置文件。
 */
public class HelloWorld {
    public static void main(String [] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("base-config.xml");
        AsciiConsole console = context.getBean(AsciiConsole.class);
        console.println("Hello, World!");
        console.print("Please tell me your name: ");
        String name = console.readLine();
        console.println("Nice to meet you, " + name + "!");
    }
}
