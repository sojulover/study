package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by ArtCoder on 2017. 5. 19..
 */
@Service
public class DemoService
{
  @Autowired
  RedisService redisService;

  public void getValue()
  {
    System.out.println("Redis Demo -----");
    System.out.println(redisService.getValue("redis"));
    System.out.println("Redis Demo -----");
  }
}