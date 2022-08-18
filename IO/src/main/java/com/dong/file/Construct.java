package com.dong.file;/*
 * ClassName: com.dong.file.Construct
 * date: 2022/8/13 15:03
 * Description: 三种构造方法
 * @author 苏无及
 * @version
 * @since JDK 8
 */

import java.io.File;
import java.net.URI;

public class Construct {

    public static File getFile(String pathname){
        return new File(pathname);
    }

    public static File getFile(String path1,String path2){
        return new File(path1,path2);
    }

    public static File getFile(File file,String path){
        return new File(file,path);
    }

    public static File getFile(URI uri){
        return new File(uri);
    }
}
