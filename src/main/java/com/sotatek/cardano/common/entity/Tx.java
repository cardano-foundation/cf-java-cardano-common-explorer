package com.sotatek.cardano.common.entity;

import com.sotatek.cardano.common.validation.Hash32Type;
import com.sotatek.cardano.common.validation.Lovelace;
import com.sotatek.cardano.common.validation.Word31Type;
import com.sotatek.cardano.common.validation.Word64Type;
import java.math.BigDecimal;
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
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name = "tx", uniqueConstraints = {
    @UniqueConstraint(name = "unique_tx",
        columnNames = {"hash"}
    )
})
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = false)
@SuperBuilder(toBuilder = true)
public class Tx extends BaseEntity {

  @Column(name = "hash", nullable = false, length = 64)
  @Hash32Type
  private String hash;

  @ManyToOne(fetch = FetchType.LAZY, optional = false)
  @OnDelete(action = OnDeleteAction.CASCADE)
  @JoinColumn(name = "block_id", nullable = false,
      foreignKey = @ForeignKey(name = "tx_block_id_fkey"))
  @EqualsAndHashCode.Exclude
  private Block block;

  @Column(name = "block_index")
  @Word31Type
  private Long blockIndex;

  @Column(name = "out_sum", precision = 20)
  @Lovelace
  @Digits(integer = 20, fraction = 0)
  private BigDecimal outSum;

  @Column(name = "fee", precision = 20)
  @Lovelace
  @Digits(integer = 20, fraction = 0)
  private BigDecimal fee;

  @Column(name = "deposit")
  private Long deposit;

  @Column(name = "size")
  @Word31Type
  private Integer size;

  @Column(name = "invalid_before", precision = 20)
  @Word64Type
  @Digits(integer = 20, fraction = 0)
  private BigDecimal invalidBefore;

  @Column(name = "invalid_hereafter", precision = 20)
  @Word64Type
  @Digits(integer = 20, fraction = 0)
  private BigDecimal invalidHereafter;

  @Column(name = "valid_contract")
  private Boolean validContract;

  @Column(name = "script_size")
  @Word31Type
  private Integer scriptSize;

}
