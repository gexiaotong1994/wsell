package cn.ws.exception;

import cn.ws.common.ResultCode;

import javax.xml.ws.Service;

public class ServiceException extends RuntimeException {

    ResultCode code;

    public ServiceException() {

    }

    public ServiceException(ResultCode code) {
        this.code = code;
    }

    public ResultCode getCode() {
        return code;
    }
}
