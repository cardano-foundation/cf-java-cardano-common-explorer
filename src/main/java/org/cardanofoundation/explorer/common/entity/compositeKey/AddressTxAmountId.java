package org.cardanofoundation.explorer.common.entity.compositeKey;

import java.io.Serializable;

import jakarta.persistence.Column;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Builder
public class AddressTxAmountId implements Serializable {
  @Column(name = "address")
  private String address;

  @Column(name = "unit")
  private String unit;

  @Column(name = "tx_hash")
  private String txHash;
}
