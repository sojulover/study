package com.example.demo.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by ArtCoder on 2017. 5. 19..
 */
@Data
public class Traffic
{
  private String roadSectionId;
  private String generateDt;
  private int avgSpeed;
  private String startNodeId;
  private String endNodeId;
  private String roadNameText;
  private int travelTime;
}