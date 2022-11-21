package com.example.demo1.dao;

import com.example.demo1.model.Orders;
import com.example.demo1.model.Sp;

import com.example.demo1.model.User;
import org.apache.ibatis.annotations.*;
import org.springframework.ui.Model;

import java.util.List;
@Mapper
public interface SpDao {
    @Select("select * from sp where id = #{id}")
    public Sp getspById(int id);
    @Select("select * from sp")
    public List<Sp> getSpList();

    @Insert("insert into orders (spname,number,userName,buytime)values(#{spname},#{number},#{userName},#{buytime})")
    public int insertbuy(Orders orders);
    @Delete("delete from sp where id=#{id}")
    public int DeleteSp(int id);

    @Update("update sp set name = #{name},bh=#{bh},sl=#{sl} where id=#{id}")
    public int updatesp(Sp sp);
}
