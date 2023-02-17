package com.ajie.mapper;

import com.ajie.pojo.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @Author: ajie
 * @Date: 2023/2/17
 * @Description:
 */
public interface IUserMapper {
    /**
     * 添加用户
     *
     * @param user
     */
    @Insert("insert into user values (#{id},#{username},#{password},#{birthday})")
    public void addUser(User user);

    /**
     * 更新用户
     *
     * @param user
     */
    @Update("update user set username = #{username} where id = #{id}}")
    public void updateUser(User user);

    /**
     * 根据 id 查询单个用户
     *
     * @param id
     * @return
     */
    @Select("select * from user where id = #{id}")
    public User selectById(Integer id);

    /**
     * 根据 id 删除用户
     *
     * @param id
     */
    @Delete("delete from user where id=#{id}")
    public void deleteById(Integer id);


    @Results({
            @Result(property = "id",column = "id"),
            @Result(property = "username",column = "username"),
            @Result(property = "password",column = "password"),
            @Result(property = "birthday",column = "birthday"),
            @Result(property = "orderList",column = "id",javaType = List.class,
                    many = @Many(select = "com.ajie.mapper.IOrderMapper.findById"))
    })
    @Select("select * from user")
    public List<User> findUserAndOrder();

    @Select("select * from user")
    @Results({
            @Result(property = "id",column = "id"),
            @Result(property = "username",column = "username"),
            @Result(property = "password",column = "password"),
            @Result(property = "birthday",column = "birthday"),
            @Result(property = "roleList" ,column = "id",javaType = List.class,
                    many = @Many(select = "com.ajie.mapper.IRoleMapper.findByUid"))
    })
    public List<User> findUserAndRole();
}
