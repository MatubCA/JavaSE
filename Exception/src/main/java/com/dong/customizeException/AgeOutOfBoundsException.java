package com.dong.customizeException;/*
 * ClassName: com.dong.demo.AgeOutOfBoundsException
 * date: 2022/8/7 18:25
 * Description:
 * @author 苏无及
 * @version
 * @since JDK 8
 */

public class AgeOutOfBoundsException extends RuntimeException {

    public AgeOutOfBoundsException() {
    }

    public AgeOutOfBoundsException(String message) {
        super(message);
    }
}
