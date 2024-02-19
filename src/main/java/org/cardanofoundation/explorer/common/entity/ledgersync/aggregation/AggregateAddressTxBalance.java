package org.cardanofoundation.explorer.common.entity.ledgersync.aggregation;

import java.math.BigInteger;
import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Digits;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import org.cardanofoundation.explorer.common.entity.ledgersync.BaseEntity;
import org.cardanofoundation.explorer.common.entity.validation.Word128Type;

@Entity
@Table(name = "agg_address_tx_balance")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AggregateAddressTxBalance extends BaseEntity {

  @Column(name = "stake_address_id")
  protected Long stakeAddressId;

  @Column(name = "address_id")
  protected Long addressId;

  @Column(name = "balance", nullable = false, precision = 39)
  @Word128Type
  private @Digits(integer = 39, fraction = 0) BigInteger balance;

  @Column(name = "day")
  private LocalDate day;
}
