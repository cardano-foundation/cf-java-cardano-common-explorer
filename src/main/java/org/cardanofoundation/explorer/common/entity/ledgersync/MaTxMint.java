package org.cardanofoundation.explorer.common.entity.ledgersync;

import java.math.BigInteger;
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
import jakarta.validation.constraints.Digits;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import org.hibernate.Hibernate;

import org.cardanofoundation.explorer.common.entity.validation.Int65Type;

@Entity
@Table(
    name = "ma_tx_mint",
    uniqueConstraints = {
      @UniqueConstraint(
          name = "unique_ma_tx_mint",
          columnNames = {"ident", "tx_id"})
    })
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder(toBuilder = true)
public class MaTxMint extends BaseEntity {

  @ManyToOne(fetch = FetchType.LAZY, optional = false)
  @JoinColumn(
      name = "ident",
      nullable = false,
      foreignKey = @ForeignKey(value = ConstraintMode.NO_CONSTRAINT, name = "none"))
  @EqualsAndHashCode.Exclude
  private MultiAsset ident;

  @Column(name = "ident", updatable = false, insertable = false)
  private Long identId;

  @Column(name = "quantity", nullable = false, precision = 20)
  @Int65Type
  @Digits(integer = 20, fraction = 0)
  private BigInteger quantity;

  @ManyToOne(fetch = FetchType.LAZY, optional = false)
  @JoinColumn(
      name = "tx_id",
      nullable = false,
      foreignKey = @ForeignKey(value = ConstraintMode.NO_CONSTRAINT, name = "none"))
  @EqualsAndHashCode.Exclude
  private Tx tx;

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) {
      return false;
    }
    MaTxMint maTxMint = (MaTxMint) o;
    return id != null && Objects.equals(id, maTxMint.id);
  }

  @Override
  public int hashCode() {
    return getClass().hashCode();
  }
}
