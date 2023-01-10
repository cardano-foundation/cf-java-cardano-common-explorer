package com.sotatek.cardano.common.entity;

import com.sotatek.cardano.common.enumeration.ReportStatus;
import com.sotatek.cardano.common.enumeration.ReportType;
import java.sql.Timestamp;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.hibernate.Hibernate;

@Entity
@Table(name = "report_history", uniqueConstraints = {
    @UniqueConstraint(name = "unique_storage_key",
        columnNames = {"storage_key"})
})
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder(toBuilder = true)
public class ReportHistory extends BaseEntity {

  @Column(name = "storage_key", nullable = false)
  private String storageKey;

  @Column(name = "report_name", nullable = false)
  private String reportName;

  @Column(name = "username", nullable = false)
  private String username;

  @Column(name = "created_at")
  private Timestamp createdAt;

  @Column(name = "status", nullable = false)
  @Enumerated(EnumType.STRING)
  private ReportStatus status;

  @Column(name = "type", nullable = false)
  @Enumerated(EnumType.STRING)
  private ReportType type;

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) {
      return false;
    }
    ReportHistory that = (ReportHistory) o;
    return id != null && Objects.equals(id, that.id);
  }

  @Override
  public int hashCode() {
    return getClass().hashCode();
  }
}
