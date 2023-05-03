package com.sotatek.cardano.common.entity;

import com.sotatek.cardano.common.validation.Word128Type;
import java.math.BigInteger;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
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

@Entity
@Table(name = "address_token")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder(toBuilder = true)
public class AddressToken extends BaseEntity {

  @ManyToOne(fetch = FetchType.LAZY, optional = false)
  @OnDelete(action = OnDeleteAction.CASCADE)
  @JoinColumn(name = "address_id", nullable = false,
      foreignKey = @ForeignKey(name = "address_token_address_id_fkey"))
  @EqualsAndHashCode.Exclude
  private Address address;

  @Column(name = "address_id", updatable = false, insertable = false)
  private Long addressId;

  @ManyToOne(fetch = FetchType.LAZY, optional = false)
  @OnDelete(action = OnDeleteAction.CASCADE)
  @JoinColumn(name = "tx_id", nullable = false,
      foreignKey = @ForeignKey(name = "address_token_tx_id_fkey"))
  @EqualsAndHashCode.Exclude
  private Tx tx;

  @ManyToOne(fetch = FetchType.LAZY, optional = false)
  @OnDelete(action = OnDeleteAction.CASCADE)
  @JoinColumn(name = "ident", nullable = false,
      foreignKey = @ForeignKey(name = "address_token_ident_fkey"))
  @EqualsAndHashCode.Exclude
  private MultiAsset multiAsset;

  @Column(name = "ident", updatable = false, insertable = false)
  private Long multiAssetId;

  @Column(name = "balance", nullable = false, precision = 39)
  @Word128Type
  @Digits(integer = 39, fraction = 0)
  private BigInteger balance;

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) {
      return false;
    }
    AddressToken that = (AddressToken) o;
    return id != null && Objects.equals(id, that.id);
  }

  @Override
  public int hashCode() {
    return getClass().hashCode();
  }
}
