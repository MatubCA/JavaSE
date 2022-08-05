package com.dong;

/**
 * ClassName: com.dong.ReturnMultiParam
 * date: 2022/8/4 15:48
 * Description:
 *
 * @author 苏无及
 * @since JDK 8
 */

/* 多个参数有返回值 */
@FunctionalInterface
public interface ReturnMultiParam {
    int method(int arg1, int arg2);
}
