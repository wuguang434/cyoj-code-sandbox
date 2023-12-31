package com.xlei.cyojcodesandbox.codesandbox;
import com.xlei.cyojcodesandbox.model.ExecuteCodeRequest;
import com.xlei.cyojcodesandbox.model.ExecuteCodeResponse;

/**
 * 代码沙箱接口定义
 */
public interface CodeSandbox {
    /**
     * 执行代码
     * @param executeCodeRequest
     * @return
     */
    ExecuteCodeResponse executeCode(ExecuteCodeRequest executeCodeRequest);
}
