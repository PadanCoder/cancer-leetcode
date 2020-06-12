package com.example.cancer.demo.util.Exception;

import java.io.Serializable;

/**
 * @author : linkc
 * @date : 11:08 2020/5/25
 */
public class ArrayException{

    public static class EmptyException extends MyException implements Serializable {

        public EmptyException(String message) {
            super(message);
        }
    }
}
