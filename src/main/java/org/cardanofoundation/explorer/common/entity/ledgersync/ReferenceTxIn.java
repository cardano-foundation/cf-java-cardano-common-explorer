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
import jakarta.persistence.UniqueConstraint;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import org.hibernate.Hibernate;

import org.cardanofoundation.explorer.common.entity.validation.TxIndex;

@Entity
@Table(
    name = "reference_tx_in",
    uniqueConstraints = {
      @UniqueConstraint(
          name = "unique_ref_txin",
          columnNames = {"tx_in_id", "tx_out_id", "tx_out_index"})
    })
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder(toBuilder = true)
public class ReferenceTxIn extends BaseEntity {

  @ManyToOne(fetch = FetchType.LAZY, optional = false)
  @JoinColumn(
      name = "tx_in_id",
      nullable = false,
      foreignKey = @ForeignKey(value = ConstraintMode.NO_CONSTRAINT, name = "none"))
  @EqualsAndHashCode.Exclude
  private Tx txIn;

  @ManyToOne(fetch = FetchType.LAZY, optional = false)
  @JoinColumn(
      name = "tx_out_id",
      nullable = false,
      foreignKey = @ForeignKey(value = ConstraintMode.NO_CONSTRAINT, name = "none"))
  @EqualsAndHashCode.Exclude
  private Tx txOut;

  @Column(name = "tx_out_index", nullable = false)
  @TxIndex
  private Short txOutIndex;

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) {
      return false;
    }
    ReferenceTxIn that = (ReferenceTxIn) o;
    return id != null && Objects.equals(id, that.id);
  }

  @Override
  public int hashCode() {
    return getClass().hashCode();
  }
}
