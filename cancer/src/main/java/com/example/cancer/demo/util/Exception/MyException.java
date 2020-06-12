package com.example.cancer.demo.util.Exception;

import com.example.cancer.demo.algorithm.sort.bubble.Run;

/**
 * @author : linkc
 * @date : 10:59 2020/5/25
 */
public abstract class MyException extends RuntimeException{

    private String message;

    public MyException(String message){
        this.message = message;
    }

    public String getMessage(){
        return message;
    }
}
