package org.cardanofoundation.explorer.consumercommon.explorer.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import org.cardanofoundation.explorer.consumercommon.entity.BaseEntity;
import org.cardanofoundation.explorer.consumercommon.validation.Hash28Type;

@Entity
@Table(
    name = "verified_script",
    uniqueConstraints = {
      @UniqueConstraint(
          name = "unique_verified_script",
          columnNames = {"hash"})
    })
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder(toBuilder = true)
public class VerifiedScript extends BaseEntity {

  @Column(name = "hash", nullable = false, length = 64)
  @Hash28Type
  private String hash;

  // wip
  @Column(name = "json", length = 65535)
  private String json;
}
