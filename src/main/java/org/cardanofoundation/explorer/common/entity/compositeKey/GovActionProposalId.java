package org.cardanofoundation.explorer.common.entity.compositeKey;

import java.io.Serializable;

import jakarta.persistence.Column;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GovActionProposalId implements Serializable {
  @Column(name = "tx_hash", insertable = false, updatable = false)
  private String txHash;

  @Column(name = "idx", insertable = false, updatable = false)
  private long index;
}
