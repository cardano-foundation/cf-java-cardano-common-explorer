package org.cardanofoundation.explorer.common.entity.ledgersyncsagg;

import java.math.BigInteger;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Entity
@Table(name = "top_address_balance")
public class TopAddressBalance {
  @Id
  @Column(name = "address")
  private String address;

  @Column(name = "slot")
  private Long slot;

  @Column(name = "quantity")
  private BigInteger quantity;
}
