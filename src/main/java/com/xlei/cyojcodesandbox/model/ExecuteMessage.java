package com.xlei.cyojcodesandbox.model;

import lombok.Data;

@Data
public class ExecuteMessage {
    /**
     * 退出
     */
    private Integer exitValue;
    /**
     * 正常输出
     */

    private String message;
    /**
     * 异常退出
     */
    private String errorMessage;
}
