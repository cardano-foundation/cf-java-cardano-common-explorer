package org.cardanofoundation.explorer.common.entity.ledgersync;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Entity
@Table(name = "committee_info")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder(toBuilder = true)
public class CommitteeInfo {
  @Id
  @Column(name = "hot_key", nullable = false)
  String hotKey;

  @Column(name = "created_at")
  Long createdAt;
}
