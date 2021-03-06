package com.test.servlet.user;

import com.alibaba.fastjson.JSON;
import com.test.component.CommonResult;
import com.test.component.WebResponce;
import com.test.service.impl.UserServiceImpl;
import com.test.utils.JSONUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

/**
 * @ClassName: SignUpServlet
 * @Description: 注册Servlet
 * @author: Hilda   Hilda_quan@163.com
 * @date: 2022/2/13 9:31
 */

public class SignUpServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 设置请求编码
        req.setCharacterEncoding("UTF-8");
        // 设置响应编码格式
        resp.setContentType("application/json; charset=utf-8");

        // 1. json数据预处理
        String requestJSONData = JSONUtil.getRequestJSONData(req);

        // 2. 封装参数
        Map<String, String> params = (Map<String, String>) JSON.parse(requestJSONData);

        // 3. 调用UserService注册服务
        UserServiceImpl userService = new UserServiceImpl();

        CommonResult commonResult = userService.SignUpService(params);
        String result = JSON.toJSONString(commonResult);
        resp.getWriter().write(result);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }
}
