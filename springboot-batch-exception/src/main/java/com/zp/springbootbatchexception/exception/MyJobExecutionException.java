package com.zp.springbootbatchexception.exception;

/**
 * @author ZP
 * @date 2021/4/18.
 */
public class MyJobExecutionException extends  Exception{

    private static final long serialVersionUID = 7168487913507656106L;

    public MyJobExecutionException(String message) {
        super(message);
    }
}