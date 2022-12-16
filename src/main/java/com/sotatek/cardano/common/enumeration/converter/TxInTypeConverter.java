package com.sotatek.cardano.common.enumeration.converter;

import com.sotatek.cardano.common.enumeration.TxInType;
import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = true)
public class TxInTypeConverter implements AttributeConverter<TxInType,Integer> {

  @Override
  public Integer convertToDatabaseColumn(TxInType txInType) {
    return txInType.getValue();
  }

  @Override
  public TxInType convertToEntityAttribute(Integer type) {
    return TxInType.fromValue(type);
  }
}
