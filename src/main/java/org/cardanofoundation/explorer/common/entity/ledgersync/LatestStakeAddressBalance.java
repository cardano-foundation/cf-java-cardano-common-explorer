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

import org.cardanofoundation.explorer.common.entity.compositeKey.StakeAddressBalanceId;

@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Entity
@Table(name = "latest_stake_address_balance")
@IdClass(StakeAddressBalanceId.class)
public class LatestStakeAddressBalance {

  @Id
  @Column(name = "address")
  private String address;

  @Id
  @Column(name = "slot")
  private Long slot;

  @Embedded
  @AttributeOverrides({
    @AttributeOverride(
        name = "address",
        column = @Column(name = "address", insertable = false, updatable = false)),
    @AttributeOverride(
        name = "slot",
        column = @Column(name = "slot", insertable = false, updatable = false))
  })
  private StakeAddressBalanceId id;

  @Column(name = "quantity")
  private BigInteger quantity;
}
