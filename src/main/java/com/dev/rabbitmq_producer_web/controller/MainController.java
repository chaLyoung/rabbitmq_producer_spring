package com.dev.rabbitmq_producer_web.controller;

import com.dev.rabbitmq_producer_web.service.RabbitmqService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Slf4j
@Controller
@CrossOrigin(origins = "*")
public class MainController {
    @Autowired
    RabbitmqService rabbitmqService;

    @RequestMapping("/")
    public ModelAndView index() {
        ModelAndView mv = new ModelAndView();
        rabbitmqService.sendToAIProfiler("ai.test", "hello");
        mv.setViewName("index");
        return mv;
    }
}
