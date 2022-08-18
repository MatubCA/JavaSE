package com.dong.arrayStream;/*
 * ClassName: com.dong.arrayStream.ArrayStream
 * date: 2022/8/14 19:31
 * Description:
 * @author 苏无及
 * @version
 * @since JDK 8
 */

import java.io.CharArrayReader;
import java.io.CharArrayWriter;
import java.io.IOException;
import java.lang.String;
import com.sun.xml.internal.messaging.saaj.util.ByteOutputStream;

import java.io.ByteArrayInputStream;
import java.lang.reflect.Array;
import java.util.Arrays;

public class ArrayStream {

    public static void byteArrayInputStream() throws IOException {
        byte[] bytes = {97, 98, 99, 100,101};
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bytes);
        int len;
        byte[] bytes1 = new byte[1024];
        while((len = byteArrayInputStream.read(bytes1)) != -1){
            System.out.println(new String(bytes1,0,len));
        }
        byteArrayInputStream.close();
    }

    public static void byteArrayOutputStream() throws IOException {
        byte[] bytes = {97, 98, 99, 100};
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bytes);
        ByteOutputStream byteOutputStream = new ByteOutputStream(1024);
        byte[] bytes1 = new byte[1024];
        int len;
        while((len = byteArrayInputStream.read(bytes1)) != -1){
            System.out.println(new String(bytes,0,len));
            byteOutputStream.write(bytes1,0,len);
        }
        System.out.println(Arrays.toString(bytes));
        byteArrayInputStream.close();
        byteOutputStream.close();
    }

    public static void charArrayReader() throws IOException {
        char[] chars = {'H', 'e', 'l', 'l', 'o', '!'};
        CharArrayReader charArrayReader = new CharArrayReader(chars);
        char[] chars1 = new char[1024];
        int len;
        while((len = charArrayReader.read(chars1)) != -1){
            System.out.println(new String(chars1,0,len));
        }
    }

    public static void charArrayWriter() throws IOException {
        char[] chars = {'H', 'e', 'l', 'l', 'o', '!'};
        CharArrayReader charArrayReader = new CharArrayReader(chars);
        char[] chars1 = new char[10];
        CharArrayWriter charArrayWriter = new CharArrayWriter();
        while(( charArrayReader.read()) != -1){
            charArrayWriter.write(chars1);
        }
        System.out.println(Arrays.toString(chars1));
    }
}
