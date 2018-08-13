package cn.ws.common;

public class ResultData {

    private boolean success;
    private Object data;
    private String error;
    private int code;

    private ResultData() {

    }

    public ResultData(boolean success) {
        if (success) {
            this.code = ResultCode.SUCCESS.getCode();
        } else {
            this.code = -1;
        }
        this.success = success;
    }

    public ResultData(Object data) {
        this.code = ResultCode.SUCCESS.getCode();
        this.data = data;
    }

    public ResultData(String msg) {
        this.code = -1;
        this.error = msg;
    }

    public ResultData(ResultCode resultCode) {
        this.code = resultCode.getCode();
        this.error = resultCode.getMsg();
    }

    public int getCode() {
        return code;
    }

    public String getError() {
        return error;
    }

    public Object getData() {
        return data;
    }

    public boolean isSuccess() {

        return code == ResultCode.SUCCESS.getCode();
    }

    public static ResultData success(Object data) {
        return new ResultData(data);
    }

    public static  ResultData error(String errorMsg){
         return new ResultData(errorMsg);
    }
    public static  ResultData code(ResultCode resultCode){
        return new ResultData(resultCode);
    }



}
