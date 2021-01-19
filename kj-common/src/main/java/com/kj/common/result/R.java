package com.kj.common.result;

import java.io.Serializable;

/**
 * 统一响应格式
 *
 * @author quan
 * @date 2020-11-24 15:27
 */

public class R implements Serializable {
    private static final long serialVersionUID = -6404609432267512025L;
    private static final R OK = new R(0);
    private static final R ERR = new R(500);
    private Integer code;
    private String msg;
    private Object data;


    private R(Integer code) {
        this.code=code;
    }
    private R(Integer code,String msg) {
        this.code=code;
        this.msg=msg;
    }

    public static R ok() {
        OK.setMsg("成功");
        return OK;
    }

    public static R ok(Object data) {
        R r = new R(0);
        r.setData(data);
        r.setMsg("成功");
        return r;
    }

    public static R err() {
        return ERR;
    }

    public static R err(String msg) {
        R r = new R(500);
        r.setMsg(msg);
        return r;
    }


    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
