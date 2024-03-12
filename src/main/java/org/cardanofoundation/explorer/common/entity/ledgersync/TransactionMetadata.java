package org.cardanofoundation.explorer.common.entity.ledgersync;

import java.time.LocalDateTime;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name = "transaction_metadata")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder(toBuilder = true)
@EqualsAndHashCode
public class TransactionMetadata {
  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  @Column(name = "id", updatable = false, nullable = false)
  private UUID id;

  @Column(name = "slot")
  private Long slot;

  @Column(name = "label")
  private String label;

  @Column(name = "body", columnDefinition = "TEXT")
  private String body;

  @Column(name = "cbor", columnDefinition = "TEXT")
  private String cbor;

  @Column(name = "tx_hash", nullable = false, length = 64)
  private String txHash;

  @Column(name = "block")
  private Long blockNumber;

  @Column(name = "block_time")
  private Long blockTime;

  @UpdateTimestamp
  @Column(name = "update_datetime")
  private LocalDateTime updateDateTime;
}
