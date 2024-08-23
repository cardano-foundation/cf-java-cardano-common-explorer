package org.cardanofoundation.explorer.common.utils;

import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Arrays;
import java.util.List;

public final class UrlUtil {

  private UrlUtil() {}

  private static final char BACKSPACE = '\b';
  private static final List<Character> SPECIAL_CHARACTERS =
      Arrays.asList('\n', '\0', '\t', '\r', '\f', '\\', '\u0007', BACKSPACE);

  /**
   * Remove backspace in url string
   *
   * @param url
   * @return
   */
  public static String formatSpecialCharactersUrl(String url) {

    StringBuilder builder = new StringBuilder();

    for (int i = 0; i < url.length(); i++) {
      char character = url.charAt(i);

      if (SPECIAL_CHARACTERS.contains(character)) {
        if (character == BACKSPACE) {
          builder.deleteCharAt(builder.length() - 1);
        }
        continue;
      }

      builder.append(url.charAt(i));
    }
    return builder.toString().replaceAll(":/{2,}", "://");
  }

  /**
   * Check input string with regex is URL or not
   *
   * @param string url string
   * @return boolean if url string return true else return false
   */
  public static boolean isUrl(String string) {
    try {
      new URL(string).toURI();
      return true;
    } catch (MalformedURLException e) {
      return false;
    } catch (URISyntaxException e) {
      return false;
    }
  }
}
