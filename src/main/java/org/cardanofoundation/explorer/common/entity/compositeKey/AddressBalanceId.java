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
public class AddressBalanceId implements Serializable {
  @Column(name = "address", insertable = false, updatable = false)
  private String address;

  @Column(name = "unit", insertable = false, updatable = false)
  private String unit;

  @Column(name = "slot", insertable = false, updatable = false)
  private Long slot;
}
