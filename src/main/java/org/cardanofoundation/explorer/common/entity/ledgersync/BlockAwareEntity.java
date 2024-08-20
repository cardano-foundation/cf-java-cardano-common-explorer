package org.cardanofoundation.explorer.common.entity.ledgersync;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import org.hibernate.annotations.UpdateTimestamp;

@Data
@MappedSuperclass
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class BlockAwareEntity {
  @Column(name = "block")
  private Long blockNumber;

  @Column(name = "block_time")
  private Long blockTime;

  @UpdateTimestamp
  @Column(name = "update_datetime")
  private LocalDateTime updateDateTime;
}
