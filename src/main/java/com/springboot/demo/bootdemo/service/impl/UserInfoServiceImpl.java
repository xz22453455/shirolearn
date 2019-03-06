
package com.springboot.demo.bootdemo.service.impl;


import com.springboot.demo.bootdemo.entity.UserInfo;
import com.springboot.demo.bootdemo.repository.UserInfoRepository;
import com.springboot.demo.bootdemo.service.UserInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserInfoServiceImpl implements UserInfoService {
    @Resource
    private UserInfoRepository userInfoRepository;

    @Override
    public UserInfo findByUsername(String username) {
        System.out.println("UserInfoServiceImpl.findByUsername()");
        return userInfoRepository.findByUsername(username);
    }

    @Override
    public String userInfoAdd(UserInfo userInfo) {
        return null;
    }
}
