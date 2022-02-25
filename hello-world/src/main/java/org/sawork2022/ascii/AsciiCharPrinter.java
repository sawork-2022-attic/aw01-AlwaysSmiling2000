package org.sawork2022.ascii;

import net.trystan.AsciiPanel;

public class AsciiCharPrinter {
    private AsciiPanel panel = null;

    public AsciiCharPrinter(AsciiPanel panel) {
        this.panel = panel;
    }

    // 转义字符只支持 \r 和 \n
    public void writeChar(char c) {
        if (c == '\r') {
            // 回到本行开头
            panel.setCursorX(0);
        } else if (c == '\n') {
            newLine();
        } else {
            panel.write(c);
            panel.repaint();
        }
    }

    // 擦除最后一个输出的字符
    public void wipeChar() {
        int cursorX = panel.getCursorX();
        int cursorY = panel.getCursorY();
        if (cursorX > 0) {
            panel.write(' ', cursorX - 1, cursorY);
            panel.setCursorX(cursorX - 1);
            panel.repaint();
        }
    }

    // 超出最后一行会回滚
    private void newLine() {
        int heightInChar = panel.getHeightInCharacters();
        int cursorY = panel.getCursorY();
        cursorY = cursorY + 1;
        // 回到第一行
        if (cursorY >= heightInChar) {
            int widthInChar = panel.getWidthInCharacters();
            panel.clear(' ', 0, 0, widthInChar, 1);
            cursorY = 0;
        }
        panel.setCursorY(cursorY);
        panel.setCursorX(0);
    }
}
