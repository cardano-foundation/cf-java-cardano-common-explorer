package org.cardanofoundation.explorer.consumercommon.explorer.entity;

import java.math.BigInteger;
import java.sql.Timestamp;

import jakarta.persistence.*;
import jakarta.validation.constraints.Digits;

import lombok.*;
import lombok.experimental.SuperBuilder;

import org.cardanofoundation.explorer.consumercommon.entity.BaseEntity;
import org.cardanofoundation.explorer.consumercommon.entity.MultiAsset;

@Entity
@Table(name = "token_info", uniqueConstraints = {
    @UniqueConstraint(name = "unique_token_info", columnNames = {"ident"})})
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder(toBuilder = true)
public class TokenInfo extends BaseEntity {

  @Column(name = "ident", nullable = false)
  private Long multiAssetId;

  @Column(name = "number_of_holders")
  private Long numberOfHolders;

  @Column(name = "volume_24h", precision = 40)
  @Digits(integer = 40, fraction = 0)
  private BigInteger volume24h;

  @Column(name = "block_no")
  private Long blockNo;

  @Column(name = "update_time")
  private Timestamp updateTime;
}
