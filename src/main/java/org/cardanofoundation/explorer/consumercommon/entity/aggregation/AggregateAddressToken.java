package org.cardanofoundation.explorer.consumercommon.entity.aggregation;

import java.math.BigInteger;
import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Digits;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import org.cardanofoundation.explorer.consumercommon.entity.BaseEntity;
import org.cardanofoundation.explorer.consumercommon.validation.Word128Type;

@Entity
@Table(name = "agg_address_token")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AggregateAddressToken extends BaseEntity {

  @Column(name = "ident")
  protected Long ident;

  @Column(name = "balance", nullable = false, precision = 39)
  @Word128Type
  private @Digits(integer = 39, fraction = 0) BigInteger balance;

  @Column(name = "day")
  private LocalDate day;
}
