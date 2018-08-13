package cn.ws.api.service.impl;

import cn.ws.api.dao.UserDao;
import cn.ws.api.model.User;
import cn.ws.api.service.UserService;
import cn.ws.common.Const;
import cn.ws.common.ResultCode;
import cn.ws.common.ResultData;
import cn.ws.exception.ServiceException;
import cn.ws.utils.MD5Utils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {


    @Autowired
    UserDao userDao;

    @Override
    public User login(String username, String password) {
        User user = userDao.queryUserByUsername(username);
        //TODO 抛出异常 用户名不存在
        if (user == null)
            throw new ServiceException(ResultCode.USERNAME_NOT_FOUND);
        String pass = MD5Utils.MD5EncodeUtf8(password);
        if (!StringUtils.equals(pass, user.getPassword()))
            throw new ServiceException(ResultCode.PASSWORD_FAIL);
        user.setPassword("*");
        return user;
    }

    @Override
    public boolean register(User user) {
        if (this.checkValue(Const.VailType.PHONE, user.getPhone()))
            throw new ServiceException(ResultCode.PHONE_REPEAT);
        if (this.checkValue(Const.VailType.PHONE, user.getEmail()))
            throw new ServiceException(ResultCode.EMAIL_REPEAT);
        //对密码进行加密
        user.setPassword(MD5Utils.MD5EncodeUtf8(user.getPassword()));
        return userDao.insertUser(user) == 1;
    }


    public boolean checkValue(String type, String value) {

        return true;
    }


}
