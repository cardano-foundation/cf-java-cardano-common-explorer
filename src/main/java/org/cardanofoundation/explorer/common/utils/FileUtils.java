package org.cardanofoundation.explorer.common.utils;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Slf4j
public class FileUtils {

  public static String readFile(String url) {
    StringBuilder content = new StringBuilder();
    try {
      BufferedReader reader = new BufferedReader(new FileReader(url));
      String line;
      String ls = System.getProperty("line.separator");
      while ((line = reader.readLine()) != null) {
        content.append(line);
        content.append(ls);
      }
      content.deleteCharAt(content.length() - 1);
      reader.close();
    } catch (Exception ex) {
      log.error("Error: " + ex.getMessage());
    }
    return content.toString();
  }

  public static String readFileFromUrl(String url) {
    StringBuilder content = new StringBuilder();
    try (BufferedInputStream file = new BufferedInputStream(new FileInputStream(url))) {
      byte[] bytes = new byte[500];
      while (file.available() != 0) {
        file.read(bytes);
        content.append(new String(bytes));
      }
    } catch (IOException exception) {

    }
    return content.toString();
  }

  public static String readFileFromClasspath(String path) {
    StringBuilder content = new StringBuilder();
    try (BufferedInputStream file =
        new BufferedInputStream(FileUtils.class.getClassLoader().getResourceAsStream(path))) {
      byte[] bytes = new byte[500];
      while (file.available() != 0) {
        file.read(bytes);
        content.append(new String(bytes));
      }
    } catch (IOException exception) {

    }
    return content.toString();
  }
}
