package com.lagou.dao;

import com.lagou.pojo.Orders;
import com.lagou.pojo.UserRole;

import java.util.List;

public interface OrdersDao {
    public List<Orders> findByUid(Orders orders);

    public  int delete(Orders orders);


}
