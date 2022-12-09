package com.sotatek.cardano.common.entity;

import com.sotatek.cardano.common.enumeration.converter.ByteConverter;
import com.sotatek.cardano.common.validation.Asset32Type;
import com.sotatek.cardano.common.validation.Hash28Type;
import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Digits;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Entity
@Table(name = "multi_asset", uniqueConstraints = {
    @UniqueConstraint(name = "unique_multi_asset",
        columnNames = {"policy", "name"})
})
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = false)
@SuperBuilder(toBuilder = true)
public class MultiAsset extends BaseEntity {

  @Column(name = "policy", nullable = false, length = 56)
  @Hash28Type
  private String policy;

  @Column(name = "name", nullable = false, length = 64)
  @Asset32Type
  @Convert(converter = ByteConverter.class)
  private String name;

  @Column(name = "fingerprint", nullable = false)
  private String fingerprint;

  @Column(name = "tx_count")
  private Long txCount;

  @Column(name = "supply", precision = 23)
  @Digits(integer = 23, fraction = 0)
  private BigDecimal supply;

}
