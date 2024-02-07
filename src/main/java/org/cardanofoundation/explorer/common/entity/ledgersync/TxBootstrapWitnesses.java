package org.cardanofoundation.explorer.common.entity.ledgersync;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.ConstraintMode;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import org.hibernate.Hibernate;

@Entity
@Table(name = "tx_bootstrap_witnesses")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder(toBuilder = true)
public class TxBootstrapWitnesses extends BaseEntity {
  @ManyToOne(fetch = FetchType.LAZY, optional = false)
  @JoinColumn(
      name = "tx_id",
      nullable = false,
      foreignKey = @ForeignKey(value = ConstraintMode.NO_CONSTRAINT, name = "none"))
  @EqualsAndHashCode.Exclude
  private Tx tx;

  @Column(name = "public_key", nullable = false)
  private String publicKey;

  @Column(name = "signature", nullable = false)
  private String signature;

  @Column(name = "chain_code", nullable = false)
  private String chainCode;

  @Column(name = "attributes", nullable = false)
  private String attributes;

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) {
      return false;
    }
    TxBootstrapWitnesses txOut = (TxBootstrapWitnesses) o;
    return id != null && Objects.equals(id, txOut.id);
  }

  @Override
  public int hashCode() {
    return getClass().hashCode();
  }
}
