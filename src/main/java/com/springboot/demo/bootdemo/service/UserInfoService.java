package com.springboot.demo.bootdemo.service;

import com.springboot.demo.bootdemo.entity.UserInfo;

/**
 * 〈说明〉<br>
 * 〈〉
 *
 * @author mao
 * @Date: 2019/3/6 0006
 * @Description:
 * @since 1.0.0
 */
public interface UserInfoService {
    /**通过username查找用户信息;*/
    public UserInfo findByUsername(String username);
    String userInfoAdd(UserInfo userInfo);
}
