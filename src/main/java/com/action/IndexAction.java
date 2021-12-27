package com.action;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Dely
 */
@Controller
public class IndexAction {

    /**
     * 欢迎页
     * @return
     */
    @RequestMapping("/")
    public String welcome() {
        return "index";
    }

    /**
     * 首页
     * @return
     */
    @RequestMapping("/index")
    public String index() {
        return "index";
    }

    /**
     * 测试页，只是测试war包的方式
     * @return
     */
    @RequestMapping("/test")
    public String test() {
        return "test";
    }
}
