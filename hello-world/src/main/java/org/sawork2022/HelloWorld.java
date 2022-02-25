package org.sawork2022;

import org.sawork2022.ascii.AsciiConsole;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

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
