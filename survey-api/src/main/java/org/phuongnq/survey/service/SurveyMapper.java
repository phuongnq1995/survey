package org.phuongnq.survey.service;


import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.phuongnq.survey.dto.SurveyDto;
import org.phuongnq.survey.model.Survey;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface SurveyMapper {

  SurveyDto map(Survey entity);

  List<SurveyDto> mapToSurveyDtos(List<Survey> all);
}
