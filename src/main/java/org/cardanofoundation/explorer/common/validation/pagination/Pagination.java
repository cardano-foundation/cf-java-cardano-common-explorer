package org.cardanofoundation.explorer.common.validation.pagination;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;

import lombok.Data;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

@Data
public class Pagination {
  @Min(value = 0, message = "Page number should be a positive integer")
  @Digits(integer = 10, fraction = 0, message = "Page size should be an integer")
  private Integer page;

  @Min(value = 1, message = "Page size should be a positive integer")
  @Max(value = 100, message = "Page size should not exceed 100")
  @Digits(integer = 10, fraction = 0, message = "Page size should be an integer")
  private Integer size;

  private List<String> sort;

  public Pageable toPageable() {
    this.setDefaultIfNull();
    return PageRequest.of(this.page, this.size, this.parseParameterIntoSort(this.sort));
  }

  private Sort parseParameterIntoSort(List<String> sort) {
    List<Sort.Order> orders =
        sort.stream()
            .map(
                t -> {
                  String[] s = this.reformat(t);
                  return new Sort.Order(this.toDirection(s[1]), s[0]);
                })
            .toList();
    return Sort.by(orders);
  }

  private String[] reformat(String singleSort) {
    if (!singleSort.contains(",")) return new String[] {singleSort, ""};
    return singleSort.split(",");
  }

  private Sort.Direction toDirection(String direction) {
    if (direction.equalsIgnoreCase("desc")) {
      return Sort.Direction.DESC;
    }
    return Sort.Direction.ASC;
  }

  private void setDefaultIfNull() {
    this.page = Objects.nonNull(this.page) ? this.page : Integer.valueOf(0);
    this.size = Objects.nonNull(this.size) ? this.size : Integer.valueOf(10);
    this.sort = Objects.nonNull(this.sort) ? this.sort : new ArrayList<>();
  }
}
