package org.cardanofoundation.explorer.common.entity.ledgersync.aggregation;

import java.math.BigInteger;
import java.time.LocalDate;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.AttributeOverrides;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Digits;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import org.cardanofoundation.explorer.common.entity.compositeKey.AggAddressTxBalanceId;
import org.cardanofoundation.explorer.common.entity.validation.Word128Type;

@Entity
@Table(name = "agg_address_tx_balance")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@IdClass(AggAddressTxBalanceId.class)
public class AggregateAddressTxBalance {

  @Column(name = "stake_address_id")
  protected Long stakeAddressId;

  @Id
  @Column(name = "address_id")
  protected Long addressId;

  @Id
  @Column(name = "day")
  private LocalDate day;

  @Column(name = "balance", nullable = false, precision = 39)
  @Word128Type
  private @Digits(integer = 39, fraction = 0) BigInteger balance;

  @Embedded
  @AttributeOverrides({
    @AttributeOverride(
        name = "address_id",
        column = @Column(name = "address_id", insertable = false, updatable = false)),
    @AttributeOverride(
        name = "day",
        column = @Column(name = "day", insertable = false, updatable = false)),
  })
  private AggAddressTxBalanceId id;
}
