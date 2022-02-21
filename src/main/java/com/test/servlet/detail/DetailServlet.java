package com.test.servlet.detail;

import com.alibaba.fastjson.JSON;
import com.test.component.CommonResult;
import com.test.component.WebResponce;
import com.test.pojo.PostReply;
import com.test.service.impl.DetailServiceImpl;
import com.test.utils.TokenUtil;
import com.test.utils.WebUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @ClassName: DetailServlet
 * @Description: 展示帖子详情的请求接口
 * @author: Hilda   Hilda_quan@163.com
 * @date: 2022/2/21 12:14
 */
public class DetailServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 1. 获取完整的请求URL
        String servletPath = req.getRequestURI();
        System.out.println(servletPath);

        // 2. 获取请求头里面的用户token，并解析出里面的用户信息
//        String token = req.getHeader("token");
//        String username = null;
//        if (token != null) username = TokenUtil.decodeToken(token);

        // 3. 获取URL最后的pid
        int pathId = WebUtil.getPathId(servletPath);
        System.out.println(pathId);

        // 4. 将pid传给DetailService，获取该pid下的所有postReply，并封装为List
        DetailServiceImpl detailService = new DetailServiceImpl();
        CommonResult postReplyList = detailService.getRepliesByPid(pathId);  // 测试1

        // 5. JSON转换，然后响应回前端
        String result = JSON.toJSONString(postReplyList);
        resp.getWriter().write(result);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
