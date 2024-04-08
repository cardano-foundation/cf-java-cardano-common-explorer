package org.cardanofoundation.explorer.common.entity.ledgersync;

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

import org.cardanofoundation.explorer.common.entity.compositeKey.DelegationVoteId;

@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Entity
@Table(name = "delegation_vote")
@IdClass(DelegationVoteId.class)
public class DelegationVote extends BlockAwareEntity {
  @Id
  @Column(name = "tx_hash")
  private String txHash;

  @Id
  @Column(name = "cert_index")
  private long certIndex;

  @Column(name = "slot")
  private Long slot;

  @Column(name = "address")
  private String address;

  @Column(name = "drep_hash")
  private String drepHash;

  @Column(name = "drep_id")
  private String drepId;

  @Column(name = "credential")
  private String credential;

  @Column(name = "cred_type")
  @Enumerated(EnumType.STRING)
  private StakeCredType credType;

  @Column(name = "epoch")
  private Integer epoch;
}
