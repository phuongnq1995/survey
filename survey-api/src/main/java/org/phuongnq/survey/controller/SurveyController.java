package org.phuongnq.survey.controller;

import java.util.List;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.phuongnq.survey.dto.RunSurveyRequest;
import org.phuongnq.survey.dto.SurveyDto;
import org.phuongnq.survey.dto.UpdateSurveyRequest;
import org.phuongnq.survey.dto.SurveyResultDto;
import org.phuongnq.survey.service.SurveyService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api")
@RestController
@RequiredArgsConstructor
public class SurveyController {

  private final SurveyService surveyService;

  @GetMapping("/getActive")
  public ResponseEntity<List<SurveyDto>> getActives() {
    return ResponseEntity.ok(surveyService.getActives());
  }

  @GetMapping("/getSurvey")
  public ResponseEntity<SurveyDto> getSurvey(@RequestParam("surveyId") UUID surveyId) {
    return ResponseEntity.ok(surveyService.getSurvey(surveyId));
  }

  @GetMapping("/create")
  public ResponseEntity<SurveyDto> create() {
    return ResponseEntity.ok(surveyService.create());
  }

  @PostMapping("/changeJson")
  public ResponseEntity<SurveyResultDto> changeJson(@RequestBody UpdateSurveyRequest request) {
    return ResponseEntity.ok(surveyService.changeJson(request));
  }

  @GetMapping("/delete")
  public ResponseEntity<Void> delete(@RequestParam("id") UUID id) {
    surveyService.delete(id);
    return ResponseEntity.ok().build();
  }

  @GetMapping("/results")
  public ResponseEntity<SurveyResultDto> getResults(@RequestParam("postId") UUID postId) {
    return ResponseEntity.ok(surveyService.getResults(postId));
  }

  @PostMapping("/post")
  public ResponseEntity<Void> post(@RequestBody RunSurveyRequest request) {
    surveyService.post(request);
    return ResponseEntity.ok().build();
  }

}
