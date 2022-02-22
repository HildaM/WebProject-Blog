package com.test.service.impl;

import com.test.component.CommonResult;
import com.test.component.WebResponce;
import com.test.dao.UserMapper;
import com.test.pojo.User;
import com.test.service.UserService;
import com.test.utils.MybatisUtil;
import com.test.utils.TokenUtil;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName: UserServiceImpl
 * @Description: UserService实现类
 * @author: Hilda   Hilda_quan@163.com
 * @date: 2022/2/15 10:37
 */
public class UserServiceImpl implements UserService {

    @Override
    public CommonResult LoginService(Map<String, String> params) {
        // 数据库连接
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        // 1. 将数据拆包
        String username = params.get("username");
        String password = params.get("password");
        // System.out.println("service: " + username + " " + password);


        // 2. 数据校验
        if (StringUtils.isEmpty(username) || StringUtils.isEmpty(password))
            return new CommonResult(WebResponce.FAIL.getCode(), "false");

        // 生成token
        String token = TokenUtil.generateToken(username + ":" + password);
        Map<String, String> tokenMap = new HashMap<>();
        tokenMap.put("token", token);

        // 3. 成功后，进行数据库查询
        User user = userMapper.selectUserByName(username);
        if (user != null) {
            if (user.getUname().equals(username) && user.getUpassword().equals(password))
                return new CommonResult(WebResponce.SUCCESS.getCode(), "true", tokenMap);
            else return new CommonResult(WebResponce.FAIL.getCode(), "false");
        }


        return new CommonResult(WebResponce.FAIL.getCode(), "false");
    }


    @Test
    public void testLoginService() {
        UserServiceImpl userService = new UserServiceImpl();

        Map<String, String> params = new HashMap<>();
        params.put("username", "admin");
        params.put("password", "1234");

        System.out.println(userService.LoginService(params));
    }


    @Override
    public CommonResult SignUpService(Map<String, String> params) {
        // 数据库连接
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        // 1. 将数据拆包
        String username = params.get("username");
        String password = params.get("password");
        String email = params.get("email");

        // 2. 数据校验
        if (StringUtils.isEmpty(username) || StringUtils.isEmpty(password))
            return new CommonResult(WebResponce.FAIL.getCode(), "false");

        // 3. 成功后，添加用户
        User user = new User(username, password, email);
        if(userMapper.insertUser(user) > 0) {
            return new CommonResult(WebResponce.SUCCESS.getCode(), "true");
        }


        return new CommonResult(WebResponce.FAIL.getCode(), "false");
    }

    @Test
    public void testSignUpMapper() {
        User user = new User("testSignUp", "1234", "@163.com");

        SqlSession sqlSession = MybatisUtil.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        System.out.println(userMapper.insertUser(user));
    }

    @Test
    public void testSignUpService() {
        UserServiceImpl userService = new UserServiceImpl();

        HashMap<String, String> map = new HashMap<>();
        map.put("username", "test");
        map.put("password", "1234");
        map.put("email", "@163.com");

        System.out.println(userService.SignUpService(map));
    }
}
