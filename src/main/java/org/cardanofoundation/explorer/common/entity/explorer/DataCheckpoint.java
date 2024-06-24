package org.cardanofoundation.explorer.common.entity.explorer;

import java.sql.Timestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import org.cardanofoundation.explorer.common.entity.enumeration.DataCheckpointType;
import org.cardanofoundation.explorer.common.entity.ledgersync.BaseEntity;

@Entity
@Table(name = "data_checkpoint")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder(toBuilder = true)
public class DataCheckpoint extends BaseEntity {

  @Column(name = "block_no")
  private Long blockNo;

  @Column(name = "slot_no")
  private Long slotNo;

  @Column(name = "type")
  @Enumerated(EnumType.STRING)
  private DataCheckpointType type;

  @Column(name = "update_time")
  private Timestamp updateTime;
}
