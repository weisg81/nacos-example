package com.alibaba.nacos.example.spring.boot.controller;

import com.alibaba.nacos.api.config.annotation.NacosValue;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@Controller
@RequestMapping("config")
public class ConfigController {

    /**
     * 通过调用 Nacos Open API 向 Nacos server 发布配置：dataId 为example，内容为useLocalCache=true
     * curl -X POST "http://127.0.0.1:8848/nacos/v1/cs/configs?dataId=example&group=DEFAULT_GROUP&content=useLocalCache=true"
     */
    //@NacosValue(value = "${useLocalCache:weisg}", autoRefreshed = true)
    @NacosValue(value = "${useLocalCache}", autoRefreshed = true)
    private Object useLocalCache;

    @RequestMapping(value = "/get", method = GET)
    @ResponseBody
    public Object get() {
        return useLocalCache;
    }
}