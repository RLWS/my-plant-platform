package com.rlws.plant.commons.dto;

import java.io.Serializable;

public class BaseResult implements Serializable {
    public static final int STATUS_SUCCESS = 200;
    public static final int STATUS_FAIL = 500;

    private int status;
    private String message;
    private Object data;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
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

    /**
     * 无data返回
     * @param status    状态码
     * @param message   返回信息
     * @return
     */
    public static BaseResult createResult(int status, String message) {
        BaseResult baseResult = new BaseResult();
        baseResult.setStatus(status);
        baseResult.setMessage(message);
        return baseResult;
    }

    /**
     * 有data返回
     * @param status    状态码
     * @param message   返回信息
     * @param data      返回数据
     * @return
     */
    public static BaseResult createResult(int status, String message,Object data) {
        BaseResult baseResult = new BaseResult();
        baseResult.setStatus(status);
        baseResult.setMessage(message);
        baseResult.setData(data);
        return baseResult;
    }

    /**
     * 成功(默认返回信息)
     * @return
     */
    public static BaseResult success() {
        return BaseResult.createResult(STATUS_SUCCESS, "成功");
    }

    /**
     * 成功
     * @param message   返回信息
     * @return
     */
    public static BaseResult success(String message) {
        return BaseResult.createResult(STATUS_SUCCESS, message);
    }

    /**
     * 失败(默认返回信息)
     * @return
     */
    public static BaseResult fail() {
        return BaseResult.createResult(STATUS_FAIL, "失败");
    }

    /**
     * 失败
     * @param message   返回信息
     * @return
     */
    public static BaseResult fail(String message) {
        return BaseResult.createResult(STATUS_FAIL, message);
    }

    /**
     * 失败
     * @param status    状态码
     * @param message   返回信息
     * @return
     */
    public static BaseResult fail(int status,String message) {
        return BaseResult.createResult(status, message);
    }

    /**
     * 成功
     * @param message   返回信息
     * @param data  返回数据
     * @return
     */
    public static BaseResult success(String message,Object data) {
        return BaseResult.createResult(STATUS_SUCCESS, message,data);
    }

    /**
     * 成功
     * @param data  返回数据
     * @return
     */
    public static BaseResult success(Object data) {
        return BaseResult.createResult(STATUS_SUCCESS, "成功",data);
    }
}
