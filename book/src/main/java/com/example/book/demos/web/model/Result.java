package com.example.book.demos.web.model;

import com.example.book.demos.web.enums.ResultCode;
import lombok.Data;

@Data
public class Result {
    /**
     * 状态码.表示后端是否正常相应了
     */
    private ResultCode code; // 0 成功  -1 失败  -2 未登录
    /**
     * 错误信息
      */
    private String errMsg;

    /**
     * 数据
     */
    private Object data;

    public static Result success(Object data) {
        Result result = new Result();
        result.setCode(ResultCode.SUCCESS);
        result.setErrMsg("");
        result.setData(data);
        return result;
    }

    public static Result fail(String errMsg) {
        Result result = new Result();
        result.setCode(ResultCode.FAIL);
        result.setErrMsg(errMsg);
        result.setData(null);
        return result;
    }

    public static Result fail(String errMsg, Object data) {
        Result result = new Result();
        result.setCode(ResultCode.FAIL);
        result.setErrMsg(errMsg);
        result.setData(data);
        return result;
    }

    public static Result unlogin() {
        Result result = new Result();
        result.setCode(ResultCode.UNLOGIN);
        result.setErrMsg("用户未登录");
        result.setData(null);
        return result;
    }
}
