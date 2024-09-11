package net.hifor.configuration.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author IKin <br/>
 * @description 第一个springboot  <br/>
 * @date 2019/11/17 <br/>
 */
@RestController
@RefreshScope
public class HelloSpringCloudController {


    @Value("${test:xxx}")
    private String test;

    @Value("${username:xxx}")
    private String username;

    @Value("${computername:xxx}")
    private String computerName;

    @Value("${abc:xxx}")
    private String abc;

    /**
     * spring cloud 配置中心
     *
     * @return
     */
    @GetMapping("/config")
    public String hello() {
        return "Hello Spring cloud !"
                +"<br/> test: " + test
                +"<br/> computerName: " + computerName
                +"<br/> username: " + username
                +"<br/> abc: " + abc
                ;
    }
}
