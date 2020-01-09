package com.test.spring.mvc.initializerdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * <b>Author</b>: Xiang Liguo<br/>
 * <b>Date</b>: 2020/01/08 15:38<br/>
 * <b>Version</b>: 1.0<br/>
 * <b>Subject</b>: <br/>
 * <b>Description</b>:
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @ResponseBody
    @RequestMapping("/query")
    public String queryUser() {
        return "@test";
    }
}
