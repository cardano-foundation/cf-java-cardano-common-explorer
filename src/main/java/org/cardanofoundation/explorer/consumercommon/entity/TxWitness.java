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

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import com.vladmihalcea.hibernate.type.array.IntArrayType;
import org.hibernate.Hibernate;
import org.hibernate.annotations.Type;

@Entity
@Table(name = "tx_witnesses")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder(toBuilder = true)
public class TxWitness extends BaseEntity {

  @ManyToOne(fetch = FetchType.LAZY, optional = false)
  @JoinColumn(name = "tx_id", nullable = false,
      foreignKey = @ForeignKey(value = ConstraintMode.NO_CONSTRAINT, name = "none"))
  @EqualsAndHashCode.Exclude
  private Tx tx;

  @Column(name = "key", nullable = false)
  private String key;

  @Column(name = "signature", nullable = false)
  private String signature;

  @Column(name = "index_arr", columnDefinition = "int[]")
  @Type(value = IntArrayType.class)
  private Integer[] indexArr;

  @Column(name = "index_arr_size")
  private Integer indexArrSize;

  @Column(name = "type")
  private String type;

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) {
      return false;
    }
    TxWitness txOut = (TxWitness) o;
    return id != null && Objects.equals(id, txOut.id);
  }

  @Override
  public int hashCode() {
    return getClass().hashCode();
  }

}
