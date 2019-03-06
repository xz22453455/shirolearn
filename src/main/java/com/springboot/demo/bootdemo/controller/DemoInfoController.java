
package com.springboot.demo.bootdemo.controller;

/**
 * Created by wangcm on 2018/1/13.
 */

import com.springboot.demo.bootdemo.entity.DemoInfo;
import com.springboot.demo.bootdemo.service.DemoInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class DemoInfoController {
    @Autowired
    DemoInfoService demoInfoService;

    @RequestMapping("/test")
    public @ResponseBody
    String test() {
        DemoInfo loaded = demoInfoService.findById(5);
        System.out.println("loaded=" + loaded);
        DemoInfo cached = demoInfoService.findById(6);
        System.out.println("cached=" + cached);
        loaded = demoInfoService.findById(2);
        System.out.println("loaded2=" + loaded);
        return "ok";
    }

    @RequestMapping("/delete")
    public @ResponseBody
    String delete(long id) {
        demoInfoService.deleteFromCache(id);
        return "ok";
    }

    @RequestMapping("/test1")
    public @ResponseBody
    String test1() {
        demoInfoService.test();
        System.out.println("DemoInfoController.test1()");
        return "ok";
    }
}