package com.ieheima.java_exception;

//自定义异常要足够见名知义
public class AgeOutOfBoundsException extends RuntimeException {//说明是运行时错误
    public AgeOutOfBoundsException() {
    }

    public AgeOutOfBoundsException(String message) {
        super(message);
    }
}
