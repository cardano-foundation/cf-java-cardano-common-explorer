package org.cardanofoundation.explorer.common.entity.ledgersync;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Id;

import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.experimental.FieldDefaults;

@EqualsAndHashCode
@FieldDefaults(level = AccessLevel.PRIVATE)
public class StakeAddressBalanceId implements Serializable {
  @Id
  @Column(name = "address")
  String address;

  @Id
  @Column(name = "slot")
  Long slot;
}
