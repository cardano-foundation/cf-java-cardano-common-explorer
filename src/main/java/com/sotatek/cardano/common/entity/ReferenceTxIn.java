package com.sotatek.cardano.common.entity;

import com.sotatek.cardano.common.validation.TxIndex;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.hibernate.Hibernate;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

@Entity
@Table(name = "reference_tx_in", uniqueConstraints = {
    @UniqueConstraint(name = "unique_ref_txin",
        columnNames = {"tx_in_id", "tx_out_id", "tx_out_index"})
})
@Where(clause = "is_deleted is null or is_deleted = false")
@SQLDelete(sql = "update reference_tx_in set is_deleted = true where id = ?")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder(toBuilder = true)
public class ReferenceTxIn extends BaseEntity {

  @ManyToOne(fetch = FetchType.LAZY, optional = false)
  @OnDelete(action = OnDeleteAction.CASCADE)
  @JoinColumn(name = "tx_in_id", nullable = false,
      foreignKey = @ForeignKey(name = "reference_tx_in_tx_in_id_fkey"))
  @EqualsAndHashCode.Exclude
  private Tx txIn;

  @ManyToOne(fetch = FetchType.LAZY, optional = false)
  @OnDelete(action = OnDeleteAction.CASCADE)
  @JoinColumn(name = "tx_out_id", nullable = false,
      foreignKey = @ForeignKey(name = "reference_tx_in_tx_out_id_fkey"))
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
