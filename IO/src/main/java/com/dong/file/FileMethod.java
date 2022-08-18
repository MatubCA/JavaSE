package com.dong.file;/*
 * ClassName: com.dong.file.FileMethod
 * date: 2022/8/13 15:41
 * Description:
 * @author 苏无及
 * @version
 * @since JDK 8
 */

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

public class FileMethod {

    // 新建文件
    public static void createNewFile() throws IOException {
        File file = new File("E:\\Desktop\\a.txt");
        boolean newFile = file.createNewFile();
        System.out.println(newFile);
    }

    // 只能创建一个文件夹
    public static void mkdir(){
        File file = new File("E:\\Desktop\\b.txt");
        boolean mkdir = file.mkdir();
        System.out.println(mkdir);
    }

    // 可以创建多级目录
    public static void mkdirs(){
        File file = new File("E:\\Desktop\\c.txt\\d.txt");
        boolean mkdirs = file.mkdirs();
        System.out.println(mkdirs);
    }

    // 删除
    public void delete(){
        File file = new File("E:\\Desktop\\a.txt");
        try {
            boolean newFile = file.createNewFile();
            System.out.println("文件创建："+newFile);
        } catch (IOException e) {
            System.out.println("文件创建失败");
        }
        boolean delete = file.delete();
        System.out.println("文件删除："+delete);

        File file1 = new File("E:\\Desktop\\b.txt");
        boolean mkdirs = file1.mkdirs();
        System.out.println("单级文件夹："+mkdirs);
        boolean delete1 = file1.delete();
        System.out.println("删除单级目录："+delete1);

        File file2 = new File("E:\\Desktop\\c.txt\\d.txt");
        boolean mkdirs1 = file2.mkdirs();
        System.out.println("多级目录："+mkdirs1);
        boolean delete2 = file2.delete();
        System.out.println("删除多级目录："+delete2);
    }

    public static void isFile(){
        File file = new File("E:\\Desktop\\a.txt");
        System.out.println(file.exists());
        if (!file.exists()){
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        System.out.println(file.isFile());
        System.out.println(file.isDirectory());
        System.out.println(file.getName());
        System.out.println(file.getAbsolutePath());
        System.out.println(file.getPath());
    }

    public static void listFiles(){
        File file = new File("E:\\Desktop\\a.txt\\b.txt\\c.txt");
        if (!file.exists()) {
            file.mkdirs();
        }
        File file1 = new File("E:\\Desktop\\a.txt");
        File[] files = file1.listFiles();
        for (File file2 : files) {
            System.out.println(file2.getName());
        }
    }

    // 删除多级目录
    public static void deleteDir(File file){
        File[] files = file.listFiles();
        for (File file1 : files) {
            if (file1.isFile())
                file1.delete();
            else
                deleteDir(file1);
        }
        file.delete();
    }

    public static void selectFile(File file){
        File[] files = file.listFiles();
        HashMap<String, Integer> map = new HashMap<>();
        for (File file1 : files) {
            if (file1.isFile()){
                // 不转义的话，点可以匹配所有字符
                String endName = file1.getName().split("\\.")[1];
                if (map.containsKey(endName)){
                    Integer integer = map.get(endName);
                    integer ++;
                    map.put(endName, integer);
                }else{
                    map.put(endName,0);
                }
            }else{
                selectFile(file);
            }
        }
        System.out.println(map);
    }
}
