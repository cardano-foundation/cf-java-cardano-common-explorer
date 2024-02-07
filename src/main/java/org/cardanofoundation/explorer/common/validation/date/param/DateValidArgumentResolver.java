package org.cardanofoundation.explorer.common.validation.date.param;

import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.cardanofoundation.explorer.common.validation.date.DatePattern;
import org.cardanofoundation.explorer.common.validation.date.core.DateCore;

public class DateValidArgumentResolver implements HandlerMethodArgumentResolver {

  private MethodParameter parameter;

  private NativeWebRequest webRequest;

  @Override
  public boolean supportsParameter(MethodParameter parameter) {
    return parameter.hasParameterAnnotation(DateValid.class);
  }

  @Override
  public Object resolveArgument(
      MethodParameter parameter,
      ModelAndViewContainer mavContainer,
      NativeWebRequest webRequest,
      WebDataBinderFactory binderFactory) {
    this.initialize(parameter, webRequest);
    if (parameter.getParameterType().equals(Date.class)) {
      return DateCore.parse(this.getDateString(), this.getPattern(), parameter.getParameterName());
    } else {
      Map<String, Object> requestBody = this.getRequestBody(webRequest.getParameterMap());
      this.getFieldsWithDateValidAnnotation()
          .forEach(
              field ->
                  this.update(
                      requestBody,
                      field,
                      DateCore.parse(
                          this.getDateString(requestBody, field),
                          this.getPattern(field),
                          field.getName())));
      return this.done(requestBody, parameter.getParameterType());
    }
  }

  private void initialize(MethodParameter parameter, NativeWebRequest webRequest) {
    this.parameter = parameter;
    this.webRequest = webRequest;
  }

  private DatePattern getPattern() {
    try {
      return Objects.requireNonNull(this.parameter.getParameterAnnotation(DateValid.class))
          .pattern();
    } catch (NullPointerException e) {
      return DatePattern.YYYY_MM_DD;
    }
  }

  private DatePattern getPattern(Field field) {
    return field.getAnnotation(DateValid.class).pattern();
  }

  private String getDateString(Map<String, Object> parameterMap, Field field) {
    Object valued = parameterMap.get(field.getName());
    return Objects.isNull(valued) ? null : valued.toString();
  }

  private String getDateString() {
    try {
      return this.webRequest.getParameter(
          Objects.requireNonNull(this.parameter.getParameterName()));
    } catch (NullPointerException e) {
      return null;
    }
  }

  private void update(Map<String, Object> parameterMap, Field field, Date date) {
    parameterMap.put(field.getName(), date);
  }

  private List<Field> getFieldsWithDateValidAnnotation() {
    List<Field> fields =
        Arrays.stream(this.parameter.getParameterType().getDeclaredFields())
            .filter(
                field ->
                    Arrays.stream(field.getDeclaredAnnotations())
                        .anyMatch(t -> t instanceof DateValid))
            .collect(Collectors.toList());
    if (fields.size() == 0) {
      throw new IllegalArgumentException(
          "No fields with annotation @DateValid were found in Object");
    }
    return fields;
  }

  private Map<String, Object> getRequestBody(Map<String, String[]> parameterMap) {
    return parameterMap.keySet().stream()
        .collect(Collectors.toMap(key -> key, key -> parameterMap.get(key)[0]));
  }

  private <T> T done(Map<String, Object> parameterMap, Class<T> classOfT) {
    ObjectMapper objectMapper = new ObjectMapper();
    objectMapper.setDateFormat(new SimpleDateFormat(DatePattern.YYYY_MM_DD.getFormatPattern()));
    objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    try {
      return objectMapper.convertValue(parameterMap, classOfT);
    } catch (IllegalArgumentException e) {
      e.printStackTrace();
      throw new IllegalArgumentException("Parsing error");
    }
  }
}
