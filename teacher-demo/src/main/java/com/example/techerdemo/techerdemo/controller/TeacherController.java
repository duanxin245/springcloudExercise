package com.example.techerdemo.techerdemo.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 老师
 * @author xuke
 * @date 2021/08/22 16:47
 **/
@RestController
@Slf4j
public class TeacherController {
    @Value("${spring.application.name}")
    private String applicationName;
    @Value("${server.port}")
    private String post;
    @Value("${user.dir}")
    private String dir;
    @GetMapping("/teacher/show")
    public String show(){
        String str = "服务器名称:"+applicationName+"\n 服务器端口:"+post+"\n 当前程序所在目录:"+dir;
        log.info(str);
        return str;
    }


    @GetMapping("/teacher/showMsg")
    public String showMsg(String msg){
        String str = "传递信息:"+msg+"\n服务器名称:"+applicationName+"\n 服务器端口:"+post+"\n 当前程序所在目录:"+dir;
        log.info(str);
        return str;
    }
}
