package com.test.service.impl;

import com.test.component.CommonResult;
import com.test.component.WebResponce;
import com.test.dao.DetailMapper;
import com.test.dao.PostMapper;
import com.test.dao.UserMapper;
import com.test.pojo.PostReply;
import com.test.service.DetailService;
import com.test.utils.MybatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName: DetailServiceImpl
 * @Description: 帖子详情实现类
 * @author: Hilda   Hilda_quan@163.com
 * @date: 2022/2/21 12:23
 */
public class DetailServiceImpl implements DetailService {

    public CommonResult getRepliesByPid(int pathId) {
        // 数据库连接
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        DetailMapper detailMapper = sqlSession.getMapper(DetailMapper.class);

        // 调用服务
        List<PostReply> replies = detailMapper.getRepliesByPid(pathId);

        // 封装参数
        Map<String, Object> result = new HashMap<>();
        result.put("pname", null);
        result.put("pid", replies.get(0).getPid());
        result.put("floor", replies);

        return new CommonResult(WebResponce.SUCCESS.getCode(), result);
    }


    @Override
    public CommonResult addComment(Map<String, String> params) {
        // 数据库连接
        SqlSession sqlSession = MybatisUtil.getSqlSession();

        // 1. 解析字段
        String username = params.get("username");
        String pid = params.get("pid");
        String rcomment = params.get("comment");

        // 2. 获取用户uid
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        Integer userId = userMapper.getUserId(username);

        // 3. 写入数据库
        DetailMapper detailMapper = sqlSession.getMapper(DetailMapper.class);
        PostReply postReply = new PostReply(Integer.parseInt(pid), rcomment, userId);

        // 4. 返回结果
        if (detailMapper.addComment(postReply) > 0) {
            return new CommonResult(WebResponce.SUCCESS.getCode(), "true");
        }

        return new CommonResult(WebResponce.FAIL.getCode(), "false");
    }

    @Test
    public void testMapper() {
        DetailServiceImpl detailService = new DetailServiceImpl();
        CommonResult repliesByPid = detailService.getRepliesByPid(1);

        System.out.println(repliesByPid);
    }

    @Test
    public void testAddComment() {
        DetailServiceImpl detailService = new DetailServiceImpl();
        Map<String, String> map = new HashMap<>();
        map.put("pid", "10");
        map.put("rcomment", "test");
        map.put("username", "Hilda");

        CommonResult commonResult = detailService.addComment(map);
        System.out.println(commonResult);
    }
}
