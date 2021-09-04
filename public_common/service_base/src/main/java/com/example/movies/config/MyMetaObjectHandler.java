package com.example.movies.config;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * 自动完成数据添加的时间和修改的时间及逻辑删除的默认值填写.
 *
 * @Author: 许昊天
 * @Date: 2021/09/03/9:52
 * @Description:
 */
@Component
public class MyMetaObjectHandler implements MetaObjectHandler {

    @Override
    public void insertFill(MetaObject metaObject) { // 添加数据
        // 添加日期到指定的字段中
        setFieldValByName("gmtCreate", new Date(), metaObject);
        setFieldValByName("gmtModified", new Date(), metaObject);
        // 逻辑删除的默认值
        setFieldValByName("isDeleted", 0, metaObject);
    }

    @Override
    public void updateFill(MetaObject metaObject) { // 修改数据
        setFieldValByName("gmtModified", new Date(), metaObject);
    }
}
