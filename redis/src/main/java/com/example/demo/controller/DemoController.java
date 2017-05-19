package com.example.demo.controller;

import com.example.demo.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created on 2017. 5. 19..
 */
@Controller
public class DemoController
{
  @Autowired
  DemoService demoService;

  @RequestMapping("/")
  public String index()
  {
    demoService.getValue();

    return "index";
  }
}