package org.cardanofoundation.explorer.consumercommon.entity;

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
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import org.hibernate.Hibernate;

import org.cardanofoundation.explorer.consumercommon.validation.Word31Type;

@Entity
@Table(
    name = "pool_retire",
    uniqueConstraints = {
      @UniqueConstraint(
          name = "unique_pool_retiring",
          columnNames = {"announced_tx_id", "cert_index"})
    })
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder(toBuilder = true)
public class PoolRetire extends BaseEntity {

  @ManyToOne(fetch = FetchType.LAZY, optional = false)
  @JoinColumn(
      name = "hash_id",
      nullable = false,
      foreignKey = @ForeignKey(value = ConstraintMode.NO_CONSTRAINT, name = "none"))
  private PoolHash poolHash;

  @Column(name = "hash_id", updatable = false, insertable = false)
  private Long poolHashId;

  @Column(name = "cert_index", nullable = false)
  private Integer certIndex;

  @ManyToOne(fetch = FetchType.LAZY, optional = false)
  @JoinColumn(
      name = "announced_tx_id",
      nullable = false,
      foreignKey = @ForeignKey(value = ConstraintMode.NO_CONSTRAINT, name = "none"))
  private Tx announcedTx;

  @Column(name = "announced_tx_id", updatable = false, insertable = false)
  private Long announcedTxId;

  @Column(name = "retiring_epoch", nullable = false)
  @Word31Type
  private Integer retiringEpoch;

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) {
      return false;
    }
    PoolRetire that = (PoolRetire) o;
    return id != null && Objects.equals(id, that.id);
  }

  @Override
  public int hashCode() {
    return getClass().hashCode();
  }
}
