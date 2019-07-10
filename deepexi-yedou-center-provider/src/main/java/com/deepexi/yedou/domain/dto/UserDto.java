package com.deepexi.yedou.domain.dto;

import com.deepexi.yedou.domain.eo.User;
import java.util.Collection;
import java.util.List;

/**
* @desc 用户管理模块
* @author 
*/
public class UserDto extends User{

public UserDto(){};

public UserDto(User eo) {
    this.setId(eo.getId());
    this.setCreatedBy(eo.getCreatedBy());
    this.setCreatedAt(eo.getCreatedAt());
    this.setUpdatedBy(eo.getUpdatedBy());
    this.setUpdatedAt(eo.getUpdatedAt());
    this.setName(eo.getName());
}
}

