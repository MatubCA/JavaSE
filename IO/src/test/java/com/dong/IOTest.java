package com.dong;/*
 * ClassName: com.dong.IOTest
 * date: 2022/8/16 18:49
 * Description:
 * @author 苏无及
 * @version
 * @since JDK 8
 */

import com.dong.inputStreamReader.InputStreamReaderDemo;
import com.dong.objectStream.ObjectStreamDemo;
import com.dong.properties.PropertiesDemo;
import org.junit.Test;

import java.io.IOException;

public class IOTest {

    /*
        用于测试Properties集合
     */
    @Test
    public void test1() throws IOException {
        PropertiesDemo.method4();
    }

    /*
        测试序列化和反序列化
     */
    @Test
    public void test2() throws IOException, ClassNotFoundException {
        ObjectStreamDemo.method2();
    }

    /*
        测试转换流
     */
    @Test
    public void test3() throws IOException {
        InputStreamReaderDemo.method6();
    }

}
