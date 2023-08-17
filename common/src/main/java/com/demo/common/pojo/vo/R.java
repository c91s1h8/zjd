package com.demo.common.pojo.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.io.Serializable;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class R<T> implements Serializable {

    private static final long serialVersionUID = 1L;


    private Integer code;
    private String message;
    private T data;

    public static R ok() {
        return R.builder().code(200).message("请求成功").build();
    }

    public static R ok(Object data) {
        return R.builder().code(200).message("请求成功").data(data).build();
    }

    public static R error(String message) {
        return R.builder().code(500).message(message).build();
    }
}
