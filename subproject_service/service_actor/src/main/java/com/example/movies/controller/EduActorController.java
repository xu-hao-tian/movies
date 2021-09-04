package com.example.movies.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.movies.entity.EduActor;
import com.example.movies.query.ActorQuery;
import com.example.movies.service.EduActorService;
import com.example.util.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 演员 前端控制器
 * </p>
 *
 * @author 许昊天
 * @since 2021-09-02
 */
@RestController
@RequestMapping("/movies/edu-actor")
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
    public R saveActor(EduActor actor){
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
    @GetMapping("{page}/{limit}")
    public R listPage(@ApiParam(name = "page", value = "当前页码", required = true)
                      @PathVariable long page,
                      @ApiParam(name = "limit", value = "每页显示的记录数", required = true)
                      @PathVariable long limit,
                      @ApiParam(name = "actorQuery",value = "查询对象",required = false) ActorQuery actorQuery){
        // 添加分页参数
        Page<EduActor> actorPage = new Page<>(page, limit);
        // actorService.getActorList(actorPage);
        // 添加查询条件
        actorService.pageQuery(actorPage, actorQuery);
        List<EduActor> records = actorPage.getRecords();
        long total = actorPage.getTotal();
        //返回
        return R.ok().data("total", total).data("rows", records);
    }
}

