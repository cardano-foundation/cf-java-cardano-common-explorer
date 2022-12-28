package com.sotatek.cardano.common.entity;

import java.sql.Timestamp;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.hibernate.Hibernate;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

@Entity
@Table(name = "meta", uniqueConstraints = {
    @UniqueConstraint(name = "unique_meta",
        columnNames = {"start_time"})
})
@Where(clause = "is_deleted is null or is_deleted = false")
@SQLDelete(sql = "update meta set is_deleted = true where id = ?")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder(toBuilder = true)
public class Meta extends BaseEntity {

  @Column(name = "start_time", nullable = false)
  private Timestamp startTime;

  @Column(name = "network_name", nullable = false)
  private String networkName;

  @Column(name = "version", nullable = false)
  private String version;

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) {
      return false;
    }
    Meta meta = (Meta) o;
    return id != null && Objects.equals(id, meta.id);
  }

  @Override
  public int hashCode() {
    return getClass().hashCode();
  }
}
