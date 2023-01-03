package com.sotatek.cardano.common.entity;

import com.sotatek.cardano.common.validation.Int65Type;
import java.math.BigDecimal;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Digits;
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
@Table(name = "ma_tx_mint", uniqueConstraints = {
    @UniqueConstraint(name = "unique_ma_tx_mint",
        columnNames = {"ident", "tx_id"})
})
@Where(clause = "is_deleted is null or is_deleted = false")
@SQLDelete(sql = "update ma_tx_mint set is_deleted = true where id = ?")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder(toBuilder = true)
public class MaTxMint extends BaseEntity {

  @ManyToOne(fetch = FetchType.LAZY, optional = false)
  @OnDelete(action = OnDeleteAction.CASCADE)
  @JoinColumn(name = "ident", nullable = false,
      foreignKey = @ForeignKey(name = "ma_tx_mint_ident_fkey"))
  @EqualsAndHashCode.Exclude
  private MultiAsset ident;

  @Column(name = "quantity", nullable = false, precision = 20)
  @Int65Type
  @Digits(integer = 20, fraction = 0)
  private BigDecimal quantity;

  @ManyToOne(fetch = FetchType.LAZY, optional = false)
  @OnDelete(action = OnDeleteAction.CASCADE)
  @JoinColumn(name = "tx_id", nullable = false,
      foreignKey = @ForeignKey(name = "ma_tx_mint_tx_id_fkey"))
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
