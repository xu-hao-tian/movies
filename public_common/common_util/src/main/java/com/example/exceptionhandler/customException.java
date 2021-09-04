package com.example.exceptionhandler;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 自定义异常类.
 *
 * @Author: 许昊天
 * @Date: 2021/09/04/10:17
 * @Description:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class customException extends RuntimeException{
    /**
     * 异常码
     */
    private Integer code;

    /**
     * 异常信息
     */
    private String msg;
}
