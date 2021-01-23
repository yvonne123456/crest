package com.hcc.crest.request;


import lombok.*;
import lombok.experimental.Accessors;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder()
@Accessors(chain = true)
public class Response<T>{

    /**
     * 成功或者失败
     */
    private boolean success;

    /**
     * code
     */
    private String code;


    /**
     * 内容
     */
    private T body;

    /**
     * 错误原因
     */
    private String errorMsg;

}
