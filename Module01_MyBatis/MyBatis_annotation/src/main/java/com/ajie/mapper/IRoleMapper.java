package com.ajie.mapper;

import com.ajie.pojo.Role;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @Author: ajie
 * @Date: 2023/2/17
 * @Description:
 */
public interface IRoleMapper {

    @Select("select * from sys_user_role ur, sys_role r where r.id = ur.roleid and ur.userid = #{uid}")
    public List<Role> findByUid(Integer uid);
}
