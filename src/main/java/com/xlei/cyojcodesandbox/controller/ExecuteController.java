package com.xlei.cyojcodesandbox.controller;
import com.xlei.cyojcodesandbox.template.JavaNativeCodeSandbox;
import com.xlei.cyojcodesandbox.model.ExecuteCodeRequest;
import com.xlei.cyojcodesandbox.model.ExecuteCodeResponse;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static com.xlei.cyojcodesandbox.constants.AuthRequest.AUTH_REQUEST_HEADER;
import static com.xlei.cyojcodesandbox.constants.AuthRequest.AUTH_REQUEST_SECRET;

/**
 * 所有判题请求都需要先判断秘钥是否正确
 */
@RestController
@RequestMapping("/")
public class ExecuteController {

    @Resource
    private JavaNativeCodeSandbox javaNativeCodeSandbox;

    @GetMapping("/health")
    public String healthCheck() {
        return "ok";
    }

    /**
     * 执行代码
     *
     * @param executeCodeRequest
     * @return
     */
    @PostMapping("/executeCode")
    ExecuteCodeResponse executeCodeResponse(@RequestBody ExecuteCodeRequest executeCodeRequest, HttpServletRequest request,

                                            HttpServletResponse response) {
        String authHeader = request.getHeader(AUTH_REQUEST_HEADER);
        //基本认证
        if (!AUTH_REQUEST_SECRET.equals(authHeader)) {
            //秘钥不匹配则禁止访问
            response.setStatus(403);
            return null;
        }
        if (executeCodeRequest == null) {
            throw new RuntimeException("请求参数为空");
        }
        //正常执行代码
        return javaNativeCodeSandbox.executeCode(executeCodeRequest);
    }

}

