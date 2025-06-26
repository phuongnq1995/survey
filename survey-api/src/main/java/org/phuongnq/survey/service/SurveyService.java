package org.phuongnq.survey.service;

import java.util.List;
import java.util.Map;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.phuongnq.survey.dto.RunSurveyRequest;
import org.phuongnq.survey.dto.SurveyDto;
import org.phuongnq.survey.dto.UpdateSurveyRequest;
import org.phuongnq.survey.dto.SurveyResultDto;
import org.phuongnq.survey.model.Result;
import org.phuongnq.survey.model.Survey;
import org.phuongnq.survey.repository.ResultRepository;
import org.phuongnq.survey.repository.SurveyRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SurveyService {
  private final SurveyRepository surveyRepository;
  private final ResultRepository resultRepository;
  private final SurveyMapper mapper;

  public SurveyResultDto getResults(UUID surveyId) {
    List<Map<String, Object>> data = resultRepository.findBySurveyId(surveyId)
        .stream()
        .map(Result::getJson)
        .toList();
    SurveyResultDto result = new SurveyResultDto();
    result.setId(surveyId);
    result.setData(data);
    return result;
  }

  public SurveyDto getSurvey(UUID surveyId) {
    return mapper.map(surveyRepository.findById(surveyId).orElseThrow());
  }

  public List<SurveyDto> getActives() {
    return mapper.mapToSurveyDtos(surveyRepository.findAll());
  }

  public SurveyDto create() {
    Survey survey = new Survey();
    survey.setName("New Survey");
    return mapper.map(surveyRepository.save(survey));
  }

  public SurveyResultDto changeJson(UpdateSurveyRequest request) {
    Survey survey = surveyRepository.findById(request.getId()).orElseThrow();
    survey.setJson(request.getJson());
    surveyRepository.save(survey);
    return getResults(request.getId());
  }

  public void delete(UUID id) {
    surveyRepository.deleteById(id);
  }

  public void post(RunSurveyRequest request) {
    Result result = new Result();
    result.setSurvey(surveyRepository.findById(request.getPostId()).orElseThrow());
    result.setJson(request.getSurveyResult());
    resultRepository.save(result);
  }
}
