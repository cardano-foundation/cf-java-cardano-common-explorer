package org.cardanofoundation.explorer.common.utils;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Log4j2
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class StringUtils {

  /*
   * @since: 24/10/2022
   * description: validate string null and empty
   * @update:
   */
  public static Boolean isNullOrEmpty(String str) {
    return str == null || str.trim().length() == 0;
  }

  /*
   * @since: 07/11/2022
   * description: validate string null and empty
   * @update:
   */
  public static Boolean isNotBlank(String str) {
    return !isNullOrEmpty(str);
  }

  /*
   * @since: 16/11/2022
   * description: validate is numeric
   * @update:
   */
  public static Boolean isNumeric(String strNum) {
    if (Boolean.TRUE.equals(isNullOrEmpty(strNum))) {
      return false;
    }
    try {
      Long.parseLong(strNum);
    } catch (NumberFormatException ex) {
      log.error("error parse number: " + ex.getMessage());
      return false;
    }
    return true;
  }
}
