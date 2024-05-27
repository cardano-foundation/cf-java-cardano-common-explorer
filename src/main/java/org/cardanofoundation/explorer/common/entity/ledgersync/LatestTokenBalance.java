package org.cardanofoundation.explorer.common.entity.ledgersync;

import java.math.BigInteger;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.AttributeOverrides;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import org.cardanofoundation.explorer.common.entity.compositeKey.AddressBalanceId;

@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Entity
@Table(name = "latest_token_balance")
@IdClass(AddressBalanceId.class)
public class LatestTokenBalance {

  @Id
  @Column(name = "address")
  private String address;

  @Column(name = "stake_address")
  private String stakeAddress;

  @Column(name = "policy")
  private String policy;

  @Id
  @Column(name = "unit")
  private String unit;

  @Id
  @Column(name = "slot")
  private Long slot;

  @Embedded
  @AttributeOverrides({
    @AttributeOverride(
        name = "address",
        column = @Column(name = "address", insertable = false, updatable = false)),
    @AttributeOverride(
        name = "unit",
        column = @Column(name = "unit", insertable = false, updatable = false)),
    @AttributeOverride(
        name = "slot",
        column = @Column(name = "slot", insertable = false, updatable = false))
  })
  private AddressBalanceId id;

  @Column(name = "quantity")
  private BigInteger quantity;

  @Column(name = "block_time")
  private Long blockTime;
}
