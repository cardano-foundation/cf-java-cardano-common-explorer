package com.sotatek.cardano.common.enumeration.converter;

import com.sotatek.cardano.common.enumeration.TxOutType;
import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = true)
public class TxOutTypeConverter implements AttributeConverter<TxOutType,Integer> {

  @Override
  public Integer convertToDatabaseColumn(TxOutType txOutType) {
    return txOutType.getValue();
  }

  @Override
  public TxOutType convertToEntityAttribute(Integer type) {
    return TxOutType.fromValue(type);
  }
}
