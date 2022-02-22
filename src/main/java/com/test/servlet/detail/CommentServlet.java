package com.test.servlet.detail;

import com.alibaba.fastjson.JSON;
import com.test.component.CommonResult;
import com.test.component.WebResponce;
import com.test.service.impl.DetailServiceImpl;
import com.test.utils.JSONUtil;
import com.test.utils.TokenUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

/**
 * @ClassName: CommentServlet
 * @Description: 回帖功能实现
 * @author: Hilda   Hilda_quan@163.com
 * @date: 2022/2/22 18:37
 */
public class CommentServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 设置请求编码
        req.setCharacterEncoding("UTF-8");
        // 设置响应编码格式
        resp.setContentType("application/json; charset=utf-8");

        // 1. json数据预处理
        String requestJSONData = JSONUtil.getRequestJSONData(req);

        // 2. 获取请求头里面的用户token，并解析出里面的用户信息
        String token = req.getHeader("token");
        String username = null;
        if (token != null) username = TokenUtil.decodeToken(token);

        // 3. 封装参数
        Map<String, String> params = (Map<String, String>) JSON.parse(requestJSONData);
        params.put("username", username);

        // 4. 调用DetailService的服务
        DetailServiceImpl detailService = new DetailServiceImpl();
        CommonResult commonResult = detailService.addComment(params);

        // 5. 返回结果
        String result = JSON.toJSONString(commonResult);
        resp.getWriter().write(result);
    }
}
