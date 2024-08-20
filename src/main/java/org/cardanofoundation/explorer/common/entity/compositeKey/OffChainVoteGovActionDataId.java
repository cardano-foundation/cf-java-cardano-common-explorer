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
public class OffChainVoteGovActionDataId implements Serializable {
  @Column(name = "anchor_url", insertable = false, updatable = false)
  private String anchorUrl;

  @Column(name = "anchor_hash", insertable = false, updatable = false)
  private String anchorHash;
}
