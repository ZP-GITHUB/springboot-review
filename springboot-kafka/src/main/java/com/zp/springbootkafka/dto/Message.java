package com.zp.springbootkafka.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @author ZP
 * @date 2021/5/17.
 */
@Data
public class Message implements Serializable {
    private static final long serialVersionUID = 6678420965611108427L;

    private String from;

    private String message;

    public Message() {

    }

    public Message(String from, String message) {
        this.from = from;
        this.message = message;
    }

    @Override
    public String toString() {
        return "Message{" +
                "from='" + from + '\'' +
                ", message='" + message + '\'' +
                '}';
    }

    // get set 略
}