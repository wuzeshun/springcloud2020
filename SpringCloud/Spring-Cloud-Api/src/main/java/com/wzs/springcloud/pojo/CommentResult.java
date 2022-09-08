package com.wzs.springcloud.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class CommentResult<T> implements Serializable {
    private int Code;
    private String message;
    private T data;
    public CommentResult(int code,String message){
        this.Code=code;
        this.message=message;
    }
}
