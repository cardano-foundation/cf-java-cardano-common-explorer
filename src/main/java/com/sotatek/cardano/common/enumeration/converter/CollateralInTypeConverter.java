package com.sotatek.cardano.common.enumeration.converter;

import com.sotatek.cardano.common.enumeration.CollateralInType;
import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = true)
public class CollateralInTypeConverter implements AttributeConverter<CollateralInType,Integer> {

  @Override
  public Integer convertToDatabaseColumn(CollateralInType collateralInType) {
    return collateralInType.getValue();
  }

  @Override
  public CollateralInType convertToEntityAttribute(Integer type) {
    return CollateralInType.fromValue(type);
  }
}
