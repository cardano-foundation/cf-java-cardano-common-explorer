package org.cardanofoundation.explorer.common.entity.explorer;

import java.sql.Timestamp;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import org.hibernate.Hibernate;

import org.cardanofoundation.explorer.common.entity.ledgersync.BaseEntity;

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

  @Column(name = "voting_power")
  private Integer votingPower;

  @Column(name = "governance_participation_rate")
  private Integer governanceParticipationRate;

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
