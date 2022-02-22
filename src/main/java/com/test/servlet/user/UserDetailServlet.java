package com.test.servlet.user;

import com.alibaba.fastjson.JSON;
import com.test.component.CommonResult;
import com.test.service.impl.UserServiceImpl;
import com.test.utils.JSONUtil;
import com.test.utils.TokenUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @ClassName: UserDetailServlet
 * @Description: 用户详情
 * @author: Hilda   Hilda_quan@163.com
 * @date: 2022/2/22 20:20
 */
public class UserDetailServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 设置请求编码
        req.setCharacterEncoding("UTF-8");
        // 设置响应编码格式
        resp.setContentType("application/json; charset=utf-8");

        // 1. 获取请求头token
        String token = req.getHeader("token");

        // 2. 解析用户名
        String username = TokenUtil.decodeToken(token);

        // 3. 调用UserService的方法
        UserServiceImpl userService = new UserServiceImpl();
        CommonResult userInfo = userService.getUserInfo(username);

        // 4. 返回结果
        String result = JSON.toJSONString(userInfo);
        resp.getWriter().write(result);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
