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
    name = "native_script_info",
    uniqueConstraints = {
      @UniqueConstraint(
          name = "native_script_info",
          columnNames = {"script_hash"})
    })
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder(toBuilder = true)
public class NativeScriptInfo extends BaseEntity {

  @Column(name = "script_hash", nullable = false, length = 64)
  @Hash28Type
  private String scriptHash;

  @Column(name = "type", nullable = false)
  private ScriptType type;

  @Column(name = "number_of_tokens", nullable = false)
  private Long numberOfTokens = 0L;

  @Column(name = "number_of_asset_holders", nullable = false)
  private Long numberOfAssetHolders = 0L;

  @Column(name = "after_slot")
  private Long afterSlot;

  @Column(name = "before_slot")
  private Long beforeSlot;

  @Column(name = "number_sig", nullable = false)
  private Long numberSig = 0L;
}
