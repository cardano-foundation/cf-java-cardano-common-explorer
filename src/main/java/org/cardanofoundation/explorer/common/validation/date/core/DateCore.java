package org.cardanofoundation.explorer.common.validation.date.core;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.logging.log4j.util.Strings;

import org.cardanofoundation.explorer.common.validation.date.DatePattern;

public class DateCore {
  public static Date parse(String dateString, DatePattern datePattern, String paramName) {
    try {
      if (Strings.isBlank(dateString)) {
        return null;
      }
      SimpleDateFormat sdf = new SimpleDateFormat(datePattern.getFormatPattern());
      sdf.setLenient(true);
      return sdf.parse(dateString);
    } catch (ParseException e) {
      throw new IllegalArgumentException(
          paramName
              + " has an invalid date format. Valid date format: "
              + datePattern.getFormatPattern());
    }
  }
}
