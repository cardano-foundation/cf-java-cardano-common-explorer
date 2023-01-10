package com.sotatek.cardano.common.entity;

import com.sotatek.cardano.common.enumeration.StakingLifeCycleEventType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "staking_life_cycle_event")
public class StakingLifeCycleEvent{

      @Enumerated(EnumType.STRING)
      @Id
      @Column(name = "event_type", nullable = false)
      private StakingLifeCycleEventType eventType;

      public StakingLifeCycleEventType getType() {
          return eventType;
      }

      public void setType(StakingLifeCycleEventType type) {
          this.eventType = type;
      }
}
