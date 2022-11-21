package com.example.demo1.dao;

import com.example.demo1.model.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserDao {


    @Select("select * from user where id = #{id}")
    public User getUserById(int id);


    @Insert("insert into user (userName,password)values(#{userName},#{password})")
    public int addUser(User user);


    @Select("select count(id) from user where userName=#{userName} " +
            "and password=#{password} ")
    public int handleLogin(User user);


    @Select("select count(id) from user where userName=#{userName}")
    public int countUserByUserName(String userName);

    @Select("select * from user")
    public List<User> getUserList();

    @Delete("delete from user where id=#{id}")
    public int deleteUser(int id);

    @Update("update user set userName = #{userName},password=#{password} where id=#{id}")
    public int updateUser(User user);



}
