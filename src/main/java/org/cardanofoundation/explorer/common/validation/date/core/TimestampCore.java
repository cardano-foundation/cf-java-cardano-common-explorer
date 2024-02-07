package org.cardanofoundation.explorer.common.validation.date.core;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.logging.log4j.util.Strings;

import org.cardanofoundation.explorer.common.validation.date.DatePattern;

public class TimestampCore {
  public static Timestamp parse(String dateString, DatePattern datePattern, String paramName) {
    try {
      if (Strings.isBlank(dateString)) {
        return null;
      }
      SimpleDateFormat sdf = new SimpleDateFormat(datePattern.getFormatPattern());
      sdf.setLenient(true);
      Date date = sdf.parse(dateString);
      return new Timestamp(date.getTime());
    } catch (ParseException e) {
      throw new IllegalArgumentException(
          paramName
              + " has an invalid time format. Valid time format: "
              + datePattern.getFormatPattern());
    }
  }
}
