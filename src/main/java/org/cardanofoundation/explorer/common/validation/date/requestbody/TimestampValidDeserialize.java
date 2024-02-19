package org.cardanofoundation.explorer.common.validation.date.requestbody;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.deser.ContextualDeserializer;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

import org.cardanofoundation.explorer.common.validation.date.DatePattern;
import org.cardanofoundation.explorer.common.validation.date.core.TimestampCore;

@Component
public class TimestampValidDeserialize extends StdDeserializer<Timestamp>
    implements ContextualDeserializer {

  private DatePattern pattern;

  public TimestampValidDeserialize() {
    super(Date.class);
  }

  public TimestampValidDeserialize(DatePattern pattern) {
    super(Date.class);
    this.pattern = pattern;
  }

  @Override
  public JsonDeserializer<Timestamp> createContextual(
      DeserializationContext ctxt, BeanProperty property) {
    JsonPattern datePattern = property.getAnnotation(JsonPattern.class);
    if (datePattern != null) {
      return new TimestampValidDeserialize(datePattern.pattern());
    }
    return new TimestampValidDeserialize(DatePattern.YYYY_MM_DD_HH_MM_SS);
  }

  @Override
  public Timestamp deserialize(JsonParser jsonparser, DeserializationContext context)
      throws IOException {
    return TimestampCore.parse(jsonparser.getText(), pattern, jsonparser.currentName());
  }
}
