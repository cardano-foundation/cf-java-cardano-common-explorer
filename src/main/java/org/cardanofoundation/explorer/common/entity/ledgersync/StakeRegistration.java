package org.cardanofoundation.explorer.common.entity.ledgersync;

import java.time.LocalDateTime;

import jakarta.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import com.bloxbean.cardano.client.transaction.spec.cert.CertificateType;
import org.hibernate.annotations.UpdateTimestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Entity
@Table(
    name = "stake_registration",
    uniqueConstraints = {
      @UniqueConstraint(
          name = "unique_stake_registration",
          columnNames = {"tx_hash", "cert_index"})
    })
@IdClass(StakeRegistrationId.class)
public class StakeRegistration {

  @Id
  @Column(name = "tx_hash")
  private String txHash;

  @Id
  @Column(name = "cert_index")
  private long certIndex;

  @Column(name = "credential")
  private String credential;

  @Column(name = "type")
  @Enumerated(EnumType.STRING)
  private CertificateType type;

  @Column(name = "address")
  private String address;

  @Column(name = "epoch")
  private Integer epoch;

  @Column(name = "slot")
  private Long slot;

  @Column(name = "block_hash")
  private String blockHash;

  @Column(name = "block")
  private Long blockNumber;

  @Column(name = "block_time")
  private Long blockTime;

  @UpdateTimestamp
  @Column(name = "update_datetime")
  private LocalDateTime updateDateTime;
}
