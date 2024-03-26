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

import org.cardanofoundation.explorer.common.entity.validation.Word31Type;

@Entity
@Table(
    name = "ls_stake_deregistration",
    uniqueConstraints = {
      @UniqueConstraint(
          name = "unique_stake_deregistration",
          columnNames = {"tx_id", "cert_index"})
    })
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder(toBuilder = true)
public class LsStakeDeregistration extends BaseEntity {

  @ManyToOne(fetch = FetchType.LAZY, optional = false)
  @JoinColumn(
      name = "addr_id",
      nullable = false,
      foreignKey = @ForeignKey(value = ConstraintMode.NO_CONSTRAINT, name = "none"))
  @EqualsAndHashCode.Exclude
  private StakeAddress addr;

  @Column(name = "addr_id", updatable = false, insertable = false)
  private Long stakeAddressId;

  @Column(name = "cert_index", nullable = false)
  private Integer certIndex;

  @Column(name = "epoch_no", nullable = false)
  @Word31Type
  private Integer epochNo;

  @ManyToOne(fetch = FetchType.LAZY, optional = false)
  @JoinColumn(
      name = "tx_id",
      nullable = false,
      foreignKey = @ForeignKey(value = ConstraintMode.NO_CONSTRAINT, name = "none"))
  @EqualsAndHashCode.Exclude
  private Tx tx;

  @Column(name = "tx_id", updatable = false, insertable = false)
  private Long txId;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(
      name = "redeemer_id",
      foreignKey = @ForeignKey(value = ConstraintMode.NO_CONSTRAINT, name = "none"))
  @EqualsAndHashCode.Exclude
  private Redeemer redeemer;

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) {
      return false;
    }
    LsStakeDeregistration that = (LsStakeDeregistration) o;
    return id != null && Objects.equals(id, that.id);
  }

  @Override
  public int hashCode() {
    return getClass().hashCode();
  }
}
