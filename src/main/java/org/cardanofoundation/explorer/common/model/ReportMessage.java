package org.cardanofoundation.explorer.common.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import org.cardanofoundation.explorer.common.entity.explorer.ReportHistory;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class ReportMessage {

  private ReportHistory reportHistory;
  private Long zoneOffset;
  private String timePattern;
  private String dateFormat;
  private String poolId;
  private String stakeAddress;
}
