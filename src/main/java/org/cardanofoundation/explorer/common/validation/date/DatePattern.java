package org.cardanofoundation.explorer.common.validation.date;

public enum DatePattern {
  YYYY_MM_DD("yyyy/MM/dd"),
  YYYY_MM_DD_HH_MM_SS("yyyy/MM/dd hh:mm:ss"),
  DD_MM_YYYY("dd/MM/yyyy"),
  DD_MM_YYYY_HH_MM_SS("dd/MM/yyyy hh:mm:ss"),
  MM_DD_YYYY("MM/dd/yyyy"),
  MM_DD_YYYY_HH_MM_SS("MM/dd/yyyy hh:mm:ss");

  private final String formatPattern;

  DatePattern(String formatPattern) {
    this.formatPattern = formatPattern;
  }

  public final String getFormatPattern() {
    return formatPattern;
  }
}
