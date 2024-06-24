package org.cardanofoundation.explorer.common.entity.explorer;

import java.sql.Timestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import org.cardanofoundation.explorer.common.entity.ledgersync.BaseEntity;

@Entity
@Table(name = "user_role")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder(toBuilder = true)
public class UserRole extends BaseEntity {
  @Column(name = "user_id")
  String userId;

  @Column(name = "role_id")
  String roleId;

  @Column(name = "created_at")
  private Timestamp createdAt;

  public UserRole(String userId, String roleId) {
    this.userId = userId;
    this.roleId = roleId;
    this.createdAt = new Timestamp(System.currentTimeMillis());
  }
}
