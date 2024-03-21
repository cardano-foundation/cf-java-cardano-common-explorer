package org.cardanofoundation.explorer.common.entity.explorer;

import java.math.BigInteger;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import org.cardanofoundation.explorer.common.entity.enumeration.DRepStatus;
import org.cardanofoundation.explorer.common.entity.enumeration.DRepType;
import org.cardanofoundation.explorer.common.entity.ledgersync.BaseEntity;

@Entity
@Table(name = "drep_info")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder(toBuilder = true)
public class DRepInfo extends BaseEntity {

  @Column(name = "drep_hash", nullable = false, length = 56)
  private String drepHash;

  @Column(name = "drep_id", nullable = false)
  private String drepId;

  @Column(name = "anchor_url")
  private String anchorUrl;

  @Column(name = "anchor_hash")
  private String anchorHash;

  @Column(name = "delegators")
  private Integer delegators;

  @Column(name = "active_vote_stake")
  private BigInteger activeVoteStake;

  @Column(name = "live_stake")
  private BigInteger liveStake;

  @Column(name = "created_at")
  private Long createdAt;

  @Column(name = "status", nullable = false)
  @Enumerated(EnumType.STRING)
  private DRepStatus status;

  @Column(name = "type", nullable = false)
  @Enumerated(EnumType.STRING)
  private DRepType type;
}
