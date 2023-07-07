package org.cardanofoundation.explorer.consumercommon.entity;

import java.sql.Timestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Entity
@Table(name = "token_info_checkpoint")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder(toBuilder = true)
public class TokenInfoCheckpoint extends BaseEntity {

  @Column(name = "block_no")
  private Long blockNo;

  @Column(name = "update_time")
  private Timestamp updateTime;
}
