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

import org.cardanofoundation.explorer.common.entity.compositeKey.AddressBalanceId;
import org.cardanofoundation.explorer.common.entity.ledgersync.BlockAwareEntity;

@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Entity
@Table(name = "address_balance")
@IdClass(AddressBalanceId.class)
@DynamicUpdate
public class AddressBalance extends BlockAwareEntity {

  @Id
  @Column(name = "address")
  private String address;

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

  // Only set if address doesn't fit in ownerAddr field. Required for few Byron Era addr
  @Column(name = "addr_full")
  private String addrFull;

  @Column(name = "epoch")
  private Integer epoch;
}
