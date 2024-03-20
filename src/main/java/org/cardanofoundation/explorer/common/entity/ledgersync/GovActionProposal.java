package org.cardanofoundation.explorer.common.entity.ledgersync;

import java.math.BigInteger;

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

import com.fasterxml.jackson.databind.JsonNode;
import com.vladmihalcea.hibernate.type.json.JsonType;
import org.hibernate.annotations.Type;

import org.cardanofoundation.explorer.common.entity.ledgersync.base.BlockAwareEntity;
import org.cardanofoundation.explorer.common.entity.ledgersync.compositeKey.GovActionProposalId;
import org.cardanofoundation.explorer.common.entity.ledgersync.enumeration.GovActionType;

@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Entity
@Table(name = "gov_action_proposal")
@IdClass(GovActionProposalId.class)
public class GovActionProposal extends BlockAwareEntity {
  @Id
  @Column(name = "tx_hash")
  private String txHash;

  @Id
  @Column(name = "idx")
  private long index;

  @Column(name = "slot")
  private Long slot;

  @Column(name = "deposit")
  private BigInteger deposit;

  @Column(name = "return_address")
  private String returnAddress;

  @Column(name = "type")
  @Enumerated(EnumType.STRING)
  private GovActionType type;

  @Type(JsonType.class)
  @Column(columnDefinition = "json", name = "details")
  private JsonNode details;

  @Column(name = "anchor_url")
  private String anchorUrl;

  @Column(name = "anchor_hash")
  private String anchorHash;

  @Column(name = "epoch")
  private Integer epoch;
}