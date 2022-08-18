package com.dong.fileStream;/*
 * ClassName: com.dong.fileStream.FileStream
 * date: 2022/8/13 20:05
 * Description:
 * @author 苏无及
 * @version
 * @since JDK 8
 */


import java.io.*;

public class FileStream {

    public static void fileInputStream(){
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(new File("a.txt"));
            byte[] bytes = new byte[1024];
            int len;
            while((len = fis.read(bytes)) != -1){
                System.out.println(new java.lang.String(bytes,0,len));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void fileOutputStream(){
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream("a.txt",true);
            byte[] bytes = {'H','e','l','l','o','!'};
            fos.write(bytes);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void fileReader()  {
        FileReader fileReader = null;
        try {
            fileReader = new FileReader(new File("a.txt"));
            char[] chars = new char[1024];
            int len;
            while((len = fileReader.read(chars)) != -1) {
                System.out.println(new String(chars,0,len));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (fileReader != null) {
                try {
                    fileReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void fileWriter(){
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(new File("a.txt"),true);
            fileWriter.write(97);
            fileWriter.write(new char[]{'a','b','c'});
            fileWriter.write("我他妈来了！",0,2);
            fileWriter.write("我他妈来啦！");
            fileWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (fileWriter != null) {
                try {
                    fileWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
