package com.sotatek.cardano.common.entity;

import com.sotatek.cardano.common.validation.Hash32Type;
import com.sotatek.cardano.common.validation.Lovelace;
import com.sotatek.cardano.common.validation.Word31Type;
import com.sotatek.cardano.common.validation.Word64Type;
import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Digits;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.hibernate.Hibernate;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

@Entity
@Table(name = "tx", uniqueConstraints = {
    @UniqueConstraint(name = "unique_tx",
        columnNames = {"hash"}
    )
})
@Where(clause = "is_deleted is null or is_deleted = false")
@SQLDelete(sql = "update tx set is_deleted = true where id = ?")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = false)
@SuperBuilder(toBuilder = true)
public class Tx extends BaseEntity {

  @Column(name = "hash", nullable = false, length = 64)
  @Hash32Type
  private String hash;

  @ManyToOne(fetch = FetchType.LAZY, optional = false)
  @OnDelete(action = OnDeleteAction.CASCADE)
  @JoinColumn(name = "block_id", nullable = false,
      foreignKey = @ForeignKey(name = "tx_block_id_fkey"))
  @EqualsAndHashCode.Exclude
  private Block block;

  @Column(name = "block_id", updatable = false, insertable = false)
  private Long blockId;

  @Column(name = "block_index")
  @Word31Type
  private Long blockIndex;

  @Column(name = "out_sum", precision = 20)
  @Lovelace
  @Digits(integer = 20, fraction = 0)
  private BigDecimal outSum;

  @Column(name = "fee", precision = 20)
  @Lovelace
  @Digits(integer = 20, fraction = 0)
  private BigDecimal fee;

  @Column(name = "deposit")
  private Long deposit;

  @Column(name = "size")
  @Word31Type
  private Integer size;

  @Column(name = "invalid_before", precision = 20)
  @Word64Type
  @Digits(integer = 20, fraction = 0)
  private BigDecimal invalidBefore;

  @Column(name = "invalid_hereafter", precision = 20)
  @Word64Type
  @Digits(integer = 20, fraction = 0)
  private BigDecimal invalidHereafter;

  @Column(name = "valid_contract")
  private Boolean validContract;

  @Column(name = "script_size")
  @Word31Type
  private Integer scriptSize;

  @OneToMany(mappedBy = "tx", cascade = CascadeType.REMOVE)
  private List<TxOut> txOutList;

  @OneToMany(mappedBy = "txInput", cascade = CascadeType.REMOVE)
  private List<TxIn> txInList;

  // For soft deletion -- start
  @OneToMany(mappedBy = "tx", cascade = CascadeType.REMOVE)
  private List<StakeAddress> stakeAddressList;

  @OneToMany(mappedBy = "tx", cascade = CascadeType.REMOVE)
  private List<FailedTxOut> failedTxOutList;

  @OneToMany(mappedBy = "registeredTx", cascade = CascadeType.REMOVE)
  private List<PoolMetadataRef> poolMetadataRefList;

  @OneToMany(mappedBy = "registeredTx", cascade = CascadeType.REMOVE)
  private List<PoolUpdate> poolUpdateList;

  @OneToMany(mappedBy = "announcedTx", cascade = CascadeType.REMOVE)
  private List<PoolRetire> poolRetireList;

  @OneToMany(mappedBy = "tx", cascade = CascadeType.REMOVE)
  private List<StakeRegistration> stakeRegistrationList;

  @OneToMany(mappedBy = "tx", cascade = CascadeType.REMOVE)
  private List<StakeDeregistration> stakeDeregistrationList;

  @OneToMany(mappedBy = "tx", cascade = CascadeType.REMOVE)
  private List<Delegation> delegationList;

  @OneToMany(mappedBy = "tx", cascade = CascadeType.REMOVE)
  private List<TxMetadata> txMetadataList;

  @OneToMany(mappedBy = "tx", cascade = CascadeType.REMOVE)
  private List<Withdrawal> withdrawalList;

  @OneToMany(mappedBy = "tx", cascade = CascadeType.REMOVE)
  private List<Treasury> treasuryList;

  @OneToMany(mappedBy = "tx", cascade = CascadeType.REMOVE)
  private List<Reserve> reserveList;

  @OneToMany(mappedBy = "tx", cascade = CascadeType.REMOVE)
  private List<PotTransfer> potTransferList;

  @OneToMany(mappedBy = "tx", cascade = CascadeType.REMOVE)
  private List<MaTxMint> maTxMintList;

  @OneToMany(mappedBy = "tx", cascade = CascadeType.REMOVE)
  private List<Redeemer> redeemerList;

  @OneToMany(mappedBy = "tx", cascade = CascadeType.REMOVE)
  private List<RedeemerData> redeemerDataList;

  @OneToMany(mappedBy = "tx", cascade = CascadeType.REMOVE)
  private List<Script> scriptList;

  @OneToMany(mappedBy = "tx", cascade = CascadeType.REMOVE)
  private List<Datum> datumList;

  @OneToMany(mappedBy = "tx", cascade = CascadeType.REMOVE)
  private List<ExtraKeyWitness> extraKeyWitnessList;

  @OneToMany(mappedBy = "txIn", cascade = CascadeType.REMOVE)
  private List<ReferenceTxIn> referenceTxInList;
  // For soft deletion -- end

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) {
      return false;
    }
    Tx tx = (Tx) o;
    return id != null && Objects.equals(id, tx.id);
  }

  @Override
  public int hashCode() {
    return getClass().hashCode();
  }
  public void addScriptSize(int size){
    if(this.size == null){
      this.size = 0;
    }
    this.size += size;
  }

}
