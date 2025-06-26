package org.phuongnq.survey.repository;

import java.util.UUID;
import org.phuongnq.survey.model.Survey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.QueryHints;

public interface SurveyRepository extends JpaRepository<Survey, UUID> {

  @Query(value = "SELECT my_sequence.NEXTVAL FROM dual", nativeQuery = true)
  Long getNextSequenceValue();
}
