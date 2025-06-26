package org.phuongnq.survey.dto;

import java.util.Map;
import java.util.UUID;
import lombok.Data;

@Data
public class RunSurveyRequest {
  private UUID postId;
  private Map<String, Object> surveyResult;
}
