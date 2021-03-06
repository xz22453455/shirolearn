
package com.springboot.demo.bootdemo.service.impl;


import com.springboot.demo.bootdemo.entity.DemoInfo;
import com.springboot.demo.bootdemo.repository.DemoInfoRepository;
import com.springboot.demo.bootdemo.service.DemoInfoService;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


@Service
public class DemoInfoServiceImpl implements DemoInfoService {
    @Resource
    private DemoInfoRepository demoInfoRepository;
    @Resource
    private RedisTemplate<String, String> redisTemplate;

    @Override
    public void test() {
        ValueOperations<String, String> valueOperations = redisTemplate.opsForValue();
        valueOperations.set("mykey4", "random1=" + Math.random());
        System.out.println(valueOperations.get("mykey4"));
    }

    /**
     * value：缓存位置名称，不能为空，如果使用EHCache，就是ehcache.xml中声明的cache的name
     * key：缓存的key，默认为空，既表示使用方法的参数类型及参数值作为key，支持SpEL
     * condition：触发条件，只有满足条件的情况才会加入缓存，默认为空，既表示全部都加入缓存，支持SpEL
     * @param id
     * @return
     */
    //keyGenerator="myKeyGenerator"
    @Cacheable(value = "demoInfo") //缓存,这里没有指定key.
    @Override
    public DemoInfo findById(long id) {
        System.err.println("DemoInfoServiceImpl.findById()=========从数据库中进行获取的....id=" + id);
        return demoInfoRepository.findOne(id);
    }

    /**
     * @CacheEvict 支持如下几个参数：
     * value：缓存位置名称，不能为空，同上
     * key：缓存的key，默认为空，同上
     * condition：触发条件，只有满足条件的情况才会清除缓存，默认为空，支持SpEL
     * allEntries：true表示清除value中的全部缓存，默认为false
     * @param id
     */
    @CacheEvict(value = "demoInfo")
    @Override
    public void deleteFromCache(long id) {
        System.out.println("DemoInfoServiceImpl.delete().从缓存中删除.");
    }
}
