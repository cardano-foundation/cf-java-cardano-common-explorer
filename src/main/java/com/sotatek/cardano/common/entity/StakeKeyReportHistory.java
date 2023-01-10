package com.sotatek.cardano.common.entity;

import java.sql.Timestamp;
import java.util.Objects;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.hibernate.Hibernate;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name = "stake_key_report_history")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder(toBuilder = true)
public class StakeKeyReportHistory extends BaseEntity {

  @Column(name = "stake_key", nullable = false)
  private String stakeKey;

  @Column(name = "from_date", nullable = false)
  private Timestamp fromDate;

  @Column(name = "to_date", nullable = false)
  private Timestamp toDate;

  @Column(name = "is_ada_transfer", nullable = false)
  private Boolean isADATransfer;

  @Column(name = "is_fees_paid", nullable = false)
  private Boolean isFeesPaid;

  @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
  @OnDelete(action = OnDeleteAction.CASCADE)
  @JoinColumn(name = "report_id")
  @EqualsAndHashCode.Exclude
  private ReportHistory reportHistory;

  @ManyToMany(fetch = FetchType.EAGER)
  @JoinTable(name = "stake_key_report_history_event",
      joinColumns = @JoinColumn(name = "report_history_id", referencedColumnName = "id"),
      inverseJoinColumns = @JoinColumn(name = "event_type", referencedColumnName = "event_type"))
  @EqualsAndHashCode.Exclude
  private Set<StakingLifeCycleEvent> stakingLifeCycleEvents;

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) {
      return false;
    }
    StakeKeyReportHistory that = (StakeKeyReportHistory) o;
    return id != null && Objects.equals(id, that.id);
  }

  @Override
  public int hashCode() {
    return getClass().hashCode();
  }
}
