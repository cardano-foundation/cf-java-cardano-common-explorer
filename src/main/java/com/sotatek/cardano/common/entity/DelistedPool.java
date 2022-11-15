package com.sotatek.cardano.common.entity;

import com.sotatek.cardano.common.validation.Hash28Type;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Entity
@Table(name = "delisted_pool", uniqueConstraints = {
    @UniqueConstraint(name = "unique_delisted_pool",
        columnNames = {"hash_raw"})
})
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = false)
@SuperBuilder(toBuilder = true)
public class DelistedPool extends BaseEntity {

  @Column(name = "hash_raw", nullable = false, length = 56)
  @Hash28Type
  private String hashRaw;


}
