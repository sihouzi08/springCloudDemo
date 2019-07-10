package com.deepexi.yedou.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.deepexi.yedou.domain.eo.User;
import com.deepexi.yedou.service.UserService;
import com.deepexi.yedou.mapper.UserMapper;
import java.util.Arrays;import java.util.List;
import com.deepexi.util.pageHelper.PageBean;
import com.github.pagehelper.PageHelper;
import com.deepexi.util.BeanPowerHelper;
import java.util.Arrays;

@Service
public class UserServiceImpl implements UserService {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private UserMapper userMapper;

    @Override
    public PageBean<User> findPage(User eo, Integer page, Integer size) {
        PageHelper.startPage(page, size);
        List<User> pages =  userMapper.findList(eo);
        return new PageBean<User>(pages);
    }

    @Override
    public List<User> findAll(User eo) {
        List<User> list = userMapper.findList(eo);
        return list;
    }
    @Override
    public User detail(Integer  pk) {
        User eo = userMapper.selectById(pk);
        return eo;
    }

    @Override
    public Boolean update(Integer  id,User eo) {
        User old = userMapper.selectById(id);
        BeanPowerHelper.mapCompleteOverrider(eo,old); //部分更新
        int result = userMapper.updateById(old);
        if (result > 0) {
            return true;
        }
        return false;
    }

    @Override
    public Boolean create(User eo) {
        int result = userMapper.insert(eo);
        if (result > 0) {
            return true;
        }
        return false;
    }

    @Override
    public Boolean delete(Integer  pk) {
        int result = userMapper.deleteBatchIds(Arrays.asList(pk));
        if (result > 0) {
            return true;
        }
        return false;
    }

    @Override
    public Boolean delete(Integer ...pks) {
        int result = userMapper.deleteBatchIds(Arrays.asList(pks));
        if (result > 0) {
            return true;
        }
        return false;
    }

}