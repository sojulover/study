package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.StringRedisTemplate;

/**
 * Created on 2017. 5. 19..
 */
@Configuration
public class RedisConfiguration
{
  @Bean
  public JedisConnectionFactory jedisConnectionFactory()
  {
    // host, port 등 을 application.yml에서 가져오고 싶었는데, @ConfigurationProperties가 스프링 1.4에서 변경되어 적용 못 했음.
    JedisConnectionFactory jedisConnectionFactory = new JedisConnectionFactory();
    jedisConnectionFactory.setHostName("127.0.0.1");
    jedisConnectionFactory.setPort(6379);
    jedisConnectionFactory.setTimeout(0);
    jedisConnectionFactory.setUsePool(true);

    return jedisConnectionFactory;
  }

  @Bean
  public StringRedisTemplate redisTemplate(JedisConnectionFactory jedisConnectionFactory)
  {
    StringRedisTemplate stringRedisTemplate = new StringRedisTemplate();
    stringRedisTemplate.setConnectionFactory(jedisConnectionFactory);

    return stringRedisTemplate;
  }
}
