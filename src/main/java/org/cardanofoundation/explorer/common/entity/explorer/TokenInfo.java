package org.cardanofoundation.explorer.common.entity.explorer;

import java.math.BigInteger;

import jakarta.persistence.*;
import jakarta.validation.constraints.Digits;

import lombok.*;

@Entity
@Table(
    name = "token_info",
    uniqueConstraints = {
      @UniqueConstraint(
          name = "unique_token_info",
          columnNames = {"unit"})
    })
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TokenInfo {
  @Id
  @Column(name = "unit", nullable = false)
  private String unit;

  @Column(name = "number_of_holders")
  private Long numberOfHolders;

  @Column(name = "tx_count")
  private Long txCount;

  @Column(name = "total_volume", precision = 40)
  @Digits(integer = 40, fraction = 0)
  private BigInteger totalVolume;

  @Column(name = "volume_24h", precision = 40)
  @Digits(integer = 40, fraction = 0)
  private BigInteger volume24h;

  @Column(name = "updated_slot", nullable = false)
  private Long updatedSlot;

  @Column(name = "previous_number_of_holders")
  private Long previousNumberOfHolders;

  @Column(name = "previous_tx_count")
  private Long previousTxCount;

  @Column(name = "previous_total_volume", precision = 40)
  @Digits(integer = 40, fraction = 0)
  private BigInteger previousTotalVolume;

  @Column(name = "previous_volume_24h", precision = 40)
  @Digits(integer = 40, fraction = 0)
  private BigInteger previousVolume24h;

  @Column(name = "previous_slot", nullable = false)
  private Long previousSlot;
}
