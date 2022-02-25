package org.sawork2022.ascii;

public class AsciiCharReader {

    private AsciiCharBuffer charBuffer = null;

    public AsciiCharReader(AsciiCharBuffer charBuffer) {
        this.charBuffer = charBuffer;
    }

    // 从缓冲区读取一个字符
    public char nextChar() {
        return charBuffer.getChar();
    }
}
