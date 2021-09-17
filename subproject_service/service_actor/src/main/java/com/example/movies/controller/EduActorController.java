package com.example.movies.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.movies.entity.EduActor;
import com.example.movies.query.ActorQuery;
import com.example.movies.service.EduActorService;
import com.example.util.R;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 演员 前端控制器
 * </p>
 *
 * @author 许昊天
 * @since 2021-09-02
 * @CrossOrigin 解决跨域问题
 */
@RestController
@RequestMapping("/edu-actor")
public class EduActorController {
    /**
     * 依赖注册service
     */
    @Autowired
    private EduActorService actorService;

    @ApiOperation("显示演员信息")
    @GetMapping("/list")
    public R list(){
        return R.ok().data("items", actorService.list(null));
    }

    @ApiOperation("保存演员数据")
    @PostMapping("/save")
    public R saveActor(@RequestBody EduActor actor){
        actorService.save(actor);
        return R.ok();
    }

    @ApiOperation("逻辑删除演员")
    @DeleteMapping("del/{id}")
    public R delete(@ApiParam(name = "id", value = "演员的主键", required = true)
                    @PathVariable String id){
        actorService.removeById(id);
        return R.ok();
    }

    @ApiOperation("演员条件分页")
    @PostMapping("/{page}/{limit}")
    public R listPage(@ApiParam(name = "page", value = "当前页码", required = true)
                      @PathVariable long page,
                      @ApiParam(name = "limit", value = "每页显示的记录数", required = true)
                      @PathVariable long limit,
                      @ApiParam(name = "actorQuery",value = "查询对象",required = false) @RequestBody(required = false) ActorQuery actorQuery){
        // 创建分页对象
        Page<EduActor> actorPage = new Page<>(page, limit);
        // 构造分页条件
        QueryWrapper<EduActor> wrapper = new QueryWrapper<>();
        if (actorQuery != null) {
            String name = actorQuery.getName();
            Integer level = actorQuery.getLevel();
            String begin = actorQuery.getBegin();
            String end = actorQuery.getEnd();
            // 拼接条件
            if (!StringUtils.isEmpty(name)) {
                wrapper.like("name", name);
            }
            if (!StringUtils.isEmpty(level)) {
                wrapper.eq("level", level);
            }
            if (!StringUtils.isEmpty(begin)) {
                wrapper.ge("gmt_create", begin);
            }
            if (!StringUtils.isEmpty(end)) {
                wrapper.le("gmt_create", end);
            }
        }
        // 排序
        wrapper.orderByDesc("gmt_create");
        // 分页
        actorService.page(actorPage, wrapper);
        // 总记录数
        long total = actorPage.getTotal();
        // 没有显示的记录
        List<EduActor> records = actorPage.getRecords();
        // 返回
        return R.ok().data("total", total).data("items", records);
    }

    @ApiOperation("获取需要更新的对象")
    @GetMapping("/data/{id}")
    public R getData(@PathVariable String id) {
        EduActor actor = actorService.getById(id);
        return R.ok().data("actor", actor);
    }

    @ApiOperation("更新演员信息")
    @PutMapping("/update")
    public R update(@RequestBody EduActor actor) {
        actorService.updateById(actor);
        return R.ok();
    }

}

