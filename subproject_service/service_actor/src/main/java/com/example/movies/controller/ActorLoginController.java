package com.example.movies.controller;

import com.example.util.R;
import org.springframework.web.bind.annotation.*;

/**
 * 自己编写一个登录.
 *
 * @Author: 许昊天
 * @Date: 2021/09/05/9:16
 * @Description:
 * @CrossOrigin 跨域
 */
@RestController
@RequestMapping("/user")
@CrossOrigin
public class ActorLoginController {
    @PostMapping("/login")
    public R login() { // 登录
        return R.ok().data("token", "admin");
    }

    @GetMapping("/info")
    public R info() { // 登录返回信息
        return R.ok()
                .data("roles", "admin")
                .data("name", "admin")
                .data("avatar", "xxx");
    }
}
