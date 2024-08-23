package org.cardanofoundation.explorer.common.entity.enumeration.converter;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

import org.cardanofoundation.explorer.common.entity.enumeration.CommitteeState;

@Converter(autoApply = true)
public class CommitteeStateConverter implements AttributeConverter<CommitteeState, String> {

  @Override
  public String convertToDatabaseColumn(CommitteeState attribute) {
    return attribute.getValue();
  }

  @Override
  public CommitteeState convertToEntityAttribute(String dbData) {
    return CommitteeState.fromValue(dbData);
  }
}
