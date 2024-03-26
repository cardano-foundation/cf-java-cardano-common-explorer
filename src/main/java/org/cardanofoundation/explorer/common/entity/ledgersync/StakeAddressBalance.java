package org.cardanofoundation.explorer.common.entity.ledgersync;

import java.math.BigInteger;
import java.sql.Timestamp;

import jakarta.persistence.*;

import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;

@Entity
@Table(
    name = "stake_address_balance",
    uniqueConstraints = {
      @UniqueConstraint(
          name = "unique_stake_address_balance",
          columnNames = {"address", "slot"})
    })
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder(toBuilder = true)
@IdClass(StakeAddressBalanceId.class)
public class StakeAddressBalance {
  @Id
  @Column(name = "address")
  String address;

  @Id
  @Column(name = "slot")
  Long slot;

  @Column(name = "quantity")
  BigInteger quantity;

  @Column(name = "stake_credential")
  String stakeCredential;

  @Column(name = "block_hash")
  String blockHash;

  @Column(name = "block")
  Long block;

  @Column(name = "block_time")
  BigInteger blockTime;

  @Column(name = "epoch")
  Integer epoch;

  @Column(name = "update_datetime")
  Timestamp updateDatetime;
}
