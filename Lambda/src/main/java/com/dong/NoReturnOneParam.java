package com.dong;

/**
 * ClassName: com.dong.NoReturnParam
 * date: 2022/8/4 15:44
 * Description:
 *
 * @author 苏无及
 * @since JDK 8
 */

/* 一个参数无返回 */
@FunctionalInterface
public interface NoReturnOneParam {
    void method(Integer num);
}
