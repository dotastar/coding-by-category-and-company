/*******************************************************************************
 * Copyright (c) 2014 Nan Zhang.
 * 
 *        Filename:   Read4096.java
 *         Created:   Nov 11, 2014 
 *          Author:   Nan Zhang 
 *    Organization:   https://github.com/Nan-Zhang
 *            Note:   Given API: int Read4096(char* buf); 
 *                    It reads data from a file and records the position so that the next time when it is called it read the next 4k chars (or the rest of the file, whichever is smaller) from the file.
 *                    The return is the number of chars read.
 *                    Todo: Use above API to Implement API 
 *                    int Read(char* buf, int n)" which reads any number of chars from the file.
 * All rights reserved.
 ******************************************************************************/
package google;

public class Read4096 {
    private StringBuilder BUFFER = new StringBuilder();
    private int BufferIdx = 0;
    private int BufferLen = 0;

    public int readN(int n, StringBuilder output) {//return value is real length of output
        int outputLen = 0;
        if (n <= 0) {
            return 0;
        }
        while (n > 0) {
            if (this.BufferLen == 0 || this.BufferIdx == this.BufferLen) {
                this.BufferLen = read4096API(this.BUFFER);
                this.BufferIdx = 0;
                if (this.BufferLen == 0) {
                    break;
                }
            } else {
                int remaining = this.BufferLen - this.BufferIdx;
                if (remaining >= n) {
                    output.append(this.BUFFER.substring(this.BufferIdx, this.BufferIdx + n));
                    this.BufferIdx = this.BufferIdx + n;
                    n = 0;
                    outputLen += n;
                } else {
                    output.append(this.BUFFER.substring(this.BufferIdx, this.BufferLen));
                    this.BufferIdx = this.BufferLen;
                    n -= remaining;
                    outputLen += remaining;
                }
            }
        }
        return outputLen;
    }

    //this is the API from Google
    public int read4096API(StringBuilder output) {
        return 0;
    }
}
