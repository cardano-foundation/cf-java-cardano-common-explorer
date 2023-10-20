package org.cardanofoundation.explorer.consumercommon.explorer.entity;

import java.sql.Timestamp;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.ConstraintMode;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import org.cardanofoundation.explorer.consumercommon.entity.BaseEntity;
import org.hibernate.Hibernate;

@Entity
@Table(name = "agg_pool_info")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder(toBuilder = true)
public class AggregatePoolInfo extends BaseEntity {

  @Column(name = "pool_id", nullable = false)
  private Long poolId;

  @Column(name = "delegator_cnt")
  private Integer delegatorCount;

  @Column(name = "block_life_time")
  private Integer blockLifeTime;

  @Column(name = "block_in_epoch")
  private Integer blockInEpoch;

  @Column(name = "block_check_point")
  private Long blockCheckPoint;

  @Column(name = "update_time")
  private Timestamp updateTime;

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) {
      return false;
    }
    AggregatePoolInfo that = (AggregatePoolInfo) o;
    return id != null && Objects.equals(id, that.id);
  }

  @Override
  public int hashCode() {
    return getClass().hashCode();
  }
}
