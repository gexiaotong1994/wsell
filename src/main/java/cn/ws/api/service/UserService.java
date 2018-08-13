package cn.ws.api.service;

import cn.ws.api.model.User;
import cn.ws.common.ResultData;

public interface UserService {


    /**
     * 用户登录接口
     * @param username
     * @param password
     * @return
     */
    User login(String username, String password);


    /**
     * 用户注册
     * @param user
     * @return
     */
    boolean register(User user);


}
