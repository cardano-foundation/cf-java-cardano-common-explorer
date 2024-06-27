package org.cardanofoundation.explorer.common.entity.ledgersync.aggregation;

import java.math.BigInteger;
import java.time.LocalDate;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.AttributeOverrides;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Digits;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import org.cardanofoundation.explorer.common.entity.compositeKey.AggAddressTokenId;
import org.cardanofoundation.explorer.common.entity.validation.Word128Type;

@Entity
@Table(name = "agg_address_token")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@IdClass(AggAddressTokenId.class)
public class AggregateAddressToken {

  @Id
  @Column(name = "ident")
  protected Long ident;

  @Column(name = "balance", nullable = false, precision = 39)
  @Word128Type
  private @Digits(integer = 39, fraction = 0) BigInteger balance;

  @Id
  @Column(name = "day")
  private LocalDate day;

  @Embedded
  @AttributeOverrides({
    @AttributeOverride(
        name = "ident",
        column = @Column(name = "ident", insertable = false, updatable = false)),
    @AttributeOverride(
        name = "day",
        column = @Column(name = "day", insertable = false, updatable = false)),
  })
  private AggAddressTokenId id;
}
