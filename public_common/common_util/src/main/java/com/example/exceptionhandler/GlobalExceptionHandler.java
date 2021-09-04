package com.example.exceptionhandler;

import com.example.util.R;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 全局统一异常信息类.
 *
 * @Author: 许昊天
 * @Date: 2021/09/04/10:21
 * @Description:
 * @ResponseBody // 返回的数据格式(json)
 */
@ControllerAdvice
public class GlobalExceptionHandler {
    @ApiOperation(value = "指定出现异常调用的方法")
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public R error(Exception e) {
        e.printStackTrace();
        return R.error().message("这是一个全局的异常...");
    }

    @ApiOperation(value = "自定义异常")
    @ExceptionHandler(customException.class)
    @ResponseBody
    public R error(customException e) {
        e.printStackTrace();
        return R.error().code(e.getCode()).message(e.getMessage());
    }

    @ApiOperation(value = "特定异常")
    @ExceptionHandler(ArithmeticException.class)
    @ResponseBody
    public R error(ArithmeticException e) {
        e.printStackTrace();
        return R.error().message("执行了ArithmeticException异常...");
    }
}
