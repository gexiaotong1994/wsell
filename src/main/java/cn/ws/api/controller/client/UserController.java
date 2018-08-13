package cn.ws.api.controller.client;

import cn.ws.api.model.User;
import cn.ws.api.service.UserService;
import cn.ws.common.ResultData;
import cn.ws.utils.RequestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/api/mall/user")
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping("/login.do")
    public ResultData login(HttpServletRequest request, HttpServletResponse response) {
        String username = RequestUtils.get(request, "username");
        String password = RequestUtils.get(request, "password");
        User loginUser = userService.login(username, password);
        return ResultData.success(username);
    }


    @RequestMapping("/register.do")
    public ResultData register(HttpServletRequest request) {
        String username = RequestUtils.get(request, "username");
        String password = RequestUtils.get(request, "password");
        String phone = RequestUtils.get(request, "phone");
        String email = RequestUtils.get(request, "email");
        User user = new User();
        user.setPassword(password);
        user.setPhone(phone);
        user.setEmail(email);
        user.setUsername(username);

        return ResultData.success("注册成功");

    }


    @RequestMapping("/admin/login.do")
    public ResultData adminLogin(HttpServletRequest request, HttpServletResponse response) {
        ResultData data = this.login(request, response);
        if (!data.isSuccess())
            return data;
        User loginUser = (User) data.getData();
        if (loginUser.getAdmin() != 0)
            return ResultData.error("该账户没有管理员权限");

        return null;


    }


}
