package org.cardanofoundation.explorer.common.entity.compositeKey;

import java.time.LocalDate;

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
public class AggAddressTokenId {
  @Column(name = "ident", insertable = false, updatable = false)
  protected Long ident;

  @Column(name = "day", insertable = false, updatable = false)
  private LocalDate day;
}
