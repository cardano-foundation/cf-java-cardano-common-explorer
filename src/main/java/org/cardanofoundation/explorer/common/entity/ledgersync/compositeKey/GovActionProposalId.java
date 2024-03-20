package org.cardanofoundation.explorer.common.entity.ledgersync.compositeKey;

import java.io.Serializable;

import jakarta.persistence.Column;

import lombok.EqualsAndHashCode;

@EqualsAndHashCode
public class GovActionProposalId implements Serializable {
  @Column(name = "tx_hash")
  private String txHash;

  @Column(name = "idx")
  private long index;
}
