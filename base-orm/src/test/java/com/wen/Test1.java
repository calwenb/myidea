package com.wen;

import com.wen.dao.BaseDao;
import com.wen.dao.UserDao;
import com.wen.pojo.User;
import com.wen.util.JDBCUtil;
import com.wen.wrapper.SetWrapper;
import com.wen.wrapper.WhereWrapper;
import org.testng.annotations.Test;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

public class Test1 {
    UserDao userDao = new UserDao();
    Connection conn = JDBCUtil.getConn();

    public Test1() throws SQLException, ClassNotFoundException {
    }

    @Test
    public void t1() throws Exception {
        for (int i = 0; i < 10; i++) {
            User user = new User(-1, "文" + i, "123");
            System.out.println(UserDao.insertTarget(conn, user));
        }

    }

    @Test
    public void t2() throws Exception {
        WhereWrapper wrapper = new WhereWrapper();
        wrapper.add("username", "文1");
        System.out.println(BaseDao.deleteTarget(conn, User.class, wrapper));
    }

    @Test
    public void t3() throws Exception {
        ArrayList<User> users = UserDao.selectTargets(conn, User.class);
        System.out.println(users);
        System.out.println("\n==================\n");

        WhereWrapper wrapper = new WhereWrapper();
        wrapper.add("username", "文2");


        ArrayList<User> users1 = UserDao.selectTargets(conn, User.class, wrapper);
        System.out.println(users1);
        System.out.println("\n==================\n");
    }

    @Test
    public void t4() throws Exception {
        User user = UserDao.selectTarget(conn, User.class);
        System.out.println(user);
        System.out.println("==================\n");

        WhereWrapper whereWrapper = new WhereWrapper();
        whereWrapper.add("username", "文0");
        whereWrapper.or("username", "long");
        user = UserDao.selectTarget(conn, User.class, whereWrapper);
        System.out.println(user);
    }

    @Test
    public void t5() throws Exception {
        WhereWrapper whereWrapper = new WhereWrapper();
        whereWrapper.add("username", "wen");
        SetWrapper setWrapper = new SetWrapper();
        setWrapper.add("password", "6661");
        System.out.println(UserDao.updateTarget(conn, User.class, setWrapper, whereWrapper));
    }

    @Test
    public void t6() throws Exception {
        User user = new User(115, "文" + 0, "111");
        System.out.println(UserDao.replaceTarget(conn, user));
    }


}
