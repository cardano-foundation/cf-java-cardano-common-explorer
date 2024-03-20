package org.cardanofoundation.explorer.common.entity.ledgersync;

import java.math.BigInteger;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import com.bloxbean.cardano.client.transaction.spec.cert.StakeCredType;

import org.cardanofoundation.explorer.common.entity.ledgersync.base.BlockAwareEntity;
import org.cardanofoundation.explorer.common.entity.ledgersync.compositeKey.DRepRegistrationId;
import org.cardanofoundation.explorer.common.entity.ledgersync.enumeration.DRepActionType;

@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Entity
@Table(name = "drep_registration")
@IdClass(DRepRegistrationId.class)
public class DRepRegistrationEntity extends BlockAwareEntity {
  @Id
  @Column(name = "tx_hash")
  private String txHash;

  @Id
  @Column(name = "cert_index")
  private long certIndex;

  @Column(name = "type")
  @Enumerated(EnumType.STRING)
  private DRepActionType type;

  @Column(name = "slot")
  private Long slot;

  @Column(name = "deposit")
  private BigInteger deposit;

  @Column(name = "drep_hash")
  private String drepHash;

  @Column(name = "drep_id")
  private String drepId;

  @Column(name = "anchor_url")
  private String anchorUrl;

  @Column(name = "anchor_hash")
  private String anchorHash;

  @Column(name = "cred_type")
  @Enumerated(EnumType.STRING)
  private StakeCredType credType;

  @Column(name = "epoch")
  private Integer epoch;
}
