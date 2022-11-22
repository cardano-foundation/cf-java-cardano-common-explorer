package com.sotatek.cardano.common.entity;

import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Entity
@Table(name = "pool_stake", uniqueConstraints = {
    @UniqueConstraint(name = "uni_pool_id",
        columnNames = {"pool_id"})
})
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = false)
@SuperBuilder(toBuilder = true)
public class PoolStake extends BaseEntity {

  @OneToOne
  @JoinColumn(name = "pool_id")
  private PoolHash pool;

  @Column(name = "amount")
  private BigDecimal amount;
}
