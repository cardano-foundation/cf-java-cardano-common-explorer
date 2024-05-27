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

import org.cardanofoundation.explorer.common.entity.enumeration.TokenAuthType;
import org.cardanofoundation.explorer.common.entity.ledgersync.BaseEntity;

@Entity
@Table(name = "token_auth")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder(toBuilder = true)
public class TokenAuth extends BaseEntity {

  @Column(name = "token")
  String token;

  @Column(name = "blacklist")
  Boolean blackList;

  @Column(name = "user_id")
  String userId;

  @Column(name = "type")
  @Enumerated(EnumType.STRING)
  TokenAuthType tokenAuthType;

  @Column(name = "created_at")
  private Timestamp createdAt;

  public TokenAuth(String token, String userId, TokenAuthType tokenAuthType) {
    this.blackList = false;
    this.token = token;
    this.userId = userId;
    this.tokenAuthType = tokenAuthType;
    this.createdAt = new Timestamp(System.currentTimeMillis());
  }
}
