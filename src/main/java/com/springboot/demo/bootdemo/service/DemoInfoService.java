package com.springboot.demo.bootdemo.service;

import com.springboot.demo.bootdemo.entity.DemoInfo;

/**
 * 〈说明〉<br>
 * 〈〉
 *
 * @author mao
 * @Date: 2019/3/6 0006
 * @Description:
 * @since 1.0.0
 */
public interface DemoInfoService {
     DemoInfo findById(long id);
     void deleteFromCache(long id);
    void test();
}
