package org.sawork2022.ascii;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class AsciiCharListener extends KeyAdapter {
    // 通过 AsciiCharWriter 向面板写入一个字符
    private AsciiCharPrinter charPrinter = null;

    // 读取的按键放入 AsciiCharBuffer 中
    private AsciiCharBuffer charBuffer = null;

    public AsciiCharListener(AsciiCharPrinter charPrinter, AsciiCharBuffer charBuffer) {
        this.charPrinter = charPrinter;
        this.charBuffer = charBuffer;
    }

    @Override
    public void keyTyped(KeyEvent e) {
        char c = e.getKeyChar();
        if (c != KeyEvent.CHAR_UNDEFINED) {
            // 特殊字符，backspace
            if (c == KeyEvent.VK_BACK_SPACE) {
                if (charBuffer.popChar()) {
                    charPrinter.wipeChar();
                }
                return;
            }

            // 回显输入字符
            charPrinter.writeChar(c);
            // 放入缓冲区
            charBuffer.putChar(c);
        }
    }
}
