package org.sawork2022.ascii;

public class AsciiCharBuffer {

    private static final int MAX_BUFFER_SIZE = 4096;

    // 最多输入4096个字符且不读取，否则回滚
    private char [] buffer = new char[MAX_BUFFER_SIZE];

    // 写指针
    private int wp = 0;

    // 读指针
    private int rp = 0;

    public void putChar(char c) {
        // 放入缓冲区
        synchronized (this) {
            buffer[wp] = c;
            wp = (wp + 1) % MAX_BUFFER_SIZE;
            if (wp == rp) {
                rp = (rp + 1) % MAX_BUFFER_SIZE;
            }
            // 唤醒等待线程，如果有的话
            if (c == '\n') {
                this.notify();
            }
        }
    }

    // 获取缓冲区中的下一个字符
    public char getChar() {
        synchronized (this) {
            // 缓冲区为空，阻塞
            while (rp == wp) {
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            char c = buffer[rp];
            rp = (rp + 1) % MAX_BUFFER_SIZE;
            return c;
        }
    }

    // 弹出最后一个输入的字符
    // 缓冲区不空返回 true
    public boolean popChar() {
        synchronized (this) {
            if (rp != wp) {
                wp = (wp - 1 + MAX_BUFFER_SIZE) % MAX_BUFFER_SIZE;
                return true;
            }
            return false;
        }
    }
}
