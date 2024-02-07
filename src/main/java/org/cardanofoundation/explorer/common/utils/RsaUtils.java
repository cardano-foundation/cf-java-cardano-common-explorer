package org.cardanofoundation.explorer.common.utils;

import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import org.cardanofoundation.explorer.common.exception.BusinessException;
import org.cardanofoundation.explorer.common.exception.CommonErrorCode;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class RsaUtils {

  /*
   * @since: 11/11/2022
   * description: Parse Private Key from String
   * @update:
   */
  public static PrivateKey getPrivateKey(String privateKey) {
    byte[] bytes = Base64.getDecoder().decode(privateKey);
    PKCS8EncodedKeySpec spec = new PKCS8EncodedKeySpec(bytes);
    try {
      KeyFactory factory = KeyFactory.getInstance("RSA");
      return factory.generatePrivate(spec);
    } catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
      throw new BusinessException(CommonErrorCode.UNKNOWN_ERROR);
    }
  }

  /*
   * @since: 11/11/2022
   * description: Parse Public Key from String
   * @update:
   */
  public static PublicKey getPublicKey(String publicKey) {
    byte[] bytes = Base64.getDecoder().decode(publicKey);
    X509EncodedKeySpec spec = new X509EncodedKeySpec(bytes);
    try {
      KeyFactory factory = KeyFactory.getInstance("RSA");
      return factory.generatePublic(spec);
    } catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
      throw new BusinessException(CommonErrorCode.UNKNOWN_ERROR);
    }
  }
}
