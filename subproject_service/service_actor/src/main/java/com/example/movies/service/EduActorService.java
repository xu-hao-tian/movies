package com.example.movies.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.movies.entity.EduActor;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.movies.query.ActorQuery;

import java.util.Map;

/**
 * <p>
 * 演员 服务类
 * </p>
 *
 * @author 许昊天
 * @since 2021-09-02
 */
public interface EduActorService extends IService<EduActor> {
    /**
     * 演员分页
     * @param page 分页条件
     * @return
     */
    Map<String,Object> getActorList(Page<EduActor> page);

    /**
     * 演员条件分页
     * @param page 分页条件
     * @param actorQuery 查询条件
     */
    void pageQuery(Page<EduActor> page, ActorQuery actorQuery);
}
