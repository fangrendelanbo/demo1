
package com.example.demo1.dao;


import com.example.demo1.model.Orders;
import org.apache.ibatis.annotations.*;


import java.util.List;

@Mapper
public interface OrdersDao {

    @Select("select * from orders where spid = #{spid}")
    public Orders getorderById(int spid);

    @Select("select * from orders where userName = #{userName}")
    public Orders getordersByUserName(String userName);

    @Insert("insert into orders (userName,spname,buytime,number)values(#{userName},#{spname},#{buytime},#{number})")
    public int addorders(Orders orders);

    @Select("select count(spid) from orders where spid=#{spid} " + "and spname=#{spname} ")
    public int handleLogin(Orders orders);

    @Select("select count(spid) from orders where spname=#{spname}")
    public int countOrderByordersName(String spname);

    @Select("select * from orders where userName=#{userName}")
    public List<Orders> getordersList(String userName);

    @Update("update orders set spname = #{spname},userName=#{userName},buytime=#{buytime},number=#{number} where spid=#{spid}")
    public int updateorders(Orders orders);


    @Delete("delete from orders where spid=#{spid}")
    public int deleteOrders(int spid);
}
