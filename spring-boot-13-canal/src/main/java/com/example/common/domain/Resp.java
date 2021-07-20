package com.example.common.domain;

import lombok.Data;

@Data
public class Resp<T> {

    private Integer code;

    private String msg;

    private T data;

    public Resp(Integer code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public Resp() {
    }

    public Resp(T data) {
        this.data = data;
    }

    /**
     * @description: 操作成功
     * @author: bianqipeng
     * @date: 2021-02-02 16:22:59
     * @return: Resp<T>
     */
    public static <T> Resp<T> ok() {
        Resp<T> resp = new Resp<T>();
        resp.setCode(0);
        resp.setMsg("success");
        return resp;
    }

    /**
     * @description: 操作成功
     * @author: bianqipeng
     * @date: 2021-02-02 16:23:09
     * @param: data
     * @return: Resp<T>
     */
    public static <T> Resp<T> ok(T data) {
        Resp<T> resp = new Resp<T>(data);
        resp.setCode(0);
        resp.setMsg("success");
        return resp;
    }

    /**
     * @description: 操作失败
     * @author: bianqipeng
     * @date: 2021-02-02 16:23:19
     * @param: msg
     * @return: Resp<T>
     */
    public static <T> Resp<T> fail(String msg) {
        Resp<T> resp = new Resp<T>();
        resp.setCode(1);
        resp.setMsg(msg);
        return resp;
    }

    public Resp<T> msg(String msg) {
        this.setMsg(msg);
        return this;
    }

    public Resp<T> code(Integer code) {
        this.setCode(code);
        return this;
    }
}
