package com.test.dao;

import com.test.pojo.Post;

import java.util.List;

/**
 * @ClassName: PostMapper
 * @Description: 帖子dao
 * @author: Hilda   Hilda_quan@163.com
 * @date: 2022/2/19 9:01
 */
public interface PostMapper {
    // 获取所有帖子
    public List<Post> getAllPosts();
}
