package cn.ws.api.dao;

import cn.ws.api.model.User;
import org.apache.ibatis.annotations.Param;

public interface UserDao {


    /**
     * 通过用户名查询用户
     * @param username
     * @return
     */
    User queryUserByUsername(@Param("username") String username);


    /**
     * 插入一条新记录
     *
     * @param user
     * @return
     */
    int insertUser(@Param("user") User user);











    


}
