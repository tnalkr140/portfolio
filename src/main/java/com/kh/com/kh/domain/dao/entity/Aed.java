package com.kh.com.kh.domain.dao.entity;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class Aed {
  @NotBlank
  private String lat;
  @NotBlank
  private String lng;
  private String pageNo;
  private String numOfRows;
}
