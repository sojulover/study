package com.example.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.*;

/**
 * Created by ArtCoder on 2017. 5. 23..
 */
@RestController
public class ThreadController
{
  // 요청할 주소
  private final String targetUrl = "http://localhost:8080/test";

  @RequestMapping("/")
  public void main()
  {
    FutureTask<String> task = new FutureTask<String>(new Callable<String>() {
      @Override
      public String call() throws Exception {
        return test(targetUrl);
      }
    });
    ExecutorService threadPool = Executors.newCachedThreadPool();
    threadPool.execute(task);

    try
    {
      String result = task.get(5, TimeUnit.SECONDS);
      System.out.println(result);
    }
    catch (Exception e)
    {
      e.printStackTrace();
    }
  }

  // 일반적인 java http connection
  public String test(String targetUrl)
  {
    HttpURLConnection connection = null;

    try
    {
      StringBuilder sb = new StringBuilder();
      long t1 = System.currentTimeMillis(), t2;

      URL url = new URL(targetUrl);
      connection = (HttpURLConnection) url.openConnection();
      connection.setRequestMethod("POST");
      connection.setRequestProperty("Content-Type", "application/json");
      connection.setUseCaches(false);
      connection.setDoOutput(true);

      DataOutputStream wr = new DataOutputStream(connection.getOutputStream());
      wr.close();
      InputStream is = connection.getInputStream();
      BufferedReader rd = new BufferedReader(new InputStreamReader(is));
      StringBuilder response = new StringBuilder();
      String line;

      while((line = rd.readLine()) != null)
      {
        response.append(line);
        response.append("\r");
      }
      rd.close();

      sb.append(response.toString());
      t2 = System.currentTimeMillis();
      sb.append(t2 - t1 + " - END");

      return sb.toString();
    }
    catch(Exception e)
    {
      e.printStackTrace();
      return null;
    }
    finally
    {
      if(connection != null)
        connection.disconnect();
    }
  }
}