package org.cardanofoundation.explorer.common.entity.ledgersync;

import jakarta.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import org.cardanofoundation.explorer.common.entity.compositeKey.OffChainVoteGovActionDataId;

@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Entity
@Table(name = "off_chain_vote_gov_action_data")
@IdClass(OffChainVoteGovActionDataId.class)
public class OffChainVoteGovActionData {

  @Id
  @Column(name = "anchor_url")
  private String anchorUrl;

  @Id
  @Column(name = "anchor_hash")
  private String anchorHash;

  @Embedded
  @AttributeOverrides({
    @AttributeOverride(
        name = "anchor_url",
        column = @Column(name = "anchor_url", insertable = false, updatable = false)),
    @AttributeOverride(
        name = "anchor_hash",
        column = @Column(name = "anchor_hash", insertable = false, updatable = false))
  })
  private OffChainVoteGovActionDataId id;

  @Column(name = "raw_data")
  private String rawData;

  @Column(name = "title")
  private String title;

  @Column(name = "motivation")
  private String motivation;

  @Column(name = "abstract")
  private String abstractData;

  @Column(name = "rationale")
  private String rationale;
}
