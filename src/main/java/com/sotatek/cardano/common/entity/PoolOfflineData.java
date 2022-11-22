package com.sotatek.cardano.common.entity;

import com.sotatek.cardano.common.validation.Hash32Type;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.hibernate.annotations.Type;

@Entity
@Table(name = "pool_offline_data", uniqueConstraints = {
    @UniqueConstraint(name = "unique_pool_offline_data",
        columnNames = {"pool_id", "hash"})
})
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = false)
@SuperBuilder(toBuilder = true)
public class PoolOfflineData extends BaseEntity {

  @ManyToOne(fetch = FetchType.LAZY, optional = false)
  @OnDelete(action = OnDeleteAction.CASCADE)
  @JoinColumn(name = "pool_id", nullable = false,
      foreignKey = @ForeignKey(name = "pool_offline_data_pool_id_fkey"))
  @EqualsAndHashCode.Exclude
  private PoolHash pool;

  @Column(name = "ticker_name", nullable = false)
  private String tickerName;

  @Column(name = "hash", nullable = false, length = 64)
  @Hash32Type
  private String hash;

  @Column(name = "json", nullable = false, length = 65535)
  private String json;

  @Column(name = "bytes", nullable = false)
  private byte[] bytes;

  @ManyToOne(fetch = FetchType.LAZY, optional = false)
  @OnDelete(action = OnDeleteAction.CASCADE)
  @JoinColumn(name = "pmr_id", nullable = false,
      foreignKey = @ForeignKey(name = "pool_offline_data_pmr_id_fkey"))
  @EqualsAndHashCode.Exclude
  private PoolMetadataRef poolMetadataRef;

}
