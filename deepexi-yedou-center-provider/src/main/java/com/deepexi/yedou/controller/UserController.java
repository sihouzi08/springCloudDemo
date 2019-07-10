package com.deepexi.yedou.controller;

import com.deepexi.util.config.Payload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import com.deepexi.yedou.service.UserService;
import com.deepexi.yedou.domain.eo.User;
import org.springframework.web.bind.annotation.*;
//import io.swagger.annotations.*;


//@Api(value = "/user", description = "$desc")
@RestController
@RequestMapping("/api/v1/users")
public class  UserController {

    @Autowired
    private UserService userService;


    @GetMapping
    //@ApiOperation(value = "分页查询", notes = "分页请求")
    public  Payload findPage(User eo,
                             @RequestParam(value = "page", defaultValue = "0") Integer page,
                             @RequestParam(value = "size", defaultValue = "10") Integer size) {
        return new Payload(userService.findPage(eo, page, size));
    }

    @GetMapping("/list")
    //@ApiOperation(value = "树形查询", notes = "查询全部请求")
    public Payload findAll(User eo) {
        return new Payload(userService.findAll(eo));
    }

    @GetMapping("/{id}")
    public Payload detail(@PathVariable(value = "id", required = true) Integer  pk) {
        return new Payload(userService.detail(pk));
    }


    @PutMapping("/{id}")
    @Transactional
//@ApiOperation(value = "根据id修改", notes = "根据id修改User")
    public Payload update(@PathVariable(value = "id", required = true) Integer  pk, @RequestBody User eo) {
     eo.setId(pk);
     return new Payload(userService.update(pk, eo));
    }

    @PostMapping
    //@ApiOperation(value = "创建User", notes = "创建User")
    public Payload create(@RequestBody User eo) {
        return new Payload(userService.create(eo));
    }

    @DeleteMapping("/{id}")
    @Transactional
//@ApiOperation(value = "根据id删除User", notes = "根据id删除User")
    public Payload delete(@PathVariable(value = "id", required = true) Integer  pk) {
        return new Payload(userService.delete(pk));
    }

    @DeleteMapping
    @Transactional
    //@ApiOperation(value = "根据id批量删除User", notes = "根据id批量删除User")
    public Payload delete(@RequestParam(required = true) Integer [] ids) {
        return new Payload(userService.delete(ids));
    }

}