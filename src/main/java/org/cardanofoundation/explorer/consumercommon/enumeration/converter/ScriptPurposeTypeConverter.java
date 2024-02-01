package org.cardanofoundation.explorer.consumercommon.enumeration.converter;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

import org.cardanofoundation.explorer.consumercommon.enumeration.ScriptPurposeType;

@Converter(autoApply = true)
public class ScriptPurposeTypeConverter implements AttributeConverter<ScriptPurposeType, String> {

  @Override
  public String convertToDatabaseColumn(ScriptPurposeType attribute) {
    return attribute.getValue();
  }

  @Override
  public ScriptPurposeType convertToEntityAttribute(String dbData) {
    return ScriptPurposeType.fromValue(dbData);
  }
}
