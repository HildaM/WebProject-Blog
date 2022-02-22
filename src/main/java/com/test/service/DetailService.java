package com.test.service;

import com.test.component.CommonResult;
import com.test.pojo.PostReply;

import java.util.List;
import java.util.Map;

/**
 * @ClassName: DetailService
 * @Description: 帖子详情服务
 * @author: Hilda   Hilda_quan@163.com
 * @date: 2022/2/21 12:23
 */
public interface DetailService {

    // 根据指定的pid获取所有相关的postpreplies
    public CommonResult getRepliesByPid(int pathId);

    // 添加评论
    CommonResult addComment(Map<String, String> params);
}
