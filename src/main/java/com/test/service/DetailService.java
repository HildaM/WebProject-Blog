package com.test.service;

import com.test.component.CommonResult;
import com.test.pojo.PostReply;

import java.util.List;

/**
 * @ClassName: DetailService
 * @Description: 帖子详情服务
 * @author: Hilda   Hilda_quan@163.com
 * @date: 2022/2/21 12:23
 */
public interface DetailService {

    // 根据指定的pid获取所有相关的postpreplies
    public CommonResult getRepliesByPid(int pathId);
}
