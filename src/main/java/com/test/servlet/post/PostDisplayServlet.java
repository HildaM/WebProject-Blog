package com.test.servlet.post;

import com.alibaba.fastjson.JSON;
import com.test.component.CommonResult;
import com.test.component.WebResponce;
import com.test.pojo.Post;
import com.test.service.PostService;
import com.test.service.impl.PostServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @ClassName: PostDisplayServlet
 * @Description: 展示帖子
 * @author: Hilda   Hilda_quan@163.com
 * @date: 2022/2/19 8:45
 */
public class PostDisplayServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 设置请求编码
        req.setCharacterEncoding("UTF-8");
        // 设置响应编码格式
        resp.setContentType("application/json; charset=utf-8");

        /**
         * 将(postImg, postId, postTitle, content, date, commentNumber)
         * 封装成post类，并且将所有post取出，放到一个list中，再将其封装到统一返回类中
         **/

        // 1. 调用PostService的服务，获取所有帖子
        PostService postService = new PostServiceImpl();
        List<Post> postList =  postService.getAllPosts();

        // 2. 将其封装到CommonResult信息类中
        CommonResult commonResult = new CommonResult(WebResponce.SUCCESS.getCode(), postList);

        // 3. 返回到前端页面中
        String result = JSON.toJSONString(commonResult);
        resp.getWriter().write(result);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
