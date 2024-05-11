package org.cardanofoundation.explorer.common.util;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import org.cardanofoundation.explorer.common.model.ByronGenesis;
import org.cardanofoundation.explorer.common.model.ConwayGenesis;
import org.cardanofoundation.explorer.common.model.ShelleyGenesis;
import org.cardanofoundation.explorer.common.utils.FileUtils;
import org.cardanofoundation.explorer.common.utils.GenesisUtils;

class GenesisTest {

  @Test
  void when_readFile_success() {
    String shelleyPath = "./target/test-classes/genesis/shelley.json";
    String jsonShelley = FileUtils.readFile(shelleyPath);
    Assertions.assertNotNull(jsonShelley);
    JsonObject jsonShelleyObj = new Gson().fromJson(jsonShelley, JsonObject.class);
    Assertions.assertTrue(jsonShelleyObj.isJsonObject());
    Assertions.assertEquals(0.05, jsonShelleyObj.get("activeSlotsCoeff").getAsDouble());
    Assertions.assertEquals("Mainnet", jsonShelleyObj.get("networkId").getAsString());
    Assertions.assertEquals(5, jsonShelleyObj.get("updateQuorum").getAsInt());
    Assertions.assertEquals(1, jsonShelleyObj.get("networkMagic").getAsInt());
    Assertions.assertEquals(432000, jsonShelleyObj.get("epochLength").getAsInt());
  }

  @Test
  void when_readFile_findNotFound_returnEmpty() {
    String shelleyPath = "./target/test-classes/genesis/shelley-not-found.json";
    String jsonShelley = FileUtils.readFile(shelleyPath);
    Assertions.assertEquals("", jsonShelley);
  }

  @Test
  void when_getJsonContentUrl_success() {
    String shelleyUrl =
        "https://book.world.dev.cardano.org/environments/mainnet/shelley-genesis.json";
    String jsonShelley = GenesisUtils.getJsonContentUrl(shelleyUrl);
    Assertions.assertNotNull(jsonShelley);
    JsonObject jsonShelleyObj = new Gson().fromJson(jsonShelley, JsonObject.class);
    Assertions.assertTrue(jsonShelleyObj.isJsonObject());
    Assertions.assertEquals(0.05, jsonShelleyObj.get("activeSlotsCoeff").getAsDouble());
    Assertions.assertEquals("Mainnet", jsonShelleyObj.get("networkId").getAsString());
    Assertions.assertEquals(5, jsonShelleyObj.get("updateQuorum").getAsInt());
    Assertions.assertEquals(432000, jsonShelleyObj.get("epochLength").getAsInt());
  }

  @Test
  void when_getJsonContentUrl_fileNotFound_throwException() {
    String notFoundUrl =
        "https://book.world.dev.cardano.org/environments/mainnet/file-not-found.json";
    IllegalStateException exception =
        Assertions.assertThrows(
            IllegalStateException.class,
            () -> {
              GenesisUtils.getJsonContentUrl(notFoundUrl);
            });
    Assertions.assertNotNull(exception.getMessage());
  }

  @Test
  void when_fillContentUrlToShelley_success() {
    String shelleyUrl =
        "https://book.world.dev.cardano.org/environments/mainnet/shelley-genesis.json";
    ShelleyGenesis shelley = GenesisUtils.fillContentUrlToShelley(shelleyUrl);
    Assertions.assertNotNull(shelley);
    Assertions.assertEquals(0.05, shelley.getActiveSlotsCoeff());
    Assertions.assertEquals("Mainnet", shelley.getNetworkId());
    Assertions.assertEquals(5, shelley.getUpdateQuorum());
    Assertions.assertEquals(62, shelley.getMaxKESEvolutions());
    Assertions.assertEquals(2160, shelley.getSecurityParam());
  }

  @Test
  void when_fillContentUrlToShelley_fileNotFound_throwException() {
    String notFoundUrl =
        "https://book.world.dev.cardano.org/environments/mainnet/file-not-found.json";
    IllegalStateException exception =
        Assertions.assertThrows(
            IllegalStateException.class,
            () -> {
              GenesisUtils.fillContentUrlToShelley(notFoundUrl);
            });
    Assertions.assertNotNull(exception.getMessage());
  }

  @Test
  void when_fillContentUrlToByron_success() {
    String byronUrl = "https://book.world.dev.cardano.org/environments/mainnet/byron-genesis.json";
    ByronGenesis byron = GenesisUtils.fillContentUrlToByron(byronUrl);
    Assertions.assertNotNull(byron);
    Assertions.assertEquals(1506203091, byron.getStartTime());
    Assertions.assertEquals(
        "76617361206f7061736120736b6f766f726f64612047677572646120626f726f64612070726f766f6461",
        byron.getFtsSeed());
  }

  @Test
  void when_fillContentUrlToByron_fileNotFound_throwException() {
    String notFoundUrl =
        "https://book.world.dev.cardano.org/environments/mainnet/file-not-found.json";
    IllegalStateException exception =
        Assertions.assertThrows(
            IllegalStateException.class,
            () -> {
              GenesisUtils.fillContentUrlToByron(notFoundUrl);
            });
    Assertions.assertNotNull(exception.getMessage());
  }

  @Test
  void when_fillContentFileToShelley_success() {
    String shelleyPath = "./target/test-classes/genesis/shelley.json";
    ShelleyGenesis shelley = GenesisUtils.fillContentFileToShelley(shelleyPath);
    Assertions.assertNotNull(shelley);
    Assertions.assertEquals(0.05, shelley.getActiveSlotsCoeff());
    Assertions.assertEquals("Mainnet", shelley.getNetworkId());
    Assertions.assertEquals(5, shelley.getUpdateQuorum());
    Assertions.assertEquals(62, shelley.getMaxKESEvolutions());
    Assertions.assertEquals(2160, shelley.getSecurityParam());
  }

  @Test
  void when_fillContentFileToShelley_fileNotFound_returnNull() {
    String shelleyPath = "./target/test-classes/genesis/shelley-not-found.json";
    ShelleyGenesis shelley = GenesisUtils.fillContentFileToShelley(shelleyPath);
    Assertions.assertNull(shelley);
  }

  @Test
  void when_fillContentFileToByron_success() {
    String byronPath = "./target/test-classes/genesis/byron.json";
    ByronGenesis byron = GenesisUtils.fillContentFileToByron(byronPath);
    Assertions.assertNotNull(byron);
    Assertions.assertEquals(1506203091, byron.getStartTime());
    Assertions.assertEquals(
        "76617361206f7061736120736b6f766f726f64612047677572646120626f726f64612070726f766f6461",
        byron.getFtsSeed());
  }

  @Test
  void when_fillContentFileToByron_fileNotFound_returnNull() {
    String byronPath = "./target/test-classes/genesis/byron-not-found.json";
    ByronGenesis byron = GenesisUtils.fillContentFileToByron(byronPath);
    Assertions.assertNull(byron);
  }

  @Test
  void when_fillContentFileToConway_success() {
    String conwayPath = "./target/test-classes/genesis/conway.json";
    ConwayGenesis conway = GenesisUtils.fillContentFileToConway(conwayPath);
    Assertions.assertNotNull(conway);
    Assertions.assertEquals(7, conway.getCommitteeMinSize());
    Assertions.assertEquals(50000000000L, conway.getGovActionDeposit());
    Assertions.assertEquals(20, conway.getDRepActivity());
    Assertions.assertNotNull(conway.getPoolVotingThresholds());
    Assertions.assertNotNull(conway.getCommittee());
  }

  @Test
  void when_fillContentFileToConway_fileNotFound_returnNull() {
    String conwayPath = "./target/test-classes/genesis/conway-not-found.json";
    ConwayGenesis conway = GenesisUtils.fillContentFileToConway(conwayPath);
    Assertions.assertNull(conway);
  }

  @Test
  void when_fillContentUrlToConway_success() {
    String conwayUrl =
        "https://book.world.dev.cardano.org/environments/sanchonet/conway-genesis.json";
    ConwayGenesis conway = GenesisUtils.fillContentUrlToConway(conwayUrl);
    Assertions.assertNotNull(conway);
    Assertions.assertEquals(7, conway.getCommitteeMinSize());
    Assertions.assertEquals(44, conway.getMinFeeRefScriptCostPerByte());
  }

  @Test
  void when_fillContentUrlToConway_fileNotFound_throwException() {
    String notFoundUrl =
        "https://book.world.dev.cardano.org/environments/sanchonet/file-not-found.json";
    IllegalStateException exception =
        Assertions.assertThrows(
            IllegalStateException.class,
            () -> {
              GenesisUtils.fillContentUrlToConway(notFoundUrl);
            });
    Assertions.assertNotNull(exception.getMessage());
  }
}
