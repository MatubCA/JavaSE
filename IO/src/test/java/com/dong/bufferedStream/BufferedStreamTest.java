package com.dong.bufferedStream;/*
 * ClassName: com.dong.bufferedStream.BufferedStreamTest
 * date: 2022/8/13 20:59
 * Description:
 * @author 苏无及
 * @version
 * @since JDK 8
 */

import com.dong.buffered.BufferedStream;
import org.junit.Test;

public class BufferedStreamTest {

    @Test
    public void test1(){
        BufferedStream.encrypt();
    }

    @Test
    public void test2(){
        BufferedStream.copyFile("E:\\Desktop\\a.txt","E:\\Desktop\\b.txt");
    }
}
