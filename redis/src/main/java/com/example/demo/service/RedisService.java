package com.example.demo.service;

import com.example.demo.dto.Traffic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.*;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by ArtCoder on 2017. 5. 19..
 */
@Service
public class RedisService
{
  @Autowired
  private RedisTemplate<String, String> redisTemplate;

  @Resource(name="redisTemplate")
  private ValueOperations<String, String> valueOperations;
  @Resource(name="redisTemplate")
  private ListOperations<String, String> listOperations;
  @Resource(name="redisTemplate")
  private HashOperations<String, String, String> hashOperations;
  @Resource(name="redisTemplate")
  private SetOperations<String, String> setOperations;
  @Resource(name="redisTemplate")
  private ZSetOperations<String, String> zSetOperations;

  public String getValue(String key)
  {
    return valueOperations.get(key);
  }

//  public List<Traffic> getTraffic()
//  {
//    RedisOperations<String, String> redis = listOperations.getOperations();
//    Set<String> keys = redis.keys("traffic*");
//
//    Iterator<String> iterator = keys.iterator();
//
//    List<Traffic> trafficList = new ArrayList<Traffic>();
//
//    while(iterator.hasNext())
//    {
//      String key = iterator.next().toString();
//      int size = (int)(long)redis.opsForList().size(key);
//
//      for(int i=0; i<size; i++)
//      {
//        Traffic traffic = new Traffic();
//        traffic.setAvgSpeed(1);
//        traffic.setEndNodeId("endNodeId");
//        traffic.setGenerateDt("20170519172500");
//        traffic.setRoadNameText("roadName");
//        traffic.setStartNodeId("startNodeId");
//        trafficList.add(traffic);
//      }
//    }
//
//    return trafficList;
//  }
}
