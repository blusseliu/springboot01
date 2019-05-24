package com.zih.springboot.service;

import com.zih.springboot.entity.User;

import java.util.List;

public interface userService {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    List<User> SelectAll();
}
