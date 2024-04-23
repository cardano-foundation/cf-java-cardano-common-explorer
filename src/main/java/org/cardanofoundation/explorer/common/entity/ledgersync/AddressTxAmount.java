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
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import org.hibernate.annotations.DynamicUpdate;

import org.cardanofoundation.explorer.common.entity.compositeKey.AddressTxAmountId;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "address_tx_amount")
@IdClass(AddressTxAmountId.class)
@DynamicUpdate
public class AddressTxAmount {

  @Id
  @Column(name = "address")
  private String address;

  @Id
  @Column(name = "unit")
  private String unit;

  @Id
  @Column(name = "tx_hash")
  private String txHash;

  @Embedded
  @AttributeOverrides({
    @AttributeOverride(
        name = "address",
        column = @Column(name = "address", insertable = false, updatable = false)),
    @AttributeOverride(
        name = "unit",
        column = @Column(name = "unit", insertable = false, updatable = false)),
    @AttributeOverride(
        name = "tx_hash",
        column = @Column(name = "tx_hash", insertable = false, updatable = false))
  })
  private AddressTxAmountId id;

  @Column(name = "slot")
  private Long slot;

  @Column(name = "quantity")
  private BigInteger quantity;

  // Only set if address doesn't fit in ownerAddr field. Required for few Byron Era addr
  @Column(name = "addr_full")
  private String addrFull;

  @Column(name = "stake_address")
  private String stakeAddress;

  @Column(name = "epoch")
  private Integer epoch;

  @Column(name = "block")
  private Long blockNumber;

  @Column(name = "block_time")
  private Long blockTime;
}
