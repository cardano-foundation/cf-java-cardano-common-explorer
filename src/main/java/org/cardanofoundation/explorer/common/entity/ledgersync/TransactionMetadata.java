package org.cardanofoundation.explorer.common.entity.ledgersync;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import org.hibernate.Hibernate;

@Entity
@Table(
    name = "transaction_metadata",
    uniqueConstraints = {
      @UniqueConstraint(
          name = "unique_tx_metadata",
          columnNames = {"label", "tx_hash"})
    })
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder(toBuilder = true)
public class TransactionMetadata extends BaseEntity {

  @Column(name = "label")
  private String label;

  @Column(name = "body", columnDefinition = "TEXT")
  private String body;

  @Column(name = "cbor", columnDefinition = "TEXT")
  private String cbor;

  @Column(name = "tx_hash", nullable = false, length = 64)
  private String txHash;

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) {
      return false;
    }
    TransactionMetadata that = (TransactionMetadata) o;
    return id != null && Objects.equals(id, that.id);
  }

  @Override
  public int hashCode() {
    return getClass().hashCode();
  }
}
