package com.dong.inputStreamReader;
/*
 * ClassName: com.dong.inputStreamReader.InputStreamReader
 * date: 2022/8/14 9:22
 * Description:
 * @author 苏无及
 * @version
 * @since JDK 8
 */


import java.io.*;

public class InputStreamReaderDemo {

    public static void method1() throws IOException {
        /**
         * Description: 默认编码格式读取文件
         * @author: 苏无及
         * @date: 2022/8/16 20:42
         * @param:[]
         * @return:void
         */
        InputStreamReader reader = new InputStreamReader(new FileInputStream("E:\\Desktop\\a.txt"));
        int len;
        while((len = reader.read()) != -1){
            System.out.print((char) len);
        }
        reader.close();
    }

    public static void method2() throws IOException {
        /**
         * Description: 指定GBK编码格式读取文件
         * @author: 苏无及
         * @date: 2022/8/16 20:43
         * @param:[]
         * @return:void
         */
        InputStreamReader reader = new InputStreamReader(new FileInputStream("E:\\Desktop\\a.txt"),"GBK");
        int len;
        while((len = reader.read()) != -1){
            System.out.print((char) len);
        }
        reader.close();
    }

    public static void method3() throws IOException {
        /**
         * Description: 默认编码格式写出数据
         * @author: 苏无及
         * @date: 2022/8/16 20:44
         * @param:[]
         * @return:void
         */
        OutputStreamWriter writer = new OutputStreamWriter(new FileOutputStream("E:\\Desktop\\b.txt"));
        writer.write("回首山河已入秋!");
        writer.flush();
        writer.close();
    }

    public static void method4() throws IOException {
        /**
         * Description: 指定GBK编码格式写出数据
         * @author: 苏无及
         * @date: 2022/8/16 20:44
         * @param:[]
         * @return:void
         */
        OutputStreamWriter writer = new OutputStreamWriter(new FileOutputStream("E:\\Desktop\\b.txt"),"GBK");
        writer.write("回首山河已入秋!");
        writer.flush();
        writer.close();
    }

    public static void method5() throws IOException {
        /**
         * Description: 默认编码格式进行数据传输
         * @author: 苏无及
         * @date: 2022/8/16 20:45
         * @param:[]
         * @return:void
         */
        InputStreamReader reader = new InputStreamReader(new FileInputStream("E:\\Desktop\\a.txt"));
        OutputStreamWriter writer = new OutputStreamWriter(new FileOutputStream("E:\\Desktop\\b.txt"));
        int len;
        while ((len = reader.read()) != -1){
            writer.write(len);
            writer.flush();
        }
        reader.close();
        writer.close();
    }

    public static void method6() throws IOException {
        /**
         * Description: 指定GBK编码格式进行数据传输
         * @author: 苏无及
         * @date: 2022/8/16 20:45
         * @param:[]
         * @return:void
         */
        // 1. 获取字符输入流
        InputStreamReader reader = new InputStreamReader(new FileInputStream("E:\\Desktop\\a.txt"),"GBK");
        // 2. 获取字符输出流
        OutputStreamWriter writer = new OutputStreamWriter(new FileOutputStream("E:\\Desktop\\b.txt"),"GBK");
        int len;
        // 3. 交换数据
        while ((len = reader.read()) != -1){
            writer.write(len);
            // 4. 刷新缓冲区
            writer.flush();
        }
        // 5. 关闭资源
        reader.close();
        writer.close();
    }
}

