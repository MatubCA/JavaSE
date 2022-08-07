package com.dong.exception;/*
 * ClassName: com.dong.catchException.CatchException
 * date: 2022/8/6 19:54
 * Description: 异常处理
 * @author 苏无及
 * @version
 * @since JDK 8
 */

public class CatchException {

    public void indexExp() {
        /*
         * Description: 对IndexOutOfBoundsException捕获,执行PlanB
         * @author: 苏无及
         * @date: 2022/8/6 19:56
         * @param:[]
         * @return:void
         */
        int[] array = {1, 2, 3, 4, 5};

        try {
            for (int i = 0; i < 6; i++) {
                System.out.println(array[i] + "");
            }
        } catch (IndexOutOfBoundsException e) {
            System.out.println("IndexOutOfBoundsException");
        }

    }

    public void throwIndexExp() {
        /*
         * Description: throw抛出异常
         * @author: 苏无及
         * @date: 2022/8/7 20:43
         * @param:[]
         * @return:void
         */
        int[] array = {1, 2, 3, 4, 5};

        for (int i = 0; i < 6; i++) {
            if (i == 5){
                throw new IndexOutOfBoundsException("数组索引越界!");
            }
            System.out.println(array[i] + "");
        }
    }

    public void throwsIndexExp() throws IndexOutOfBoundsException{
        /*
         * Description: 使用throws声明异常类型
         * @author: 苏无及
         * @date: 2022/8/7 20:53
         * @param:[]
         * @return:void
         */
        int[] array = {1, 2, 3, 4, 5};

        for (int i = 0; i < 6; i++) {
            System.out.println(array[i] + "");
        }
    }

    public void finallyExp(){
        /*
         * Description: 使用finally
         * @author: 苏无及
         * @date: 2022/8/7 20:59
         * @param:[]
         * @return:void
         */
        int[] array = {1, 2, 3, 4, 5};

        try {
            for (int i = 0; i < 6; i++) {
                System.out.println(array[i] + "");
            }
        } catch (IndexOutOfBoundsException e) {
            System.out.println("数组索引越界!");
        } finally {
            System.out.println("finally");
        }
    }
}
