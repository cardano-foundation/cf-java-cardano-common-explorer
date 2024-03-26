package org.cardanofoundation.explorer.common.entity.ledgersync;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Id;

import lombok.EqualsAndHashCode;

@EqualsAndHashCode
public class StakeRegistrationId implements Serializable {
  @Id
  @Column(name = "tx_hash")
  private String txHash;

  @Id
  @Column(name = "cert_index")
  private long certIndex;
}
