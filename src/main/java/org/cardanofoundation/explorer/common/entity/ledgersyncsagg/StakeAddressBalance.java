package org.cardanofoundation.explorer.common.entity.ledgersyncsagg;

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

import org.hibernate.annotations.DynamicUpdate;

import org.cardanofoundation.explorer.common.entity.compositeKey.StakeAddressBalanceId;
import org.cardanofoundation.explorer.common.entity.ledgersync.BlockAwareEntity;

@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Entity
@Table(name = "stake_address_balance")
@IdClass(StakeAddressBalanceId.class)
@DynamicUpdate
public class StakeAddressBalance extends BlockAwareEntity {
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

  @Column(name = "epoch")
  private Integer epoch;
}
