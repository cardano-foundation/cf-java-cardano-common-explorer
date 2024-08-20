package org.cardanofoundation.explorer.common.entity.ledgersync;

import java.sql.Timestamp;

import jakarta.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import org.cardanofoundation.explorer.common.entity.compositeKey.OffChainVoteFetchErrorId;

@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Entity
@Table(name = "off_chain_vote_fetch_error")
@IdClass(OffChainVoteFetchErrorId.class)
public class OffChainVoteFetchError {
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
  private OffChainVoteFetchErrorId id;

  @Column(name = "fetch_error")
  private String fetchError;

  @Column(name = "fetch_time")
  private Timestamp fetchTime;

  @Column(name = "retry_count")
  private Integer retryCount;
}
