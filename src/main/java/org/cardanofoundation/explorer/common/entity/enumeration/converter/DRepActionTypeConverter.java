package org.cardanofoundation.explorer.common.entity.enumeration.converter;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

import org.cardanofoundation.explorer.common.entity.enumeration.DRepActionType;

@Converter(autoApply = true)
public class DRepActionTypeConverter implements AttributeConverter<DRepActionType, String> {

  @Override
  public String convertToDatabaseColumn(DRepActionType attribute) {
    return attribute.getValue();
  }

  @Override
  public DRepActionType convertToEntityAttribute(String dbData) {
    return DRepActionType.fromValue(dbData);
  }
}
