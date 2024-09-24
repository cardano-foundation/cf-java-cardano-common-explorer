package org.cardanofoundation.explorer.common.entity.ledgersync;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import lombok.*;

@Entity
@Table(name = "token_tx_count")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TokenTxCount {
  @Id
  @Column(name = "unit", nullable = false)
  String unit;

  @Column(name = "tx_count")
  Long txCount;

  @Column(name = "updated_slot")
  Long updatedSlot;

  @Column(name = "previous_tx_count")
  Long previousTxCount;

  @Column(name = "previous_slot")
  Long previousSlot;

  @Column(name = "is_calculated_in_incremental_mode")
  Boolean isCalculatedInIncrementalMode;

  public TokenTxCount(String unit, Long txCount) {
    this.unit = unit;
    this.txCount = txCount;
  }
}
