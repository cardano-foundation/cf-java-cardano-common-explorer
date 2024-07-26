package org.cardanofoundation.explorer.common.entity.ledgersyncsagg;

import java.math.BigInteger;
import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Digits;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import org.hibernate.annotations.DynamicUpdate;

import org.cardanofoundation.explorer.common.entity.compositeKey.StakeAddressTxBalanceId;
import org.cardanofoundation.explorer.common.entity.validation.Word128Type;

@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Entity
@Table(name = "stake_tx_balance")
@IdClass(StakeAddressTxBalanceId.class)
@DynamicUpdate
public class StakeTxBalance {

  @Id
  @Column(name = "tx_hash")
  private String txHash;

  @Id
  @Column(name = "stake_address")
  private String stakeAddress;

  @Id
  @Column(name = "day")
  private LocalDate day;

  @Column(name = "balance_change", nullable = false, precision = 39)
  @Word128Type
  @Digits(integer = 39, fraction = 0)
  private BigInteger balanceChange;

  @Column(name = "slot")
  private Long slot;
}
