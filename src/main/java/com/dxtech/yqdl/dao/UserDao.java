package com.dxtech.yqdl.dao;

import com.dxtech.yqdl.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserDao {

    @Select("select * from user where username=#{username} and password =#{password}")
    User getUserByName(String username, String password);

}
