package com.dong;

import com.dong.entity.Student;

/**
 * ClassName: com.dong.GetObject
 * date: 2022/8/3 12:24
 * Description: 获得Class对象
 *
 * @author 苏无及
 * @since JDK 8
 */
public class GetObject {

    public Class<?> getObject1() throws ClassNotFoundException {
        /*
         * Description: 通过全类名获得Class对象
         * @author: 苏无及
         * @date: 2022/8/3 12:37
         * @param:[]
         * @return:java.lang.Class<com.dong.entity.Student>
         */
        return Class.forName("com.dong.entity.Student");
    }

    public Class<?> getObject2() {
        /*
         * Description: 通过对象获得Class对象
         * @author: 苏无及
         * @date: 2022/8/3 12:37
         * @param:[]
         * @return:java.lang.Class<com.dong.entity.Student>
         */
        Student student = new Student("小黑", 22);
        return  student.getClass();
    }

    public Class<?> getObject3() {
        /*
         * Description: 通过类获得Class对象
         * @author: 苏无及
         * @date: 2022/8/3 12:39
         * @param:[]
         * @return:java.lang.Class<com.dong.entity.Student>
         */
        return Student.class;
    }

    public Class<?> getObject4() throws ClassNotFoundException {
        /*
         * Description: 通过类加载器获得Class对象
         * @author: 苏无及
         * @date: 2022/8/3 12:44
         * @param:[]
         * @return:java.lang.Class<com.dong.entity.Student>
         */
        return  ClassLoader.getSystemClassLoader().loadClass("com.dong.entity.Student");
    }
}
