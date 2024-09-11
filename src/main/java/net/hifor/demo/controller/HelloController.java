package net.hifor.demo.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @author IKin <br/>
 * @description 第一个spring cloud alibaba  <br/>
 * @date 2019/11/17 <br/>
 */
@RestController
@RefreshScope
public class HelloController {

    /**
     * 第一个方法
     *
     * @return
     */
    @GetMapping("/")
    public String hello() {
        return "Hello Spring Cloud Alibaba!";
    }

    @Value("${spring.cloud.nacos.config.serverAddr:}")
    private String serverAddr;

    @Value("${spring.cloud.nacos.config.prefix:}")
    private String prefix;

    @Value("${spring.cloud.nacos.config.group:}")
    private String group;

    @Value("${spring.cloud.nacos.config.namespace:}")
    private String namespace;

    @GetMapping("/nacos/annotation")
    public Map<String, String> getConfigInfo() {
        Map<String, String> result = new HashMap<>(4);
        result.put("serverAddr", serverAddr);
        result.put("prefix", prefix);
        result.put("group", group);
        result.put("namespace", namespace);
        return result;
    }
}
