package org.phuongnq.survey.dto;

import java.util.List;
import java.util.Map;
import java.util.UUID;
import lombok.Data;

@Data
public class SurveyResultDto {

  private UUID id;
  private List<Map<String, Object>> data;
}
