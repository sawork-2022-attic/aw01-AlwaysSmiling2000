package org.sawork2022.ascii;

import net.trystan.AsciiPanel;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.*;

public class AsciiConsole extends JFrame {

    private static final String DEFAULT_ICON_PATH = "icon.png";

    private static final Color DEFAULT_BACKGROUND_COLOR = AsciiPanel.black;

    private static final Color DEFAULT_FOREGROUND_COLOR = AsciiPanel.brightWhite;

    private AsciiCharReader charReader = null;

    private AsciiCharPrinter charPrinter = null;

    private AsciiCharListener charListener = null;

    public AsciiConsole(AsciiPanel panel, AsciiCharReader charReader, AsciiCharPrinter charPrinter, AsciiCharListener charListener) {
        this.charReader = charReader;
        this.charPrinter = charPrinter;
        this.charListener = charListener;

        // 注册按键监听
        addKeyListener(charListener);

        // 设置前景、背景色
        panel.setDefaultForegroundColor(DEFAULT_FOREGROUND_COLOR);
        panel.setDefaultBackgroundColor(DEFAULT_BACKGROUND_COLOR);

        // 设置窗口为固定大小
        setContentPane(panel);
        pack();
        setResizable(false);

        // 设置窗口标题和图标
        setTitle("Ascii Panel Demo Application");
        try {
            Resource resource = new ClassPathResource(DEFAULT_ICON_PATH);
            Image icon = ImageIO.read(resource.getInputStream());
            setIconImage(icon);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 关闭窗口后退出应用程序
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        // 显示窗口
        setAlwaysOnTop(true);
        setVisible(true);
    }

    // 向 AsciiPanel 输出给定字符串
    // 转义字符只支持 \r 和 \n
    public void print(String s) {
        int n = s.length();
        for (int i = 0; i < n; ++i) {
            char c = s.charAt(i);
            charPrinter.writeChar(c);
        }
    }

    public void println(String s) {
        print(s);
        print("\n");
    }


    // 从 AsciiPanel 读取输入字符串
    // 跳过开头的空字符，并以空字符结束读取
    public String read() {
        StringBuilder sb = new StringBuilder();
        char c = charReader.nextChar();
        while (Character.isWhitespace(c)) {
            c = charReader.nextChar();
        }
        sb.append(c);
        c = charReader.nextChar();
        while (!Character.isWhitespace(c)) {
            sb.append(c);
            c = charReader.nextChar();
        }
        return sb.toString();
    }

    // 读取一整行，直到换行符
    public String readLine() {
        StringBuilder sb = new StringBuilder();
        char c = charReader.nextChar();
        while (c != '\n') {
            sb.append(c);
            c = charReader.nextChar();
        }
        return sb.toString();
    }
}
