package com.dong.file;/*
 * ClassName: com.dong.file.FileTest
 * date: 2022/8/13 15:50
 * Description:
 * @author 苏无及
 * @version
 * @since JDK 8
 */

import org.junit.Test;

import javax.annotation.processing.SupportedAnnotationTypes;
import java.io.File;
import java.io.IOException;

public class FileTest {

    @Test
    public void test1() throws IOException {
        FileMethod.createNewFile();
    }

    @Test
    public void test2(){
        FileMethod.mkdir();
    }

    @Test
    public void test3(){
        FileMethod.mkdirs();
    }

    @Test
    public void test4(){
        FileMethod.isFile();
    }

    @Test
    public void test5(){
        FileMethod.listFiles();
    }

    @Test
    public void test6(){
        FileMethod.selectFile(new File("E:\\Desktop\\1"));
    }

    @Test
    public void test7(){
        String path1 = "E:\\Desktop\\a.txt";
        File file = Construct.getFile(path1);
        System.out.println(file);

        String path2 = "b.txt";
        File file1 = Construct.getFile(path1, path2);
        System.out.println(file1);

        File file2 = Construct.getFile(file, path2);
        System.out.println(file2);
    }
}
