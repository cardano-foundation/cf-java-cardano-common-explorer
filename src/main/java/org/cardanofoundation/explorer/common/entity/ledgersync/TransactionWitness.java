package org.cardanofoundation.explorer.common.entity.ledgersync;

import jakarta.persistence.*;

import lombok.*;

import com.fasterxml.jackson.databind.JsonNode;
import com.vladmihalcea.hibernate.type.json.JsonType;
import org.hibernate.annotations.Type;

import org.cardanofoundation.explorer.common.entity.enumeration.TransactionWitnessType;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "transaction_witness")
@Getter
@Setter
@IdClass(TransactionWitnessId.class)
public class TransactionWitness {
  @Id
  @Column(name = "tx_hash")
  private String txHash;

  @Id
  @Column(name = "idx")
  private Integer index;

  @Column(name = "pub_key")
  private String pubKey;

  @Column(name = "signature")
  private String signature;

  @Column(name = "pub_keyhash")
  private String pubKeyhash;

  @Column(name = "type")
  @Enumerated(EnumType.STRING)
  private TransactionWitnessType type;

  @Type(JsonType.class)
  @Column(name = "additional_data", columnDefinition = "jsonb")
  private JsonNode additionalData;

  @Column(name = "slot")
  private Long slot;
}
