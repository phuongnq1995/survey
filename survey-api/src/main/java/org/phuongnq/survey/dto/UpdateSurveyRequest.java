package org.phuongnq.survey.dto;

import java.util.Map;
import java.util.UUID;
import lombok.Data;

@Data
public class UpdateSurveyRequest {
  private UUID id;
  private String name;
  private Map<String, Object> json;
}
