package org.phuongnq.survey.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.annotations.UuidGenerator;
import org.hibernate.type.SqlTypes;

@Entity
@Table(name = "surveys")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Survey {

  @Id
  @Column(nullable = false, updatable = false)
  @GeneratedValue
  @UuidGenerator
  private UUID id;

  private String name;

  @JdbcTypeCode(SqlTypes.JSON)
  @Column(name = "json", columnDefinition = "jsonb")
  private Map<String, Object> json;

  @OneToMany(mappedBy = "survey", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
  private Set<Result> results;
}
