package com.dong;

import com.dong.entity.Student;
import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * ClassName: com.dong.ReflectionTest
 * date: 2022/8/3 14:39
 * Description:
 *
 * @author 苏无及
 * @since JDK 8
 */
public class ReflectionTest {

    /*
        测试Class是否成功创建
     */
    @Test
    public void test1() throws ClassNotFoundException {
        GetObject object = new GetObject();
        Class<?> clazz1 = object.getObject1();
        Class<?> clazz2 = object.getObject2();
        Class<?> clazz3 = object.getObject3();
        Class<?> clazz4 = object.getObject4();
    }

    /*
        使用Class对象创建实例
     */
    @Test
    public void test2() throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        GetObject object = new GetObject();
        Class<?> clazz = object.getObject1();

        // 方法一: 直接使用newInstance方法,默认调用无参构造
        Student student = (Student)clazz.newInstance();

        // 方法二: 先获取构造函数,再通过构造函数得到对象
        // 获取Student类带两个参数的构造器
        Constructor<?> constructor = clazz.getConstructor(String.class, Integer.class);
        Student student1 = (Student)constructor.newInstance("大白", 12);
        System.out.println(student);
        System.out.println(student1);
    }

    /*
        获取方法
     */
    @Test
    public void test3() throws ClassNotFoundException, NoSuchMethodException {
        GetObject object = new GetObject();
        Class<?> clazz = object.getObject1();

        // 返回所有公共方法,包括继承类中的方法
        Method[] methods = clazz.getMethods();
        // 返回所有方法,包括公共 保护 默认 私有方法,但不包括继承的方法
        Method[] methods1 = clazz.getDeclaredMethods();
        // 返回特定的公共方法,第一个参数为方法名name,后面参数为该方法的参数parameterTypes
        Method method = clazz.getMethod("setName", String.class);
        // 返回特定的所有方法,包括私有方法
        Method method2 = clazz.getDeclaredMethod("setAge", Integer.class);

        for (Method method1 : methods) {
            System.out.println(method1);
        }
        System.out.println("-------------------------------------------------------");

        for (Method method1 : methods1) {
            System.out.println(method1);
        }
        System.out.println("----------------------------------------------------------");

        System.out.println(method);
        System.out.println("--------------------------------------------------------");

        System.out.println(method2);
    }

    /*
        获取构造器信息
     */
    @Test
    public void tes4() throws ClassNotFoundException, NoSuchMethodException {
        GetObject object = new GetObject();
        Class<?> clazz = object.getObject1();

        // 获取所有公共构造器
        Constructor<?>[] constructors = clazz.getConstructors();
        // 获取所有构造器,包括公共 保护 默认 私有构造器
        Constructor<?>[] constructors1 = clazz.getDeclaredConstructors();
        // 获取特定公共构造器,参数parameterTypes
        Constructor<?> constructor = clazz.getConstructor(String.class, Integer.class);
        // 获取特定私有构造器
        Constructor<?> constructor2 = clazz.getDeclaredConstructor();

        for (Constructor<?> constructor1 : constructors) {
            System.out.println(constructor1);
        }
        System.out.println("------------------------------------------------------------");

        for (Constructor<?> constructor1 : constructors1) {
            System.out.println(constructor1);
        }
        System.out.println("-----------------------------------------------------------------");

        System.out.println(constructor);
        System.out.println("-------------------------------------------------------");

        System.out.println(constructor2);
    }

    /*
        获取字段信息
     */
    @Test
    public void test5() throws ClassNotFoundException, NoSuchFieldException {
        GetObject object = new GetObject();
        Class<?> clazz = object.getObject1();

        // 返回所有公共字段
        Field[] fields = clazz.getFields();
        // 返回所有字段
        Field[] fields1 = clazz.getDeclaredFields();
        // 获取特定的公共字段
        Field name = clazz.getField("name");
        // 获取特定的非公共字段
        Field name1 = clazz.getDeclaredField("name");

        for (Field field : fields) {
            System.out.println(field);
        }
        System.out.println("------------------------------------");

        for (Field field : fields1) {
            System.out.println(field);
        }
        System.out.println("------------------------------------------");

        System.out.println(name);
        System.out.println("--------------------------------------------");

        System.out.println(name1);
    }

    /*
        测试调用拿到方法 invoke()
     */
    @Test
    public void test6() throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException, InstantiationException {
        GetObject object = new GetObject();
        Class<?> clazz = object.getObject1();
        Object student = clazz.newInstance();

        Method setName = clazz.getMethod("setName", String.class);
        Method getName = clazz.getMethod("getName");

        setName.invoke(student, "黑夫");
        Object result = getName.invoke(student);

        System.out.println(result);
    }

    /*

     */
    @Test
    public void test7() throws ClassNotFoundException {
        GetObject object = new GetObject();
        Class<?> clazz = object.getObject1();


    }

}
