package org.cardanofoundation.explorer.common.entity.ledgersync;

import java.sql.Timestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Entity
@Table(name = "tx_count")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder(toBuilder = true)
public class TxCount extends BaseEntity{

  @Column(name = "address", nullable = false)
  String address;
  @Column(name = "count", nullable = false)
  Long count;
  @Column(name = "lastUpdated", nullable = false)
  Timestamp lastUpdated;
}
