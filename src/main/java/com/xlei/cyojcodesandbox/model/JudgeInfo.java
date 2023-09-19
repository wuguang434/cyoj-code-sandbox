package com.xlei.cyojcodesandbox.model;

import lombok.Data;

/**
 * 判题信息
 */
@Data
public class JudgeInfo {
    /**
     * 程序执行信息
     */
    private String message;
    /**
     * 消耗的内存
     */
    private Long memory;
    /**
     * 消耗的时间(Kb)
     */
    private Long time;
}
