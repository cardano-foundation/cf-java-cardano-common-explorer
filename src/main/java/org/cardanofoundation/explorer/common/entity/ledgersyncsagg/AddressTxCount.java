package org.cardanofoundation.explorer.common.entity.ledgersyncsagg;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import lombok.*;

@Entity
@Table(name = "address_tx_count")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AddressTxCount {
  @Id
  @Column(name = "address", nullable = false)
  String address;

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

  public AddressTxCount(String address, Long txCount) {
    this.address = address;
    this.txCount = txCount;
  }
}
