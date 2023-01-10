package com.sotatek.cardano.common.entity;

import com.sotatek.cardano.common.validation.Word63Type;
import jdk.jfr.Enabled;
import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "pool_report")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder(toBuilder = true)
public class PoolReport extends BaseEntity {

    @Column(name = "report_name", nullable = false)
    private String reportName;

    @Column(name = "pool_id", nullable = false)
    private String poolView;

    @Column(name = "is_pool_size", nullable = false)
    private Boolean isPoolSize;

    @Column(name = "is_fees_paid", nullable = false)
    private Boolean isFeesPaid;

    @Column(name = "begin_epoch", nullable = false)
    private Integer beginEpoch;

    @Column(name = "end_epoch", nullable = false)
    private Integer endEpoch;

    @Column(name = "event", nullable = false)
    private String event;

    @Column(name = "username")
    private String username;
}
