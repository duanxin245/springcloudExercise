package com.example.student.studentdemo.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * 老师feign
 *
 * @author xuke
 * @date 2021/08/22 19:48
 **/

@FeignClient("teacher-demo")
public interface TeacherClient {
    @GetMapping("/teacher/show")
    String show();
    @GetMapping("/teacher/showMsg")
    String showMsg(String msg);
    @GetMapping("/teacher/showMsg")
    String showMsg(String msg,String name);
}
