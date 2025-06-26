package org.phuongnq.survey.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.util.Map;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.annotations.UuidGenerator;
import org.hibernate.type.SqlTypes;

@Entity
@Table(name = "results")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Result {

  @Id
  @Column(nullable = false, updatable = false)
  @GeneratedValue
  @UuidGenerator
  private UUID id;

  @ManyToOne
  private Survey survey;

  @JdbcTypeCode(SqlTypes.JSON)
  @Column(name = "json", columnDefinition = "jsonb")
  private Map<String, Object> json;
}
