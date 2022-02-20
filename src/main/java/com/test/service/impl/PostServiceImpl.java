package com.test.service.impl;

import com.test.component.CommonResult;
import com.test.component.WebResponce;
import com.test.dao.PostMapper;
import com.test.dao.UserMapper;
import com.test.pojo.Post;
import com.test.pojo.User;
import com.test.service.PostService;
import com.test.utils.MybatisUtil;
import com.test.utils.TokenUtil;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName: PostServiceImpl
 * @Description: 帖子服务实现类
 * @author: Hilda   Hilda_quan@163.com
 * @date: 2022/2/19 8:59
 */
public class PostServiceImpl implements PostService {

    // 获取所有帖子
    @Override
    public List<Post> getAllPosts() {
        // 数据库连接
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        PostMapper postMapper = sqlSession.getMapper(PostMapper.class);

        // 1. 获取所有帖子
        List<Post> allPosts = postMapper.getAllPosts();

        return allPosts;
    }


    // 发布帖子
    @Override
    public CommonResult publishPost(Map<String, String> params) {
        // 数据库连接
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        PostMapper postMapper = sqlSession.getMapper(PostMapper.class);
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        // 1. 将数据拆包
        String pname = params.get("pname");
        String postImg = params.get("postImg");
        String pcontent = params.get("content");
//        Integer tid = Integer.parseInt(params.get("tid"));

        // 测试代码
        Integer tid = 1;

        String token = params.get("token");

        // 测试代码
        token = "4321:adliH";
        
        // 解析token，获取用户信息
        String username = TokenUtil.decodeToken(token);
        Integer uid = userMapper.getUserId(username);

        // 测试代码
        uid = 1;

        // 2. 数据校验
        if (StringUtils.isEmpty(pname) || tid <= 0 || uid <= 0)
            return new CommonResult(WebResponce.FAIL.getCode(), "false");

        // 3. 数据封装
        Post post = new Post(pname, pcontent, postImg, tid, uid);

        // 4. 调用PostMapper
        if(postMapper.publishPost(post) > 0)
            return new CommonResult(WebResponce.SUCCESS.getCode(), "true");

        return new CommonResult(WebResponce.FAIL.getCode(), "false");
    }


    @Test
    public void testGetAllPosts() {
        PostServiceImpl postService = new PostServiceImpl();
        List<Post> allPosts = postService.getAllPosts();
        for (Post allPost : allPosts) {
            System.out.println(allPost);
        }
    }


    @Test
    public void testPublishPost() {
        PostServiceImpl postService = new PostServiceImpl();
        Map<String, String> map = new HashMap<>();
        map.put("pname", "文章标题");
        map.put("pcontent", "文章内容");
        map.put("tid", "1");
        map.put("postImg", "??????????????");
        map.put("token", "4321:nimda");

        System.out.println(postService.publishPost(map));
    }
}
