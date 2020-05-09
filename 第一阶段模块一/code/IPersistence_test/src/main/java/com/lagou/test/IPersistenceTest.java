package com.lagou.test;

import com.lagou.dao.IUserDao;
import com.lagou.dao.IUserRoleDao;
import com.lagou.dao.OrdersDao;
import com.lagou.io.Resources;
import com.lagou.pojo.Orders;
import com.lagou.pojo.User;
import com.lagou.pojo.UserRole;
import com.lagou.sqlSession.SqlSession;
import com.lagou.sqlSession.SqlSessionFactory;
import com.lagou.sqlSession.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

public class IPersistenceTest {

    @Test
    public void test() throws Exception {
        InputStream resourceAsSteam = Resources.getResourceAsSteam("sqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsSteam);
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //调用
        User user = new User();
        user.setId(1);
        user.setUsername("张三");
      /*  User user2 = sqlSession.selectOne("user.selectOne", user);

        System.out.println(user2);*/

       /* List<User> users = sqlSession.selectList("user.selectList");
        for (User user1 : users) {
            System.out.println(user1);
        }*/

        IUserDao userDao = sqlSession.getMapper(IUserDao.class);

        List<User> all = userDao.findAll();
        for (User user1 : all) {
            System.out.println(user1);
        }


    }
    @Test
    public void insertTest() throws Exception {
        InputStream resourceAsSteam = Resources.getResourceAsSteam("sqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsSteam);
        SqlSession sqlSession = sqlSessionFactory.openSession();
       // System.out.println("增加之前user表中内容："+user);
        //调用
        User user = new User();
        user.setId(4);
        user.setUsername("王建新");
        IUserDao userDao = sqlSession.getMapper(IUserDao.class);
        int result = userDao.insertUser(user);
        if(result ==1){
            System.out.println("增加user表中内容："+user);
        }
        System.out.println("user表中内容：");
        List<User> all = userDao.findAll();
        for (User user1 : all) {
            System.out.println(user1);
        }
    }
    @Test
    public void deleteTest() throws Exception {
        InputStream resourceAsSteam = Resources.getResourceAsSteam("sqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsSteam);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        int userid =2;
        /*IUserRoleDao userRoleDao = sqlSession.getMapper(IUserRoleDao.class);
        UserRole userRole=new UserRole();
        userRole.setUserid(userid);
        List<UserRole> urList  = userRoleDao.findByUserid(userRole);
        if(urList!=null && urList.size()>0){
            userRoleDao.delete(userRole);
        }
        OrdersDao ordersDao = sqlSession.getMapper(OrdersDao.class);
        Orders orders = new Orders();
        orders.setUid(userid);
        List<Orders> orList = ordersDao.findByUid(orders);
        if(orList!=null && orList.size()>0){
            ordersDao.delete(orders);
        }*/
        //调用
        User user = new User();
        user.setId(userid);
        IUserDao userDao = sqlSession.getMapper(IUserDao.class);
        int result = userDao.delete(user);
        if(result==1) {
            System.out.println("删除条数：" + result);
        }
        System.out.println("user表中内容：");
        List<User> all = userDao.findAll();
        for (User user1 : all) {
            System.out.println(user1);
        }
    }
    @Test
    public void updateTest() throws Exception {
        InputStream resourceAsSteam = Resources.getResourceAsSteam("sqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsSteam);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //调用
        User user = new User();
        user.setId(4);
        user.setUsername("张明");
        IUserDao userDao = sqlSession.getMapper(IUserDao.class);
        int result = userDao.update(user);
        if(result==1) {
            System.out.println("更新成功条数：" + result);
        }
        System.out.println("user表中内容：");
        List<User> all = userDao.findAll();
        for (User user1 : all) {
            System.out.println(user1);
        }
    }
}
