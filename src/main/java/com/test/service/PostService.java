package com.test.service;

import com.test.component.CommonResult;
import com.test.pojo.Post;

import java.util.List;
import java.util.Map;

/**
 * @ClassName: PostService
 * @Description: 帖子服务
 * @author: Hilda   Hilda_quan@163.com
 * @date: 2022/2/19 8:58
 */
public interface PostService {

    // 获取所有帖子
    public List<Post> getAllPosts();

    // 发布帖子
    public CommonResult publishPost(Map<String, String> params);
}
