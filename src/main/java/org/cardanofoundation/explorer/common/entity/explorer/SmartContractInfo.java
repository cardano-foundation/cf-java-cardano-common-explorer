package org.cardanofoundation.explorer.common.entity.explorer;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import org.cardanofoundation.explorer.common.entity.enumeration.ScriptType;
import org.cardanofoundation.explorer.common.entity.ledgersync.BaseEntity;
import org.cardanofoundation.explorer.common.entity.validation.Hash28Type;

@Entity
@Table(
    name = "smart_contract_info",
    uniqueConstraints = {
      @UniqueConstraint(
          name = "smart_contract_info",
          columnNames = {"script_hash"})
    })
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder(toBuilder = true)
public class SmartContractInfo extends BaseEntity {

  @Column(name = "script_hash", nullable = false, length = 64)
  @Hash28Type
  private String scriptHash;

  @Column(name = "type", nullable = false)
  private ScriptType type;

  @Column(name = "tx_count")
  private Long txCount;

  @Column(name = "is_script_reward")
  private Boolean isScriptReward;

  @Column(name = "is_script_cert")
  private Boolean isScriptCert;

  @Column(name = "is_script_spend")
  private Boolean isScriptSpend;

  @Column(name = "is_script_mint")
  private Boolean isScriptMint;

  @Column(name = "is_script_vote")
  private Boolean isScriptVote;

  @Column(name = "is_script_propose")
  private Boolean isScriptPropose;
}
