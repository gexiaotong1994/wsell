package cn.ws.exception.advice;

import cn.ws.common.ResultCode;
import cn.ws.common.ResultData;
import cn.ws.exception.ServiceException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@ControllerAdvice
public class ExceptionAdviceHandler {


    @ExceptionHandler({ServiceException.class})
    @ResponseBody
    public ResultData hanler(ServiceException e) {


        return ResultData.code(e.getCode());
    }

}
