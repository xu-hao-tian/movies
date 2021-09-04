package com.example.movies.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.movies.entity.EduActor;
import com.example.movies.mapper.EduActorMapper;
import com.example.movies.query.ActorQuery;
import com.example.movies.service.EduActorService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 演员 服务实现类
 * </p>
 *
 * @author 许昊天
 * @since 2021-09-02
 */
@Service
public class EduActorServiceImpl extends ServiceImpl<EduActorMapper, EduActor> implements EduActorService {

    @Override
    public Map<String, Object> getActorList(Page<EduActor> page) {
        // 分页条件
        QueryWrapper<EduActor> wrapper = new QueryWrapper<>();
        wrapper.orderByDesc("id");
        baseMapper.selectPage(page,wrapper);
        // 当前页、总的页数、每页记录数、总的记录数
        long current = page.getCurrent();
        long pages = page.getPages();
        long size = page.getSize();
        long total = page.getTotal();
        // 记录
        List<EduActor> records = page.getRecords();
        // 上一页、下一页
        boolean hasPrevious = page.hasPrevious();
        boolean hasNext = page.hasNext();
        // 添加分页条件
        Map<String, Object> map = new HashMap<>();
        map.put("current", current);
        map.put("pages", pages);
        map.put("size", size);
        map.put("total", total);
        map.put("records", records);
        map.put("hasPrevious", hasPrevious);
        map.put("hasNext", hasNext);

        return map;
    }

    @Override
    public void pageQuery(Page<EduActor> page, ActorQuery actorQuery) {
        // 查询对象
        QueryWrapper<EduActor> queryWrapper = new QueryWrapper<>();
        queryWrapper.orderByDesc("sort");
        // 添加查询的条件
        if (actorQuery == null) {
            baseMapper.selectPage(page, queryWrapper);
            return ;
        }
        // 演员的名称
        String name = actorQuery.getName();
        // 演员的等级
        Integer level = actorQuery.getLevel();
        // 演员的时间段
        String begin = actorQuery.getBegin();
        String end = actorQuery.getEnd();
        // 判断
        if (name != null && !name.isEmpty()) {
            // 模糊
            queryWrapper.like("name", name);
        }
        if (level != null && !StringUtils.isEmpty(level + "")) {
            // 等于
            queryWrapper.eq("level", level);
        }
        if (begin != null && !begin.isEmpty()) {
            // 大于
            queryWrapper.ge("begin", begin);
        }
        if (end != null && !end.isEmpty()) {
            // 小于
            queryWrapper.le("end", end);
        }
        // 添加条件到mapper
        baseMapper.selectPage(page, queryWrapper);
    }
}
