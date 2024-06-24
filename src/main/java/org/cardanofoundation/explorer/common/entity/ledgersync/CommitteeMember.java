package org.cardanofoundation.explorer.common.entity.ledgersync;

import java.sql.Timestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import com.bloxbean.cardano.client.transaction.spec.cert.StakeCredType;

@Entity
@Table(name = "committee_member")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CommitteeMember {

  @Id
  @Column(name = "hash", nullable = false)
  private String hash;

  @Column(name = "cred_type")
  @Enumerated(EnumType.STRING)
  private StakeCredType credType;

  @Column(name = "expired_epoch")
  private Integer expiredEpoch;

  @Column(name = "slot")
  private Long slot;

  @Column(name = "update_datetime")
  Timestamp updateDatetime;
}
