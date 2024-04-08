package org.cardanofoundation.explorer.common.entity.ledgersync;

import java.util.UUID;

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

import org.cardanofoundation.explorer.common.entity.compositeKey.LatestVotingProcedureId;
import org.cardanofoundation.explorer.common.entity.enumeration.Vote;
import org.cardanofoundation.explorer.common.entity.enumeration.VoterType;

@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Entity
@Table(name = "latest_voting_procedure")
@IdClass(LatestVotingProcedureId.class)
public class LatestVotingProcedure extends BlockAwareEntity {
  @Column(name = "id", updatable = false, nullable = false)
  private UUID id;

  @Column(name = "tx_hash")
  private String txHash;

  @Column(name = "idx")
  private long index;

  @Embedded
  @AttributeOverrides({
    @AttributeOverride(
        name = "voter_hash",
        column = @Column(name = "voter_hash", insertable = false, updatable = false)),
    @AttributeOverride(
        name = "gov_action_tx_hash",
        column = @Column(name = "gov_action_tx_hash", insertable = false, updatable = false)),
    @AttributeOverride(
        name = "gov_action_index",
        column = @Column(name = "gov_action_index", insertable = false, updatable = false))
  })
  private LatestVotingProcedureId votingProcedureId;

  @Column(name = "slot")
  private Long slot;

  @Column(name = "voter_type")
  @Enumerated(EnumType.STRING)
  private VoterType voterType;

  @Id
  @Column(name = "voter_hash")
  private String voterHash;

  @Id
  @Column(name = "gov_action_tx_hash")
  private String govActionTxHash;

  @Id
  @Column(name = "gov_action_index")
  private Integer govActionIndex;

  @Column(name = "vote")
  private Vote vote;

  @Column(name = "anchor_url")
  private String anchorUrl;

  @Column(name = "anchor_hash")
  private String anchorHash;

  @Column(name = "epoch")
  private Integer epoch;

  @Column(name = "repeat_vote")
  private Boolean repeatVote;
}
