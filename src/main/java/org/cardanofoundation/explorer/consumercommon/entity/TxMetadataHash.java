package org.cardanofoundation.explorer.consumercommon.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Entity
@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tx_metadata_hash")
public class TxMetadataHash extends BaseEntity {

  @Column(name = "hash", nullable = false, length = 64)
  private String hash;

}
