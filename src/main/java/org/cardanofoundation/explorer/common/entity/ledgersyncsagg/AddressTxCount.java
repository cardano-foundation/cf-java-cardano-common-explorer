package org.cardanofoundation.explorer.common.entity.ledgersyncsagg;

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
@Table(name = "address_tx_count")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder(toBuilder = true)
public class AddressTxCount {
  @Id
  @Column(name = "address", nullable = false)
  String address;

  @Column(name = "tx_count")
  Long txCount;
}
