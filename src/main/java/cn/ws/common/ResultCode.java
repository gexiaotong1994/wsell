package cn.ws.common;

public enum ResultCode {

    SUCCESS(0, "成功"),

    NEED_LOGIN(501, "需要登录"),
    USERNAME_NOT_FOUND(502, "用户名不存在"),
    PASSWORD_FAIL(504, "密码错误"),
    PHONE_REPEAT(505,"手机号已存在 请更换"),
    EMAIL_REPEAT(505,"邮箱已存在 请更换"),
    SYSTEM_ERROR(900, "系统错误");
    private int code;
    private String msg;

    ResultCode(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }


    public String getMsg() {
        return msg;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    

}

