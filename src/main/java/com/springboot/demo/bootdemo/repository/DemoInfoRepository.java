
package com.springboot.demo.bootdemo.repository;

import com.springboot.demo.bootdemo.entity.DemoInfo;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by wangcm on 2018/1/13.
 */
public interface DemoInfoRepository extends CrudRepository<DemoInfo, Long> {

}
