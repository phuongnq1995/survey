package org.phuongnq.survey.repository;

import java.util.List;
import java.util.UUID;
import org.phuongnq.survey.model.Result;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ResultRepository extends JpaRepository<Result, UUID> {
  List<Result> findBySurveyId(UUID surveyId);
}
