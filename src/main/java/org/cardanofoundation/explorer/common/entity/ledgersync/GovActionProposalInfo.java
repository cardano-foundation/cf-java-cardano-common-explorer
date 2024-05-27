package org.cardanofoundation.explorer.common.entity.ledgersync;

import java.math.BigInteger;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.AttributeOverrides;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import org.cardanofoundation.explorer.common.entity.compositeKey.GovActionProposalId;
import org.cardanofoundation.explorer.common.entity.enumeration.GovActionStatus;
import org.cardanofoundation.explorer.common.entity.enumeration.GovActionType;

@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Entity
@Table(name = "gov_action_proposal_info")
@IdClass(GovActionProposalId.class)
public class GovActionProposalInfo {

  @Id
  @Column(name = "tx_hash")
  private String txHash;

  @Id
  @Column(name = "idx")
  private long index;

  @Embedded
  @AttributeOverrides({
    @AttributeOverride(
        name = "tx_hash",
        column = @Column(name = "tx_hash", insertable = false, updatable = false)),
    @AttributeOverride(
        name = "idx",
        column = @Column(name = "idx", insertable = false, updatable = false))
  })
  private GovActionProposalId id;

  @Column(name = "expired_epoch")
  private Integer expiredEpoch;

  @Column(name = "status")
  @Enumerated(EnumType.STRING)
  GovActionStatus status;

  @Column(name = "voting_power")
  BigInteger votingPower;

  @Column(name = "index_type")
  private BigInteger indexType;

  @Column(name = "type")
  @Enumerated(EnumType.STRING)
  private GovActionType type;

  @Column(name = "block_time")
  private Long blockTime;

  @Column(name = "spo_allowed_vote")
  private Boolean spoAllowedVote;
}
