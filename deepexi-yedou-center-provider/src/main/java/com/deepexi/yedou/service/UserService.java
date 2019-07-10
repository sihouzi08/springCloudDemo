package com.deepexi.yedou.service;

import com.deepexi.yedou.domain.eo.User;
import com.deepexi.yedou.domain.dto.UserDto;
import com.deepexi.util.pageHelper.PageBean;
import java.util.List;

/**
 * 用户管理模块
 */
public interface UserService {

    /**
    * 分页获取列表
    * @param eo
    * @param page
    * @param size
    * @return
    */
    PageBean<User> findPage(User eo, Integer page, Integer size);
    /**
    * 获取列表
    * @return
    */
    List<User> findAll(User eo);

    /**
      获取详情
    * @return
    */
    User detail(Integer pk);

    /**
     更新eo
    * @param eo
    * @return
    */
    Boolean update(Integer id, User eo);

    /**
    * 创建eo
    * @param eo
    * @return
    */
    Boolean create(User eo);

    /**
     * 单个删除
    * @return
    */
    Boolean delete(Integer pk);

    /**
     批量删除
    * @return
    */
    Boolean delete(Integer... pk);
}