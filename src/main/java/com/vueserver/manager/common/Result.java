package com.vueserver.manager.common;

/**
 * @description: 返回信息对象
 * @author: hetao
 * @create: 2019-12-10 20:16
 **/
public class Result {

    private Boolean flag;//返回类型flag，方便布尔判断
    private Integer code;//返回状态码
    private String message;//返回异常描述信息
    private Object data;//相关需要返回的数据
    private Long count;//返回数据条数

    public Result(){
    }

    public Result(boolean flag, Integer code, String message){
        super();
        this.flag = flag;
        this.code = code;
        this.message = message;
    }

    public Result(boolean flag, Integer code, String message, Object data) {
        super();
        this.flag = flag;
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public Result(boolean flag, Integer code, String message, Object data, Long count) {
        super();
        this.flag = flag;
        this.code = code;
        this.message = message;
        this.data = data;
        this.count = count;
    }

    public boolean isFlag() {
        return flag;
    }
    public void setFlag(boolean flag) {
        this.flag = flag;
    }
    public Integer getCode() {
        return code;
    }
    public void setCode(Integer code) {
        this.code = code;
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
    public Object getData() {
        return data;
    }
    public void setData(Object data) {
        this.data = data;
    }
    public Long getCount() {
        return count;
    }
    public void setCount(Long count) {
        this.count = count;
    }

    /**
     * 返回成功消息
     * @return Result
     */
    public static Result OK() {
        return new Result(true, StatusCode.OK, "成功");
    }

    /**
     * 返回成功消息
     * @return Result
     */
    public static Result OK(Object data) {
        return new Result(true, StatusCode.OK, "成功", data);
    }

    /**
     * 返回成功消息
     * @return Result
     */
    public static Result OK(String message, Object data) {
        return new Result(true, StatusCode.OK, "成功", data);
    }

    /**
     * 返回成功消息
     * @return Result
     */
    public static Result OK(Object data, Long count) {
        return new Result(true, StatusCode.OK, "成功", data, count);
    }

    /**
     * 返回失败消息
     * @return Result
     */
    public static Result ERROR() {
        return new Result(false, StatusCode.ERROR, "失败");
    }

    /**
     * 返回失败消息
     * @return Result
     */
    public static Result ERROR(String message) {
        return new Result(false, StatusCode.ERROR, message);
    }

    /**
     * 返回失败消息
     * @return Result
     */
    public static Result ERROR(Integer code, String message) {
        return new Result(false, code, message);
    }

    /**
     * 返回登录失败的消息：用户名或密码错误
     * @return Result
     */
    public static Result LOGIN_ERROR() {
        return new Result(false, StatusCode.LOGIN_ERROR, "用户名或密码错误");
    }

    /**
     * 返回权限不足
     * @return Result
     */
    public static Result ACCESS_ERROR() {
        return new Result(false, StatusCode.ACCESS_ERROR, "权限不足");
    }

    /**
     * 返回远程调用失败
     * @return Result
     */
    public static Result REMOTE_ERROR() {
        return new Result(false, StatusCode.REMOTE_ERROR, "远程调用失败");
    }

    /**
     * 返回重复操作
     * @return Result
     */
    public static Result REPEAT_ERROR() {
        return new Result(false, StatusCode.REPEAT_ERROR, "重复操作");
    }



}
