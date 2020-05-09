package com.lagou.dao;

import com.lagou.pojo.UserRole;

import java.util.List;

public interface IUserRoleDao {
    public List<UserRole> findByUserid(UserRole userRole);

    public  int delete(UserRole userRole);


}
