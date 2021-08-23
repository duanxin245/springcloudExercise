package com.example.student.studentdemo.controller;

import com.example.student.studentdemo.clients.TeacherClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 学生接口
 *
 * @author xuke
 * @date 2021/08/22 16:33
 **/
@RestController
@Slf4j
public class StudentController {
    @Value("${spring.application.name}")
    private String applicationName;
    @Value("${server.port}")
    private String post;
    @Value("${user.dir}")
    private String dir;

    @GetMapping("/show")
    public String show(){
        String str = "服务器名称:"+applicationName+"\n 服务器端口:"+post+"\n 当前程序所在目录:"+dir;
        log.info(str);
        return str;
    }

    @GetMapping("/showMsg")
    public String showMsg(String msg){
        String str = "传递信息:"+msg+"\n服务器名称:"+applicationName+"\n 服务器端口:"+post+"\n 当前程序所在目录:"+dir;
        log.info(str);
        return str;
    }

    @Resource
    TeacherClient teacherClient;

    @GetMapping("showTeacher")
    public String showTeacher(){
        log.info("使用feign获取老师模块信息");
        log.info(">>>>>>>>>>>>>当前服务器信息<<<<<<<<<<<<");
        String str = "服务器名称:"+applicationName+"\n 服务器端口:"+post+"\n 当前程序所在目录:"+dir;
        log.info(str);
        log.info(">>>>>>>>>>><<<<<<<<<<<<<<<<<<<<<<<<<<");
        String teacherStr = teacherClient.show();
        log.info("<<<<<<<<<<<<<<<<<<<<<<获取到服务器信息>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        log.info(teacherStr);
        return teacherStr;
    }

    @GetMapping("showMsgTeacher")
    public String showMsgTeacher(String msg){
        log.info("使用feign获取老师模块信息");
        log.info(">>>>>>>>>>>>>当前服务器信息<<<<<<<<<<<<");
        String str = "服务器名称:"+applicationName+"\n 服务器端口:"+post+"\n 当前程序所在目录:"+dir;
        log.info(str);
        String teacherStr = teacherClient.showMsg(msg);
        log.info("<<<<<<<<<<<<<<<<<<<<<<获取到服务器信息>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        log.info(teacherStr);
        return teacherStr;
    }

}
