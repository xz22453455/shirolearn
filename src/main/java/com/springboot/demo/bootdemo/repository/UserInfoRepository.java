/**
 * Author:   wangcm
 * Date:     2019/3/6 0006 16:38
 * Description: .UserInfoRepository
 */
package com.springboot.demo.bootdemo.repository;

import com.springboot.demo.bootdemo.entity.UserInfo;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by wangcm on 2018/1/13.
 */
public interface UserInfoRepository extends CrudRepository<UserInfo, Long> {
    /**
     * 通过username查找用户信息;
     */
    UserInfo findByUsername(String username);
}
