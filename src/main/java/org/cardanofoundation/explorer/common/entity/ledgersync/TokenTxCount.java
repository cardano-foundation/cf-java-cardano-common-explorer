package org.cardanofoundation.explorer.common.entity.ledgersync;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Entity
@Table(name = "token_tx_count")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder(toBuilder = true)
public class TokenTxCount {
  @Id
  @Column(name = "unit", nullable = false)
  String unit;

  @Column(name = "tx_count")
  Long txCount;
}
