package com.test.service.impl;

import com.test.dao.PostMapper;
import com.test.dao.UserMapper;
import com.test.pojo.Post;
import com.test.service.PostService;
import com.test.utils.MybatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

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


    @Test
    public void testGetAllPosts() {
        PostServiceImpl postService = new PostServiceImpl();
        List<Post> allPosts = postService.getAllPosts();
        for (Post allPost : allPosts) {
            System.out.println(allPost);
        }
    }
}
