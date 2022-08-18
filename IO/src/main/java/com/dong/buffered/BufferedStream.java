package com.dong.buffered;/*
 * ClassName: com.dong.buffered.BufferedStream
 * date: 2022/8/13 20:59
 * Description:
 * @author 苏无及
 * @version
 * @since JDK 8
 */

import java.io.*;

public class BufferedStream {

    public static void copyFile(String starFile, String endFile) {
        /*
         * Description: 自动判断文件类型，进行复制
         * @author: 苏无及
         * @date: 2022/8/14 8:22
         * @param:[starFile, endFile]
         * @return:void
         */

        BufferedInputStream in = null;
        BufferedOutputStream out = null;
        BufferedReader reader = null;
        BufferedWriter writer = null;

        File file = new File(starFile);
        // 判断源文件是否存在
        if (file.exists()) {
            String str = file.getName().split("\\.")[1];
            // 字符文件
            if (str.equals("txt") || str.equals("java") || str.equals("c") || str.equals("cpp")) {
                try {
                    reader = new BufferedReader(new FileReader(starFile));
                    writer = new BufferedWriter(new FileWriter(endFile));
                    String s;
                    // 每次读一行数据
                    while ((s = reader.readLine()) != null) {
                        writer.write(s);
                        // 写入行分割符
                        writer.newLine();
                    }
                    // 强制刷出缓冲区数据
                    writer.flush();
                } catch (IOException e) {
                    e.printStackTrace();
                }finally {
                    closeFile(reader,writer);
                }
            } else {
                // 字节文件
                try {
                    in = new BufferedInputStream(new FileInputStream(starFile));
                    out = new BufferedOutputStream(new FileOutputStream(endFile));
                    int len;
                    while ((len = in.read()) != -1) {
                        out.write(len);
                    }
                    out.flush();
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    closeFile(in,out);
                }
            }
        } else {
            System.out.println("没有此文件，即将创建！");
            try {
                System.out.println("是否创建成功："+file.createNewFile());
                copyFile(file.getName(),endFile);
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }


    // 文件加密
    public static void encrypt(){
        BufferedInputStream in = null;
        BufferedOutputStream out = null;

        try {
            in = new BufferedInputStream(new FileInputStream("E:\\Desktop\\IU2.jpg"));
            out = new BufferedOutputStream(new FileOutputStream("E:\\Desktop\\IU3.jpg"));
            int len;
            while((len = in.read()) != -1){
                // 两次异或不变
                out.write(len^123);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            closeFile(in,out);
        }
    }

    // 关闭字符缓冲
    public static void closeFile(BufferedReader reader,BufferedWriter writer){
        if (reader != null) {
            try {
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if (writer != null) {
            try {
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    // 关闭字节缓冲
    public static void closeFile(BufferedInputStream in,BufferedOutputStream out){
        if (in != null) {
            try {
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if (out != null) {
            try {
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
