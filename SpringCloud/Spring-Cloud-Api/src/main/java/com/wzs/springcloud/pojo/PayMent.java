package com.wzs.springcloud.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class PayMent implements Serializable {
    private long id;
    private String serial;
    private String dataSource;
    public PayMent(String serial,String dataSource){
        this.serial=serial;
        this.dataSource=dataSource;
    }
}
