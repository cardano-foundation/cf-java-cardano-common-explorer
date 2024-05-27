package org.cardanofoundation.explorer.common.entity.ledgersync;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import org.hibernate.annotations.UpdateTimestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Entity
@Table(name = "address")
public class Address extends BaseEntity {
  @Column(name = "address")
  private String address;

  // Only set if address doesn't fit in ownerAddr field. Required for few Byron Era addr
  @Column(name = "addr_full")
  private String addrFull;

  @Column(name = "payment_credential")
  private String paymentCredential;

  @Column(name = "stake_address")
  private String stakeAddress;

  @UpdateTimestamp
  @Column(name = "update_datetime")
  private LocalDateTime updateDateTime;

  @Column(name = "stake_credential")
  private String stakeCredential;
}
