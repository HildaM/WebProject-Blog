package com.test.servlet.post;

import com.alibaba.fastjson.JSON;
import com.test.component.CommonResult;
import com.test.service.impl.PostServiceImpl;
import com.test.utils.JSONUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

/**
 * @ClassName: PostPublishServlet
 * @Description: 发布帖子
 * @author: Hilda   Hilda_quan@163.com
 * @date: 2022/2/19 15:04
 */
public class PostPublishServlet extends HttpServlet {
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

        // 2. 封装参数
        Map<String, String> params = (Map<String, String>) JSON.parse(requestJSONData);

        // 3. 调用PostServie服务
        PostServiceImpl postService = new PostServiceImpl();
        CommonResult commonResult = postService.publishPost(params);
        String result = JSON.toJSONString(commonResult);
        resp.getWriter().write(result);
    }
}
