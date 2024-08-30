package org.cardanofoundation.explorer.common.entity.ledgersyncsagg;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import lombok.*;

@Entity
@Table(name = "stake_address_tx_count")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StakeAddressTxCount {
  @Id
  @Column(name = "stake_address", nullable = false)
  String stakeAddress;

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

  public StakeAddressTxCount(String stakeAddress, Long txCount){
    this.stakeAddress = stakeAddress;
    this.txCount = txCount;
  }
}
