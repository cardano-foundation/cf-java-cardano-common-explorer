package org.cardanofoundation.explorer.common.utils;

import java.net.URL;
import java.nio.charset.StandardCharsets;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import com.google.gson.Gson;
import org.apache.commons.io.IOUtils;

import org.cardanofoundation.explorer.common.model.ByronGenesis;
import org.cardanofoundation.explorer.common.model.ConwayGenesis;
import org.cardanofoundation.explorer.common.model.ShelleyGenesis;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Slf4j
public class GenesisUtils {

  public static String getJsonContentUrl(String url) {
    try {
      URL fileUrl = new URL(url);
      return IOUtils.toString(fileUrl, StandardCharsets.UTF_8);
    } catch (Exception e) {
      log.error("exception {} with url {}", e.getMessage(), url);
      throw new IllegalStateException("can't load file " + url);
    }
  }

  public static String getJsonContentFile(String url) {
    try {
      return FileUtils.readFileFromClasspath(url);
    } catch (Exception e) {
      log.error("exception {} with url {}", e.getMessage(), url);
      throw new IllegalStateException("can't load file " + url);
    }
  }

  public static ShelleyGenesis fillContentUrlToShelley(String url) {
    try {
      Gson gson = new Gson();
      URL fileUrl = new URL(url);
      String shelleyJson = IOUtils.toString(fileUrl, StandardCharsets.UTF_8);
      return gson.fromJson(shelleyJson, ShelleyGenesis.class);
    } catch (Exception e) {
      log.error("exception {} with url {}", e.getMessage(), url);
      throw new IllegalStateException("can't load file " + url);
    }
  }

  public static ByronGenesis fillContentUrlToByron(String url) {
    try {
      Gson gson = new Gson();
      URL fileUrl = new URL(url);
      String byronJson = IOUtils.toString(fileUrl, StandardCharsets.UTF_8);
      return gson.fromJson(byronJson, ByronGenesis.class);
    } catch (Exception e) {
      log.error("exception {} with url {}", e.getMessage(), url);
      throw new IllegalStateException("can't load file " + url);
    }
  }

  public static ShelleyGenesis fillContentFileToShelley(String url) {
    try {
      Gson gson = new Gson();
      String shelleyJson = FileUtils.readFile(url);
      return gson.fromJson(shelleyJson, ShelleyGenesis.class);
    } catch (Exception e) {
      log.error("exception {} with url {}", e.getMessage(), url);
      throw new IllegalStateException("can't load file " + url);
    }
  }

  public static ByronGenesis fillContentFileToByron(String url) {
    try {
      Gson gson = new Gson();
      String byronJson = FileUtils.readFile(url);
      return gson.fromJson(byronJson, ByronGenesis.class);
    } catch (Exception e) {
      log.error("exception {} with url {}", e.getMessage(), url);
      throw new IllegalStateException("can't load file " + url);
    }
  }

  public static ConwayGenesis fillContentFileToConway(String url) {
    try {
      Gson gson = new Gson();
      String conwayJson = FileUtils.readFile(url);
      return gson.fromJson(conwayJson, ConwayGenesis.class);
    } catch (Exception e) {
      log.error("exception {} with url {}", e.getMessage(), url);
      throw new IllegalStateException("can't load file " + url);
    }
  }

  public static ConwayGenesis fillContentUrlToConway(String url) {
    try {
      Gson gson = new Gson();
      URL fileUrl = new URL(url);
      String conwayJson = IOUtils.toString(fileUrl, StandardCharsets.UTF_8);
      return gson.fromJson(conwayJson, ConwayGenesis.class);
    } catch (Exception e) {
      log.error("exception {} with url {}", e.getMessage(), url);
      throw new IllegalStateException("can't load file " + url);
    }
  }
}
