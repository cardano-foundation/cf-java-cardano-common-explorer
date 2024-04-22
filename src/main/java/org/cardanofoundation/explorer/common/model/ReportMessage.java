package org.cardanofoundation.explorer.common.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import org.cardanofoundation.explorer.common.entity.explorer.ReportHistory;

@Getter
@Setter
@Builder
public class ReportMessage {

  private ReportHistory reportHistory;
  private Long zoneOffset;
  private String timePattern;
}
