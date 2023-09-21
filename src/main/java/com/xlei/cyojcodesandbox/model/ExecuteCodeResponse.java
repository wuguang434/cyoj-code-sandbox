package com.xlei.cyojcodesandbox.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
/**
 * 判题后返回的实体类
 */
public class ExecuteCodeResponse {
    private List<String> outputList;
    /**
     * 接口信息(例如执行超时)
     */
    private String message;

    /**
     * 执行状态
     */
    private Integer status;
    /**
     * 判题信息
     */
    private JudgeInfo judgeInfo;
}
