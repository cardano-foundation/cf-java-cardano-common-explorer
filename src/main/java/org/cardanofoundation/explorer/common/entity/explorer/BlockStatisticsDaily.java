package org.cardanofoundation.explorer.common.entity.explorer;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

import lombok.*;
import lombok.experimental.SuperBuilder;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import org.cardanofoundation.explorer.common.entity.ledgersync.BaseEntity;

@Entity
@Table(
    name = "block_statistics_daily",
    uniqueConstraints = {
      @UniqueConstraint(
          name = "block_statistics_daily",
          columnNames = {"epoch_no"})
    })
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder(toBuilder = true)
public class BlockStatisticsDaily extends BaseEntity {
  @Column(name = "time", nullable = false)
  @JsonProperty("time")
  @JsonFormat(pattern = "yyyy-MM-dd")
  private LocalDate time;

  @Column(name = "epoch_no", nullable = false)
  @JsonProperty("epoch_no")
  private Integer epochNo;

  @Column(name = "no_reporting_nodes")
  @JsonProperty("no_reporting_nodes")
  private Integer noReportingNodes;

  @Column(name = "no_unique_peers")
  @JsonProperty("no_unique_peers")
  private Integer noUniquePeers;

  @Column(name = "no_countries")
  @JsonProperty("no_countries")
  private Integer noCountries;

  @Column(name = "no_continents")
  @JsonProperty("no_continents")
  private Integer noContinents;

  @Column(name = "block_prop_mean")
  @JsonProperty("block_prop_mean")
  private Integer blockPropMean;

  @Column(name = "block_prop_median")
  @JsonProperty("block_prop_median")
  private Integer blockPropMedian;

  @Column(name = "block_prop_p90")
  @JsonProperty("block_prop_p90")
  private Integer blockPropP90;

  @Column(name = "block_prop_p95")
  @JsonProperty("block_prop_p95")
  private Integer blockPropP95;

  @Column(name = "block_adopt_mean")
  @JsonProperty("block_adopt_mean")
  private Integer blockAdoptMean;

  @Column(name = "block_adopt_median")
  @JsonProperty("block_adopt_median")
  private Integer blockAdoptMedian;

  @Column(name = "block_adopt_p90")
  @JsonProperty("block_adopt_p90")
  private Integer blockAdoptP90;

  @Column(name = "block_adopt_p95")
  @JsonProperty("block_adopt_p95")
  private Integer blockAdoptP95;

  @Column(name = "txs")
  @JsonProperty("txs")
  private Long txs;

  @Column(name = "mean_size_load")
  @JsonProperty("mean_size_load")
  private Double meanSizeLoad;

  @Column(name = "mean_steps_load")
  @JsonProperty("mean_steps_load")
  private Double meanStepsLoad;

  @Column(name = "mean_mem_load")
  @JsonProperty("mean_mem_load")
  private Double meanMemLoad;

  @Column(name = "slot_battles")
  @JsonProperty("slot_battles")
  private Integer slotBattles;

  @Column(name = "height_battles")
  @JsonProperty("height_battles")
  private Integer heightBattles;

  @Column(name = "cdf3")
  @JsonProperty("cdf3")
  private Double cdf3;

  @Column(name = "cdf5")
  @JsonProperty("cdf5")
  private Double cdf5;
}
