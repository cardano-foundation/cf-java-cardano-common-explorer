package org.cardanofoundation.explorer.common.entity.enumeration.converter;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

import org.cardanofoundation.explorer.common.entity.enumeration.TokenType;

@Converter(autoApply = true)
public class TokenTypeConverter implements AttributeConverter<TokenType, Integer> {

  @Override
  public Integer convertToDatabaseColumn(TokenType tokenType) {
    return tokenType.getValue();
  }

  @Override
  public TokenType convertToEntityAttribute(Integer type) {
    return TokenType.fromValue(type);
  }
}
