package org.cardanofoundation.explorer.common.entity.ledgersync.compositeKey;

import java.io.Serializable;

import jakarta.persistence.Column;

import lombok.EqualsAndHashCode;

@EqualsAndHashCode
public class VotingProcedureId implements Serializable {
  @Column(name = "tx_hash")
  private String txHash;

  @Column(name = "voter_hash")
  private String voterHash;

  @Column(name = "gov_action_tx_hash")
  private String govActionTxHash;

  @Column(name = "gov_action_index")
  private Integer govActionIndex;
}
