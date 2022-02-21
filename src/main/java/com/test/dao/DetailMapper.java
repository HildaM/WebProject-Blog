package com.test.dao;

import com.test.pojo.PostReply;

import java.util.List;

/**
 * @ClassName: DetailMapper
 * @Description: 帖子详情mapper
 * @author: Hilda   Hilda_quan@163.com
 * @date: 2022/2/21 12:30
 */
public interface DetailMapper {

    // 根据指定的pid获取所有的postreplys
    public List<PostReply> getRepliesByPid(int pid);
}
