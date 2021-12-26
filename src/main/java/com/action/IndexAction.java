package com.action;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Dely
 */
@Controller
public class IndexAction {

    @RequestMapping("/")
    public String welcome(Model model) {
        return "index";
    }

    @RequestMapping("/index")
    public String index() {
        return "index";
    }
}
