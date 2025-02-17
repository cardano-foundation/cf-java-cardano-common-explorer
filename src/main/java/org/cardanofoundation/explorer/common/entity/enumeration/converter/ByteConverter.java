package org.cardanofoundation.explorer.common.entity.enumeration.converter;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

import com.bloxbean.cardano.client.util.HexUtil;

@Converter
public class ByteConverter implements AttributeConverter<String, byte[]> {

  @Override
  public byte[] convertToDatabaseColumn(String data) {
    return HexUtil.decodeHexString(data);
  }

  @Override
  public String convertToEntityAttribute(byte[] bytes) {
    return HexUtil.encodeHexString(bytes);
  }
}
