package org.cardanofoundation.explorer.common.entity.ledgersync;

import java.util.UUID;

import jakarta.persistence.Column;
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

import org.cardanofoundation.explorer.common.entity.ledgersync.base.BlockAwareEntity;
import org.cardanofoundation.explorer.common.entity.ledgersync.compositeKey.VotingProcedureId;
import org.cardanofoundation.explorer.common.entity.ledgersync.enumeration.Vote;
import org.cardanofoundation.explorer.common.entity.ledgersync.enumeration.VoterType;

@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Entity
@Table(name = "voting_procedure")
@IdClass(VotingProcedureId.class)
public class VotingProcedure extends BlockAwareEntity {
  @Column(name = "id", updatable = false, nullable = false)
  private UUID id;

  @Id
  @Column(name = "tx_hash")
  private String txHash;

  @Column(name = "idx")
  private long index;

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
  @Enumerated(EnumType.STRING)
  private Vote vote;

  @Column(name = "anchor_url")
  private String anchorUrl;

  @Column(name = "anchor_hash")
  private String anchorHash;

  @Column(name = "epoch")
  private Integer epoch;
}