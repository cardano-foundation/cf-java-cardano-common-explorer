package org.cardanofoundation.explorer.common.entity.ledgersync;

import java.math.BigInteger;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.AttributeOverrides;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import org.cardanofoundation.explorer.common.entity.enumeration.GovActionStatus;
import org.cardanofoundation.explorer.common.entity.ledgersync.compositeKey.GovActionProposalId;

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

  @Column(name = "expiredEpoch")
  private Integer expiredEpoch;

  @Column(name = "status")
  GovActionStatus status;

  @Column(name = "voting_power")
  BigInteger votingPower;
}
